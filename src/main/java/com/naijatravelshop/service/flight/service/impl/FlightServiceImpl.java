package com.naijatravelshop.service.flight.service.impl;

import com.naijatravelshop.persistence.model.enums.*;
import com.naijatravelshop.persistence.model.flight.FlightBookingDetail;
import com.naijatravelshop.persistence.model.flight.FlightRoute;
import com.naijatravelshop.persistence.model.flight.VisaRequest;
import com.naijatravelshop.persistence.model.portal.*;
import com.naijatravelshop.persistence.repository.flight.FlightBookingDetailRepository;
import com.naijatravelshop.persistence.repository.flight.FlightRouteRepository;
import com.naijatravelshop.persistence.repository.flight.VisaRequestRepository;
import com.naijatravelshop.persistence.repository.payment.PaymentHistoryRepository;
import com.naijatravelshop.persistence.repository.portal.*;
import com.naijatravelshop.service.email.EmailService;
import com.naijatravelshop.service.flight.pojo.request.*;
import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;
import com.naijatravelshop.service.flight.service.FlightService;
import com.naijatravelshop.web.exceptions.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Bruno on
 * 21/05/2019
 */
@Service
public class FlightServiceImpl implements FlightService {
    private AddressRepository addressRepository;
    private PaymentHistoryRepository paymentHistoryRepository;
    private ReservationOwnerRepository reservationOwnerRepository;
    private ReservationRepository reservationRepository;
    private TravellerRepository travellerRepository;
    private CountryRepository countryRepository;
    private PortalUserRepository portalUserRepository;
    private FlightBookingDetailRepository flightBookingDetailRepository;
    private FlightRouteRepository flightRouteRepository;
    private VisaRequestRepository visaRequestRepository;

    private EmailService emailService;

    private static final Logger log = LoggerFactory.getLogger(FlightServiceImpl.class);

    public FlightServiceImpl(AddressRepository addressRepository,
                             PaymentHistoryRepository paymentHistoryRepository,
                             ReservationOwnerRepository reservationOwnerRepository,
                             ReservationRepository reservationRepository,
                             TravellerRepository travellerRepository,
                             CountryRepository countryRepository,
                             PortalUserRepository portalUserRepository,
                             FlightBookingDetailRepository flightBookingDetailRepository,
                             FlightRouteRepository flightRouteRepository,
                             VisaRequestRepository visaRequestRepository,
                             EmailService emailService) {
        this.addressRepository = addressRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.reservationOwnerRepository = reservationOwnerRepository;
        this.reservationRepository = reservationRepository;
        this.travellerRepository = travellerRepository;
        this.countryRepository = countryRepository;
        this.portalUserRepository = portalUserRepository;
        this.flightBookingDetailRepository = flightBookingDetailRepository;
        this.flightRouteRepository = flightRouteRepository;
        this.visaRequestRepository = visaRequestRepository;
        this.emailService = emailService;
    }

