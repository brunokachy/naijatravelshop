package com.naijatravelshop.service.hotel.service.impl;

import com.naijatravelshop.persistence.model.enums.*;
import com.naijatravelshop.persistence.model.hotel.HotelBookingDetail;
import com.naijatravelshop.persistence.model.hotel.Location;
import com.naijatravelshop.persistence.model.hotel.RoomOffer;
import com.naijatravelshop.persistence.model.payment.PaymentHistory;
import com.naijatravelshop.persistence.model.portal.*;
import com.naijatravelshop.persistence.repository.hotel.FacilityRepository;
import com.naijatravelshop.persistence.repository.hotel.HotelBookingDetailRepository;
import com.naijatravelshop.persistence.repository.hotel.PropertyRepository;
import com.naijatravelshop.persistence.repository.hotel.RoomOfferRepository;
import com.naijatravelshop.persistence.repository.payment.PaymentHistoryRepository;
import com.naijatravelshop.persistence.repository.portal.*;
import com.naijatravelshop.persistence.service.LocationService;
import com.naijatravelshop.service.hotel.pojos.request.JacTravelApiCredential;
import com.naijatravelshop.service.hotel.pojos.request.book.BookRequest;
import com.naijatravelshop.service.hotel.pojos.request.book.BookingDetail;
import com.naijatravelshop.service.hotel.pojos.request.book.Guest;
import com.naijatravelshop.service.hotel.pojos.request.book.RoomBooking;
import com.naijatravelshop.service.hotel.pojos.request.prebook.PreBookRequest;
import com.naijatravelshop.service.hotel.pojos.request.search.RoomRequest;
import com.naijatravelshop.service.hotel.pojos.request.search.SearchDetail;
import com.naijatravelshop.service.hotel.pojos.request.search.SearchHotelRequest;
import com.naijatravelshop.service.hotel.pojos.response.LocationPojo;
import com.naijatravelshop.service.hotel.pojos.response.PropertyResponse;
import com.naijatravelshop.service.hotel.pojos.response.book.BookResponse;
import com.naijatravelshop.service.hotel.pojos.response.prebook.Cancellation;
import com.naijatravelshop.service.hotel.pojos.response.prebook.PreBookResponse;
import com.naijatravelshop.service.hotel.pojos.response.propertydetail.Facility;
import com.naijatravelshop.service.hotel.pojos.response.search.PropertyResult;
import com.naijatravelshop.service.hotel.pojos.response.search.SearchHotelResponse;
import com.naijatravelshop.service.hotel.service.HotelService;
import com.naijatravelshop.service.hotel.util.Util;
import com.naijatravelshop.web.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static javax.xml.bind.JAXBContext.newInstance;

@Service
public class HotelServiceImpl implements HotelService {
    private Util util;
    private LocationService locationService;
    private FacilityRepository facilityRepository;
    private PropertyRepository propertyRepository;
    private HotelBookingDetailRepository hotelBookingDetailRepository;
    private ReservationRepository reservationRepository;
    private ReservationOwnerRepository reservationOwnerRepository;
    private AddressRepository addressRepository;
    private CountryRepository countryRepository;
    private PaymentHistoryRepository paymentHistoryRepository;
    private CancellationPolicyRepository cancellationPolicyRepository;
    private RoomOfferRepository roomOfferRepository;
    private TravellerRepository travellerRepository;

    @Value("${jactravel_api_username}")
    private String apiUsername;

    @Value("${jactravel_api_password}")
    private String apiPassword;