    @Override
    @Transactional
    public ReservationResponseDTO createReservation(ReservationRequestDTO requestDTO) {
        try {
            Optional<Country> optionalCountry = countryRepository.findFirstByCode(requestDTO.getReservationOwner().getCountryCode());

            log.info("createReservation: {}", requestDTO.toString());
            Address address = new Address();
            address.setName(requestDTO.getReservationOwner().getAddress());
            address.setCity(requestDTO.getReservationOwner().getCity());
            if (optionalCountry.isPresent()) {
                address.setCountry(optionalCountry.get());
            }
            addressRepository.save(address);

            ReservationOwner owner = new ReservationOwner();
            Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(requestDTO.getReservationOwner().getDateOfBirth());
            owner.setFirstName(requestDTO.getReservationOwner().getFirstName());
            owner.setLastName(requestDTO.getReservationOwner().getLastName());
            owner.setAddress(address);
            owner.setDateOfBirth(new Timestamp(dob.getTime()));
            owner.setEmail(requestDTO.getReservationOwner().getEmail());
            owner.setPhoneNumber(requestDTO.getReservationOwner().getPhoneNumber());
            if (optionalCountry.isPresent()) {
                owner.setNationality(optionalCountry.get());
            }

            if (requestDTO.getReservationOwner().getTitleCode() == 1) {
                owner.setTitle("MISS");
            }
            if (requestDTO.getReservationOwner().getTitleCode() == 3) {
                owner.setTitle("MRS");
            }

            if (requestDTO.getReservationOwner().getTitleCode() == 0) {
                owner.setTitle("MR");
            }
            reservationOwnerRepository.save(owner);

            FlightBookingDetail flightBookingDetail = new FlightBookingDetail();
            flightBookingDetail.setBookingDate(new Timestamp(new Date().getTime()));
            flightBookingDetail.setNumberOfAdult(requestDTO.getFlightSearch().getTravellerDetail().getAdults());
            flightBookingDetail.setNumberOfChildren(requestDTO.getFlightSearch().getTravellerDetail().getChildren());
            flightBookingDetail.setNumberOfInfant(requestDTO.getFlightSearch().getTravellerDetail().getInfants());
            flightBookingDetail.setFlightSummary(requestDTO.getFlightSummary());
            flightBookingDetail.setPnr(requestDTO.getBookingNumber());
            flightBookingDetailRepository.save(flightBookingDetail);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            List<FlightRoute> flightRouteList = new ArrayList<>();
            for (OriginDestinationOptionsDTO originDestinationOptionsDTO : requestDTO.getFlightDetails().getOriginDestinationOptions()) {
                for (FlightSegmentsDTO flightSegmentsDTO : originDestinationOptionsDTO.getFlightSegments()) {
                    FlightRoute flightRoute = new FlightRoute();
                    flightRoute.setArrivalTime(new Timestamp(simpleDateFormat.parse(flightSegmentsDTO.getArrivalTime()).getTime()));
                    flightRoute.setDepartureAirport(flightSegmentsDTO.getDepartureAirportName());
                    flightRoute.setDepartureCityName(flightSegmentsDTO.getDepartureAirportName().substring(0, indexOfAny(flightSegmentsDTO.getArrivalAirportName(), "-")));
                    flightRoute.setDepartureTime(new Timestamp(simpleDateFormat.parse(flightSegmentsDTO.getDepartureTime()).getTime()));
                    flightRoute.setDestinationAirport(flightSegmentsDTO.getArrivalAirportName());
                    flightRoute.setDestinationCityName(flightSegmentsDTO.getArrivalAirportName().substring(0, indexOfAny(flightSegmentsDTO.getDepartureAirportName(), "-")));
                    flightRoute.setFlightDuration(flightSegmentsDTO.getJourneyDuration());
                    flightRoute.setFlightBookingDetail(flightBookingDetail);
                    flightRoute.setFlightNumber(flightSegmentsDTO.getFlightNumber());
                    flightRoute.setMarketingAirlineCode(flightSegmentsDTO.getAirlineCode());
                    flightRoute.setMarketingAirlineName(flightSegmentsDTO.getAirlineName());
                    flightRoute.setOperatingAirlineCode(flightSegmentsDTO.getAirlineCode());
                    flightRoute.setAirlineName(flightSegmentsDTO.getAirlineName());
                    flightRouteList.add(flightRoute);
                    flightRouteRepository.save(flightRoute);
                }
            }


            Reservation reservation = new Reservation();
            reservation.setSellingPrice(requestDTO.getAmount().longValue());
            reservation.setBookingNumber(requestDTO.getBookingNumber());
            reservation.setReservationOwner(owner);
            reservation.setStatus(EntityStatus.ACTIVE);
            reservation.setTransactionFeeInKobo(0L);
            reservation.setSupplierGroupType(SupplierGroupType.AMADEUS);
            reservation.setMargin(0L);
            reservation.setReservationStatus(ProcessStatus.PENDING);
            reservation.setReservationType(ReservationType.FLIGHT);
            reservation.setFlightBookingDetail(flightBookingDetail);
            if (requestDTO.getPortalUsername() != null) {
                Optional<PortalUser> optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(requestDTO.getPortalUsername(), EntityStatus.ACTIVE);
                reservation.setProcessedBy(optionalPortalUser.get());
            }
            reservationRepository.save(reservation);

            List<Traveller> travellerList = new ArrayList<>();
            for (TravellerDTO traveller : requestDTO.getTravellers()) {
                Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(traveller.getDateOfBirth());

                Traveller t = new Traveller();
                t.setDateOfBirth(new Timestamp(dateOfBirth.getTime()));
                t.setFirstName(traveller.getFirstName());
                t.setLastName(traveller.getLastName());

                if (traveller.getTitleCode() == 1) {
                    t.setTitle("MISS");
                    t.setGender(Gender.FEMALE);
                }
                if (traveller.getTitleCode() == 3) {
                    t.setTitle("MRS");
                    t.setGender(Gender.FEMALE);
                }

                if (traveller.getTitleCode() == 0) {
                    t.setTitle("MR");
                    t.setGender(Gender.MALE);
                }

                if (traveller.getTitleCode() == 2) {
                    t.setTitle("MASTER");
                    t.setGender(Gender.MALE);
                }
                travellerList.add(t);
                t.setReservation(reservation);
                travellerRepository.save(t);
            }

            try {
                sendFlightBookingEmail(owner, reservation, travellerList, flightRouteList);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }

            ReservationResponseDTO responseDTO = new ReservationResponseDTO();
            responseDTO.setBookingNumber(reservation.getBookingNumber());
            responseDTO.setReservationId(reservation.getId());

            return responseDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }

    }