    public HotelServiceImpl(Util util, LocationService locationService,
                            FacilityRepository facilityRepository,
                            PropertyRepository propertyRepository,
                            ReservationRepository reservationRepository,
                            HotelBookingDetailRepository hotelBookingDetailRepository,
                            ReservationOwnerRepository reservationOwnerRepository,
                            AddressRepository addressRepository,
                            CountryRepository countryRepository,
                            PaymentHistoryRepository paymentHistoryRepository,
                            CancellationPolicyRepository cancellationPolicyRepository,
                            RoomOfferRepository roomOfferRepository,
                            TravellerRepository travellerRepository) {
        this.util = util;
        this.locationService = locationService;
        this.facilityRepository = facilityRepository;
        this.propertyRepository = propertyRepository;
        this.reservationRepository = reservationRepository;
        this.reservationOwnerRepository = reservationOwnerRepository;
        this.hotelBookingDetailRepository = hotelBookingDetailRepository;
        this.addressRepository = addressRepository;
        this.countryRepository = countryRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.cancellationPolicyRepository = cancellationPolicyRepository;
        this.roomOfferRepository = roomOfferRepository;
        this.travellerRepository = travellerRepository;
    }

    @Override
    public List<PropertyResult> handleSearchHotelRequest(SearchDetail searchDetail) {
        Optional<SearchDetail> searchDetailsOpt = Optional.ofNullable(searchDetail);
        if (!searchDetailsOpt.isPresent()) {
            throw new BadRequestException("Search Detail is null");
        }

        if (StringUtils.isEmpty(searchDetail.getCheckInDate()) || searchDetail.getDuration() < 1
                || searchDetail.getRegionID() < 1) {
            throw new BadRequestException("Missing required details");
        }


        try {
            LocalDate localDate = LocalDate.parse(searchDetail.getCheckInDate());
            if (localDate.isBefore(LocalDate.now())) {
                throw new BadRequestException("Check-in date cannot be further than current date.");
            }
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid check in date format");
        }

        List<RoomRequest> roomRequests = searchDetail.getRoomRequests();
        for (RoomRequest roomRequest : roomRequests) {
            guestValidation(roomRequest.getAdults(), roomRequest.getInfants(), roomRequest.getChildren());
        }

        SearchHotelRequest searchRequest = new SearchHotelRequest();
        searchRequest.setLoginDetails(getLoginDetails());
        searchRequest.setSearchDetails(searchDetail);

        String requestBody = util.jaxbObjectToXML(searchRequest);
        String responseBody = util.makeApiCall(requestBody);
        List<PropertyResult> results = new ArrayList<>();
        try {
            JAXBContext jaxbContext = newInstance(SearchHotelResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(responseBody);
            SearchHotelResponse tResponse = (SearchHotelResponse) jaxbUnmarshaller.unmarshal(reader);
            results.addAll(tResponse.getPropertyResults());
        } catch (JAXBException ex) {
            Logger.getLogger(HotelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }


    @Override
    public PreBookResponse handlePreBookRequest(PreBookRequest preBookRequest) {

        Optional<PreBookRequest> preBookRequestOpt = Optional.ofNullable(preBookRequest);
        if (!preBookRequestOpt.isPresent()) {
            throw new BadRequestException("Pre Book Request is null");
        }

        bookingDetailsValidation(preBookRequest.getBookingDetails());

        for (RoomBooking booking : preBookRequest.getBookingDetails().getRoomBookings()) {
            if (booking.getAdults() < 1) {
                throw new BadRequestException("Number of adults must be at least 1");
            }
            if (booking.getInfants() < 0 || booking.getChildren() < 0) {
                throw new BadRequestException("Invalid number of guest provided");
            }
        }

        preBookRequest.setLoginDetails(getLoginDetails());
        PreBookResponse preBookResponse = new PreBookResponse();
        String requestBody = util.jaxbObjectToXML(preBookRequest);
        String responseBody = util.makeApiCall(requestBody);
        try {
            JAXBContext jaxbContext = newInstance(PreBookResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(responseBody);
            preBookResponse = (PreBookResponse) jaxbUnmarshaller.unmarshal(reader);

        } catch (JAXBException ex) {
            Logger.getLogger(HotelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preBookResponse;

    }

    @Override
    public BookResponse handleBookRequest(BookRequest bookRequest) {

        Optional<BookRequest> bookRequestOpt = Optional.ofNullable(bookRequest);
        if (!bookRequestOpt.isPresent()) {
            throw new BadRequestException("Book Request is null");
        }

        bookingDetailsValidation(bookRequest.getBookingDetails());

        for (RoomBooking booking : bookRequest.getBookingDetails().getRoomBookings()) {
            guestValidation(booking.getAdults(), booking.getInfants(), booking.getChildren());
            if (booking.getGuests().isEmpty()) throw new BadRequestException("Invalid number of guest provided");
        }

        Reservation reservation = createReservation(bookRequest);
        BookResponse bookResponse = new BookResponse();
        bookResponse.setBookingReference(reservation.getId().toString());
        bookResponse.setCustomerTotalPrice(reservation.getActualAmountInKobo().doubleValue());
        bookResponse.setTradeReference(reservation.getBookingNumber());

//        bookRequest.setLoginDetails(getLoginDetails());
//        BookResponse bookResponse = new BookResponse();
//        String requestBody = util.jaxbObjectToXML(bookRequest);
//        String responseBody = util.makeApiCall(requestBody);
//        try {
//            JAXBContext jaxbContext = newInstance(BookResponse.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            StringReader reader = new StringReader(responseBody);
//            bookResponse = (BookResponse) jaxbUnmarshaller.unmarshal(reader);
//
//        } catch (JAXBException ex) {
//            Logger.getLogger(HotelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return bookResponse;
    }

//    @Override
//    public PreCancelResponse handlePreCancelRequest(PreCancelRequest preCancelRequest) {
//        Optional<PreCancelRequest> preCancelRequestOpt = Optional.ofNullable(preCancelRequest);
//        if (!preCancelRequestOpt.isPresent()) {
//            throw new BadRequestException("Pre-Cancel Request is null");
//        }
//
//        if (StringUtils.isEmpty(preCancelRequest.getBookingReference())) {
//            throw new BadRequestException("Missing required details");
//        }
//
//        preCancelRequest.setLoginDetails(getLoginDetails());
//
//        PreCancelResponse preCancelResponse = new PreCancelResponse();
//
//        try {
//            String requestBody = util.jaxbObjectToXML(preCancelRequest);
//            String result = util.makeApiCall(requestBody);
//
//            JAXBContext jaxbContext = newInstance(preCancelResponse.getClass());
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            StringReader reader = new StringReader(result);
//            preCancelResponse = (PreCancelResponse) jaxbUnmarshaller.unmarshal(reader);
//
//            return preCancelResponse;
//
//        } catch (JAXBException ex) {
//            Logger.getLogger(HotelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            return preCancelResponse;
//        }
//
//    }

//    @Override
//    public CancelResponse handleCancelRequest(CancelRequest cancelRequest) {
//        Optional<CancelRequest> cancelRequestOpt = Optional.ofNullable(cancelRequest);
//        if (!cancelRequestOpt.isPresent()) {
//            throw new BadRequestException("Cancel Request is null");
//        }
//
//        if (StringUtils.isEmpty(cancelRequest.getBookingReference())
//                || StringUtils.isEmpty(cancelRequest.getCancellationToken())
//                || cancelRequest.getCancellationCost() == null) {
//            throw new BadRequestException("Missing required details");
//        }
//
//        cancelRequest.setLoginDetails(getLoginDetails());
//        CancelResponse cancelResponse = new CancelResponse();
//        try {
//            String requestBody = util.jaxbObjectToXML(cancelRequest);
//            String result = util.makeApiCall(requestBody);
//            JAXBContext jaxbContext = newInstance(cancelResponse.getClass());
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            StringReader reader = new StringReader(result);
//            cancelResponse = (CancelResponse) jaxbUnmarshaller.unmarshal(reader);
//
//            if(cancelResponse.getReturnStatus().isSuccess()){
//                Optional<HotelBookingDetail> optHotelBookingDetail = hotelBookingDetailRepository.
//                        findFirstBySupplierReference(cancelRequest.getBookingReference());
//
//                if(optHotelBookingDetail.isPresent()){
//                    Optional<Reservation> optReservation =
//                            reservationRepository.findById(optHotelBookingDetail.get().getReservation().getId());
//                    if(optReservation.isPresent()){
//                        Reservation reservation = optReservation.get();
//                        reservation.setReservationStatus(ProcessStatus.CANCELLED);
//                        reservation.setLastUpdated(new Timestamp(new Date().getTime()));
//                        reservationRepository.save(reservation);
//                    }
//                }
//
//            }
//
//            return cancelResponse;
//
//        } catch (JAXBException ex) {
//            Logger.getLogger(HotelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            return cancelResponse;
//        }
//    }

//    @Override
//    public BookingResponse handleSearchBooking(BookHistoryRequest bookHistoryRequest) {
//        Optional<BookHistoryRequest> bookHistoryRequestOpt = Optional.ofNullable(bookHistoryRequest);
//        if (!bookHistoryRequestOpt.isPresent()) {
//            throw new BadRequestException("Search Booking Request is null");
//        }
//
//        if (StringUtils.isEmpty(bookHistoryRequest.getBookingReference())) {
//            throw new BadRequestException("Missing required details");
//        }
//
//        bookHistoryRequest.setLoginDetails(getLoginDetails());
//        BookingResponse bookingResponse = new BookingResponse();
//        try {
//            String requestBody = util.jaxbObjectToXML(bookHistoryRequest);
//            String result = util.makeApiCall(requestBody);
//            JAXBContext jaxbContext = newInstance(bookingResponse.getClass());
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            StringReader reader = new StringReader(result);
//            bookingResponse = (BookingResponse) jaxbUnmarshaller.unmarshal(reader);
//
//            return bookingResponse;
//        } catch (JAXBException ex) {
//            Logger.getLogger(HotelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            return bookingResponse;
//        }
//    }

    @Override
    public List<LocationPojo> getHotelSearchLocation(String query) {
        List<Location> locationList = locationService.getLocationsByRegion(query);

        List<Location> uniqueLocation = locationList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(()
                                -> new TreeSet<>(Comparator.comparingInt(Location::getRegionID))),
                        ArrayList::new));
        List<LocationPojo> locationPojoList = new ArrayList<>();

        for (Location l : uniqueLocation) {
            LocationPojo ll = new LocationPojo();
            ll.setCountry(l.getCountry());
            ll.setRegion(l.getRegion());
            ll.setRegionID(l.getRegionID());
            locationPojoList.add(ll);
        }

        return locationPojoList;
    }

    @Override
    public List<Facility> getHotelFacility(List<Long> facilityIds) {
        List<Facility> facilityList = new ArrayList<>();
        for (Long fid : facilityIds) {
            com.naijatravelshop.persistence.model.hotel.Facility facility = facilityRepository.findFirstByFacilityId(fid);
            Facility f = new Facility();
            f.setFacility(facility.getName());
            f.setFacilityGroup(facility.getFacilityGroup());
            f.setFacilityID(facility.getFacilityId().intValue());
            facilityList.add(f);
        }
        return facilityList;

    }

//    private PropertyDetailsResponse getPropertyDetailFromJacTravel(String propertyId){
//        if (StringUtils.isEmpty(propertyId)) {
//            throw new BadRequestException("Property ID is null");
//        }
//        PropertyDetailsRequest propertyDetail = new PropertyDetailsRequest();
//        propertyDetail.setPropertyReferenceID(Integer.valueOf(propertyId));
//        propertyDetail.setLoginDetails(getLoginDetails());
//
//        PropertyDetailsResponse propertyDetailsResponse = new PropertyDetailsResponse();
//        String requestBody = util.jaxbObjectToXML(propertyDetail);
//        String responseBody = util.makeApiCall(requestBody);
//
//        try {
//            JAXBContext jaxbContext = newInstance(PropertyDetailsResponse.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            StringReader reader = new StringReader(responseBody);
//            propertyDetailsResponse = (PropertyDetailsResponse) jaxbUnmarshaller.unmarshal(reader);
//        } catch (JAXBException ex) {
//            Logger.getLogger(HotelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return propertyDetailsResponse;
//    }


//    public PropertyDetailsResponse handleGetPropertyDetail(PropertyDetailsRequest propertyDetail) {
//        Optional<PropertyDetailsRequest> propertyDetailOpt = Optional.ofNullable(propertyDetail);
//        if (!propertyDetailOpt.isPresent()) {
//            throw new BadRequestException("Property Detail is null");
//        }
//
//        if (StringUtils.isEmpty(propertyDetail.getPropertyID()) && StringUtils.isEmpty(propertyDetail.getPropertyReferenceID())) {
//            throw new BadRequestException("Missing required details");
//        }
//
//        propertyDetail.setLoginDetails(getLoginDetails());
//
//        PropertyDetailsResponse propertyDetailsResponse = new PropertyDetailsResponse();
//        String requestBody = util.jaxbObjectToXML(propertyDetail);
//        String responseBody = util.makeApiCall(requestBody);
//
//        try {
//            JAXBContext jaxbContext = newInstance(PropertyDetailsResponse.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            StringReader reader = new StringReader(responseBody);
//            propertyDetailsResponse = (PropertyDetailsResponse) jaxbUnmarshaller.unmarshal(reader);
//        } catch (JAXBException ex) {
//            Logger.getLogger(HotelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return propertyDetailsResponse;
//    }

    @Override
    public List<PropertyResponse> getPropertiesDetail(List<Long> propertyIds) {
        List<PropertyResponse> properties = new ArrayList<>();

        propertyIds.stream().map(propertyId -> propertyRepository.findFirstByReferenceIdEquals(propertyId)).filter(Optional::isPresent).map(Optional::get).forEachOrdered(p -> {
            List<Long> facilityIds = Arrays.stream(p.getFacilities().split("\\s*,\\s*")).map(Long::valueOf).collect(Collectors.toList());
            List<Facility> facilities = getHotelFacility(facilityIds);
//            PropertyResponse propertyResponse = PropertyResponse.builder()
//                    .propertyGroup(p.getPropertyGroup())
//                    .name(p.getName())
//                    .airport(p.getAirport())
//                    .attribute(p.getAttribute())
//                    .country(p.getCountry())
//                    .country1(p.getCountry1())
//                    .county(p.getCounty())
//                    .description(p.getDescription())
//                    .fax(p.getFax())
//                    .firstAddress(p.getFirstAddress())
//                    .geographyLevel2Id(p.getGeographyLevel2Id())
//                    .geographyLevel3Id(p.getGeographyLevel3Id())
//                    .image1url(p.getImage1url())
//                    .image2url(p.getImage2url())
//                    .image3url(p.getImage3url())
//                    .image4url(p.getImage4url())
//                    .image5url(p.getImage5url())
//                    .image6url(p.getImage6url())
//                    .image7url(p.getImage7url())
//                    .image8url(p.getImage8url())
//                    .image9url(p.getImage9url())
//                    .image10url(p.getImage10url())
//                    .latitude(p.getLatitude())
//                    .longitude(p.getLongitude())
//                    .type(p.getType())
//                    .townCity(p.getTownCity())
//                    .thumbnailURL(p.getThumbnailURL())
//                    .telephone(p.getTelephone())
//                    .secondAddress(p.getSecondAddress())
//                    .resort(p.getResort())
//                    .region(p.getRegion())
//                    .referenceId(p.getReferenceId())
//                    .rating(p.getRating())
//                    .propertyGroup(p.getPropertyGroup())
//                    .facilityList(facilities)
//                    .build();
           // properties.add(propertyResponse);
        });
        return properties;
    }

    private JacTravelApiCredential getLoginDetails() {
        if (StringUtils.isEmpty(apiUsername) || StringUtils.isEmpty(apiPassword)) {
            throw new BadRequestException("Missing required api credentials");
        }
        JacTravelApiCredential loginDetails = new JacTravelApiCredential();
        loginDetails.setLogin(apiUsername);
        loginDetails.setPassword(apiPassword);
        loginDetails.setCurrencyID(2);
        return loginDetails;
    }

    private void bookingDetailsValidation(BookingDetail bookingDetails) {
        if (bookingDetails.getPropertyID() != null ||
                StringUtils.isEmpty(bookingDetails.getArrivalDate()) ||
                bookingDetails.getDuration() < 1 ||
                bookingDetails.getRoomBookings().isEmpty()) {
            throw new BadRequestException("Missing required details");
        }
    }

    private void guestValidation(Integer adults, Integer infants, Integer children) {
        if (adults < 1) {
            throw new BadRequestException("Number of adults must be at least 1");
        }
        if (infants < 0 || children < 0) {
            throw new BadRequestException("Invalid number of guest provided");
        }
    }

    @Transactional
    public Reservation createReservation(BookRequest bookRequest) {
        int adults = 0;
        int children = 0;
        int infants = 0;
        for (RoomBooking roomBooking : bookRequest.getBookingDetails().getRoomBookings()) {
            adults += roomBooking.getAdults();
            children += roomBooking.getChildren();
            infants += roomBooking.getInfants();
        }
        Timestamp currentTime = new Timestamp(new Date().getTime());
        LocalDate arrivalDate = LocalDate.parse(bookRequest.getBookingDetails().getArrivalDate());
        HotelBookingDetail hotelBookingDetail = new HotelBookingDetail();
        hotelBookingDetail.setCheckinDate(Timestamp.valueOf(arrivalDate.atStartOfDay()));
        hotelBookingDetail.setCheckoutDate(Timestamp.valueOf(arrivalDate.plusDays(bookRequest.getBookingDetails().getDuration()).atStartOfDay()));
        hotelBookingDetail.setCommissionableTotalInKobo(0L);
        hotelBookingDetail.setMarkupInKobo(0L);
        hotelBookingDetail.setNightlyRateTotalInKobo(bookRequest.getPreBookResponse().getTotalPrice().longValue() / bookRequest.getBookingDetails().getDuration());
        hotelBookingDetail.setNumberOfAdult(adults);
        hotelBookingDetail.setNumberOfChildren(children);
        hotelBookingDetail.setNumberOfInfant(infants);
        hotelBookingDetail.setNumberOfNightsStay(bookRequest.getBookingDetails().getDuration());
        hotelBookingDetail.setNumberOfRoom(bookRequest.getBookingDetails().getRoomBookings().size());
        hotelBookingDetail.setTotalAmountPayableInKobo(bookRequest.getPreBookResponse().getTotalPrice().longValue());
        hotelBookingDetail.setSupplierReference("");
        hotelBookingDetail.setDateCreated(currentTime);
        hotelBookingDetail.setLastUpdated(currentTime);
        hotelBookingDetail.setStatus(EntityStatus.ACTIVE);
        hotelBookingDetailRepository.save(hotelBookingDetail);


        Address address = new Address();
        address.setCity(bookRequest.getBookingDetails().getLeadGuestTownCity());
        Optional<Country> country = countryRepository.findById(bookRequest.getBookingDetails().getLeadGuestBookingCountryID().longValue());
        address.setCountry(country.get());
        address.setName(bookRequest.getBookingDetails().getLeadGuestAddress1());
        address.setPostalCode(bookRequest.getBookingDetails().getLeadGuestPostCode());
        addressRepository.save(address);

        Optional<ReservationOwner> ownerOpt = reservationOwnerRepository
                .findFirstByEmailEquals(bookRequest.getBookingDetails().getLeadGuestFirstName());
        ReservationOwner owner = null;
        if (ownerOpt.isPresent()) {
            owner = ownerOpt.get();
        } else {
            owner.setFirstName(bookRequest.getBookingDetails().getLeadGuestFirstName());
            owner.setAddress(address);
            owner.setEmail(bookRequest.getBookingDetails().getLeadGuestEmail());
            owner.setLastName(bookRequest.getBookingDetails().getLeadGuestLastName());
            owner.setTitle(bookRequest.getBookingDetails().getLeadGuestTitle());
            owner.setPhoneNumber(bookRequest.getBookingDetails().getLeadGuestPhone());
            owner.setNationality(country.get());
            owner.setDateOfBirth(new Timestamp(bookRequest.getBookingDetails().getLeadGuestDateOfBirth().getTime()));
            reservationOwnerRepository.save(owner);
        }


        Reservation reservation = new Reservation();
        reservation.setLastUpdated(currentTime);
        reservation.setReservationStatus(ProcessStatus.PENDING);
        reservation.setBookingNumber(generateBookingNumber());
        reservation.setActualAmountInKobo(bookRequest.getPreBookResponse().getTotalPrice().longValue());
        reservation.setMargin(0L);
        reservation.setProcessing(false);
        reservation.setReservationOwner(owner);
        reservation.setReservationType(ReservationType.HOTEL);
        reservation.setSellingPrice(bookRequest.getPreBookResponse().getTotalPrice().longValue());
        reservation.setSupplierGroupType(SupplierGroupType.JACTRAVEL);
        reservation.setSupplierPrice(bookRequest.getPreBookResponse().getTotalPrice().longValue());
        reservation.setDateCreated(currentTime);
        reservation.setStatus(EntityStatus.ACTIVE);
        reservation.setHotelBookingDetail(hotelBookingDetail);
        reservationRepository.save(reservation);

        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setPaymentStatus(ProcessStatus.PENDING);
        paymentHistory.setStatus(EntityStatus.ACTIVE);
        paymentHistory.setLastUpdated(currentTime);
        paymentHistory.setDateCreated(currentTime);
        paymentHistory.setReservation(reservation);
        paymentHistoryRepository.save(paymentHistory);


        for (RoomBooking roomBooking : bookRequest.getBookingDetails().getRoomBookings()) {
            RoomOffer roomOffer = new RoomOffer();
            roomOffer.setHotelBookingDetail(hotelBookingDetail);
            roomOffer.setOfferId(roomBooking.getPropertyRoomTypeID().toString());
            roomOffer.setPriceInKobo(bookRequest.getRoomType().getSubTotal().longValue());
            roomOffer.setRoomDescription(bookRequest.getRoomType().getRoomView());
            roomOffer.setRoomType(bookRequest.getRoomType().getRoomType());
            roomOfferRepository.save(roomOffer);

            for (Guest guest : roomBooking.getGuests()) {
                Traveller traveller = new Traveller();
                if (guest.getType().equalsIgnoreCase("Adult")) traveller.setAgeGroup(AgeGroupType.ADULT);
                if (guest.getType().equalsIgnoreCase("Child")) traveller.setAgeGroup(AgeGroupType.CHILD);
                if (guest.getType().equalsIgnoreCase("Infant")) traveller.setAgeGroup(AgeGroupType.INFANT);
                traveller.setAge(guest.getAge());
              //  traveller.setDateOfBirth(guest.getDateOfBirth());
                traveller.setFirstName(guest.getFirstName());
                traveller.setLastName(guest.getLastName());
                traveller.setReservation(reservation);
                traveller.setTitle(guest.getTitle());
                travellerRepository.save(traveller);
            }
        }


        for (Cancellation c : bookRequest.getPreBookResponse().getCancellations()) {
            CancellationPolicy cancellationPolicy = null;
            cancellationPolicy.setEndDate(c.getEndDate());
            cancellationPolicy.setStartDate(c.getStartDate());
            cancellationPolicy.setPenalty(c.getPenalty().longValue());
            cancellationPolicy.setReservation(reservation);
            cancellationPolicyRepository.save(cancellationPolicy);
        }

        return reservation;
    }

    private static String generateBookingNumber() {
        Random r = new Random();
        return String.valueOf(r.ints(10000000, (99999999 + 1)).findFirst().getAsInt());

    }
}