    @Override
    public ReservationResponseDTO createVisaRequest(VisaRequestDTO visaRequestDTO) {
        ReservationResponseDTO responseDTO = new ReservationResponseDTO();
        Optional<Country> optionalCountry;
        VisaRequest visaRequest = new VisaRequest();
        optionalCountry = countryRepository.findFirstByCode(visaRequestDTO.getCountryOfResidence());
        if (optionalCountry.isPresent()) {
            visaRequest.setCountryOfResidence(optionalCountry.get());
        }
        visaRequest.setDepartureDate(new Timestamp(visaRequestDTO.getDepartureDate().getTime()));
        optionalCountry = countryRepository.findFirstByCode(visaRequestDTO.getDestinationCountry());
        if (optionalCountry.isPresent()) {
            visaRequest.setDestinationCountry(optionalCountry.get());
        }
        visaRequest.setEmail(visaRequestDTO.getEmail());
        visaRequest.setFirstName(visaRequestDTO.getFirstName());
        visaRequest.setLastName(visaRequestDTO.getLastName());
        visaRequest.setMessage(visaRequestDTO.getMessage());
        visaRequest.setPhoneNumber(visaRequestDTO.getPhoneNumber());
        visaRequest.setProcessed(false);
        visaRequest.setReturnDate(new Timestamp(visaRequestDTO.getReturnDate().getTime()));
        visaRequest.setStatus(EntityStatus.ACTIVE);
        visaRequestRepository.save(visaRequest);

        responseDTO.setReservationId(visaRequest.getId());

        return responseDTO;
    }

    private void sendFlightBookingEmail(ReservationOwner owner, Reservation reservation, List<Traveller> travellers,
                        List<FlightRoute> itinerary) {
        log.info("Sending mail.....");
        Map<String, Object> flightBookingEmail = new HashMap<>();
        flightBookingEmail.put("recieverName", owner.getTitle() + " " + owner.getLastName());
        flightBookingEmail.put("reservationDate", reservation.getDateCreated());
        flightBookingEmail.put("bookingNumber", reservation.getBookingNumber());
        flightBookingEmail.put("amount", reservation.getSellingPrice().toString().substring(0, reservation.getSellingPrice().toString().length() - 2) + "." + reservation.getSellingPrice().toString().substring(reservation.getSellingPrice().toString().length() - 2));
        flightBookingEmail.put("supplierReference", " BOOKING NOT YET CREATED");
        flightBookingEmail.put("contactName", owner.getTitle() + " " + owner.getFirstName() + " " + owner.getLastName());
        flightBookingEmail.put("contactEmail", owner.getEmail());
        flightBookingEmail.put("contactPhone", owner.getPhoneNumber());
        flightBookingEmail.put("itinerary", itinerary);
        flightBookingEmail.put("travellers", travellers);

        emailService.sendHtmlEmail(owner.getEmail(), "Flight Booking Notification", "flight-booking-confirmation-template", flightBookingEmail, "travel@naijatravelshop.com");
    }

    private static int indexOfAny(String s, String chars) {
        int i = -1;
        for (char c : chars.toCharArray()) {
            int pos = s.indexOf(c);
            if (pos >= 0 && (pos < i || i < 0)) {
                i = pos;
            }
        }
        return i;
    }
}

