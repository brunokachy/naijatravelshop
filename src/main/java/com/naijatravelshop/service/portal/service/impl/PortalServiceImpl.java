package com.naijatravelshop.service.portal.service.impl;

import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.enums.ProcessStatus;
import com.naijatravelshop.persistence.model.enums.ReservationType;
import com.naijatravelshop.persistence.model.enums.RoleType;
import com.naijatravelshop.persistence.model.flight.FlightBookingDetail;
import com.naijatravelshop.persistence.model.flight.FlightRoute;
import com.naijatravelshop.persistence.model.flight.VisaRequest;
import com.naijatravelshop.persistence.model.payment.PaymentHistory;
import com.naijatravelshop.persistence.model.portal.*;
import com.naijatravelshop.persistence.repository.flight.FlightBookingDetailRepository;
import com.naijatravelshop.persistence.repository.flight.FlightRouteRepository;
import com.naijatravelshop.persistence.repository.flight.VisaRequestRepository;
import com.naijatravelshop.persistence.repository.payment.PaymentHistoryRepository;
import com.naijatravelshop.persistence.repository.portal.*;
import com.naijatravelshop.service.flight.pojo.request.FlightSegmentsDTO;
import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;
import com.naijatravelshop.service.portal.pojo.request.BookingSearchDTO;
import com.naijatravelshop.service.portal.pojo.request.PasswordDTO;
import com.naijatravelshop.service.portal.pojo.request.UserDTO;
import com.naijatravelshop.service.portal.pojo.response.*;
import com.naijatravelshop.service.portal.service.PortalService;
import com.naijatravelshop.service.email.EmailService;
import com.naijatravelshop.web.constants.ProjectConstant;
import com.naijatravelshop.web.exceptions.BadRequestException;
import com.naijatravelshop.web.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Bruno on
 * 17/05/2019
 */
@Service
public class PortalServiceImpl implements PortalService {

    private PortalUserRepository portalUserRepository;
    private PortalUserRoleMapRepository portalUserRoleMapRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private EmailService emailService;
    private SettingRepository settingRepository;
    private ReservationRepository reservationRepository;
    private FlightBookingDetailRepository flightBookingDetailRepository;
    private PaymentHistoryRepository paymentHistoryRepository;
    private ReservationOwnerRepository reservationOwnerRepository;
    private FlightRouteRepository flightRouteRepository;
    private TravellerRepository travellerRepository;
    private VisaRequestRepository visaRequestRepository;

    private static final Logger log = LoggerFactory.getLogger(PortalServiceImpl.class);


    public PortalServiceImpl(PortalUserRepository portalUserRepository,
                             PasswordEncoder passwordEncoder,
                             PortalUserRoleMapRepository portalUserRoleMapRepository,
                             RoleRepository roleRepository,
                             EmailService emailService,
                             SettingRepository settingRepository,
                             ReservationRepository reservationRepository,
                             FlightBookingDetailRepository flightBookingDetailRepository,
                             PaymentHistoryRepository paymentHistoryRepository,
                             ReservationOwnerRepository reservationOwnerRepository,
                             FlightRouteRepository flightRouteRepository,
                             TravellerRepository travellerRepository,
                             VisaRequestRepository visaRequestRepository) {
        this.portalUserRepository = portalUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.portalUserRoleMapRepository = portalUserRoleMapRepository;
        this.roleRepository = roleRepository;
        this.emailService = emailService;
        this.settingRepository = settingRepository;
        this.reservationRepository = reservationRepository;
        this.flightBookingDetailRepository = flightBookingDetailRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.reservationOwnerRepository = reservationOwnerRepository;
        this.flightRouteRepository = flightRouteRepository;
        this.travellerRepository = travellerRepository;
        this.visaRequestRepository = visaRequestRepository;
    }


    @Override
    @Transactional
    public UserResponse createUserAccount(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser;

        optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
        if (optionalPortalUser.isPresent()) {
            throw new BadRequestException("User account already exists");
        }
        Timestamp currentTime = new Timestamp(new Date().getTime());
        PortalUser user = new PortalUser();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        if (!StringUtils.isEmpty(userDTO.getPassword())) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        user.setPasswordReset(false);
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setDateCreated(currentTime);
        user.setStatus(EntityStatus.ACTIVE);
        user.setLastUpdated(currentTime);
        user.setLastPasswordUpdate(currentTime);
        portalUserRepository.save(user);
        Optional<Role> optionalRole = roleRepository.findFirstByNameEquals(RoleType.PORTAL_USER);
        PortalUserRoleMap portalUserRoleMap = new PortalUserRoleMap();
        portalUserRoleMap.setPortalUser(user);
        portalUserRoleMap.setRole(optionalRole.get());
        portalUserRoleMap.setStatus(EntityStatus.ACTIVE);
        portalUserRoleMapRepository.save(portalUserRoleMap);

        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setId(user.getId());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setRoles(Collections.singletonList(optionalRole.get().getDisplayName()));

        Map<String, Object> newAccount = new HashMap<>();
        newAccount.put("recieverName", user.getFirstName());
        emailService.sendHtmlEmail(user.getEmail(), "Naija Travel Shop: New User Account!", "account-creation-template", newAccount, "travel@naijatravelshop.com");

        return userResponse;
    }

    @Override
    @Transactional
    public UserResponse updateUserAccount(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(userDTO.getId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }

        Timestamp currentTime = new Timestamp(new Date().getTime());
        PortalUser user = optionalPortalUser.get();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setLastUpdated(currentTime);
        portalUserRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setEmail(user.getEmail());
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());

        return userResponse;
    }

    @Override
    public UserResponse deactivateUserAccount(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(userDTO.getId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }

        PortalUser user = optionalPortalUser.get();
        user.setStatus(EntityStatus.DEACTIVATED);
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setActive(false);

        return userResponse;
    }

    @Override
    public UserResponse reactivateUserAccount(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(userDTO.getId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }

        PortalUser user = optionalPortalUser.get();
        user.setStatus(EntityStatus.ACTIVE);
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setLastName(user.getLastName());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setId(user.getId());
        userResponse.setActive(true);

        return userResponse;
    }

    @Override
    public UserResponse resetPassword(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser = Optional.empty();

        if (userDTO.getId() != null) {
            optionalPortalUser = portalUserRepository.findById(userDTO.getId());
        }

        if (!optionalPortalUser.isPresent()) {
            optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
            if (!optionalPortalUser.isPresent()) {
                throw new NotFoundException("User does not exist");
            }
        }
        String newPassword = randomAlphaNumeric(8);
        PortalUser user = optionalPortalUser.get();
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setLastUpdated(new Timestamp(new Date().getTime()));
        user.setLastPasswordUpdate(new Timestamp(new Date().getTime()));
        portalUserRepository.save(user);
        log.info(newPassword);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());

        Map<String, Object> newAccount = new HashMap<>();
        newAccount.put("recieverName", user.getFirstName());
        newAccount.put("password", newPassword);
        emailService.sendHtmlEmail(user.getEmail(), "Naija Travel Shop: Password Reset!", "password-reset-template", newAccount, "travel@naijatravelshop.com");

        return userResponse;
    }

    @Override
    public UserResponse changePassword(PasswordDTO passwordDTO) {
        Optional<PortalUser> optionalPortalUser = portalUserRepository.findById(passwordDTO.getUserId());

        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User does not exist");
        }
        Timestamp currentTime = new Timestamp(new Date().getTime());
        PortalUser user = optionalPortalUser.get();
        CharSequence passwordCharSequence = new StringBuffer(passwordDTO.getOldPassword());
        if (passwordEncoder.matches(passwordCharSequence, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            user.setLastUpdated(currentTime);
            user.setLastPasswordUpdate(currentTime);
            portalUserRepository.save(user);
            UserResponse userResponse = new UserResponse();
            userResponse.setEmail(user.getEmail());
            userResponse.setPhoneNumber(user.getPhoneNumber());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setId(user.getId());

            return userResponse;
        } else {
            throw new BadRequestException("Password is incorrect");
        }
    }

    @Override
    public UserResponse login(UserDTO userDTO) {
        Optional<PortalUser> optionalPortalUser;

        optionalPortalUser = portalUserRepository.findFirstByEmailAndStatus(userDTO.getEmail(), EntityStatus.ACTIVE);
        if (!optionalPortalUser.isPresent()) {
            throw new NotFoundException("User with this email does not exist");
        }
        List<PortalUserRoleMap> roleMaps = portalUserRoleMapRepository.getAllByStatusAndPortalUserEquals(EntityStatus.ACTIVE, optionalPortalUser.get());
        List<String> roles = new ArrayList<>();
        for (PortalUserRoleMap portalUserRoleMap : roleMaps) {
            Optional<Role> role = roleRepository.findById(portalUserRoleMap.getRole().getId());
            if (role.isPresent()) {
                roles.add(role.get().getDisplayName());
            }

        }
        PortalUser user = optionalPortalUser.get();
        CharSequence passwordCharSequence = new StringBuffer(userDTO.getPassword());

        if (passwordEncoder.matches(passwordCharSequence, user.getPassword())) {
            UserResponse userResponse = new UserResponse();
            userResponse.setEmail(user.getEmail());
            userResponse.setId(user.getId());
            userResponse.setLastName(user.getLastName());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setPhoneNumber(user.getPhoneNumber());
            userResponse.setRoles(roles);
            userResponse.setPasswordReset(user.isPasswordReset());

            return userResponse;
        } else {
            throw new NotFoundException("User with this password does not exist");
        }
    }

    @Override
    public AffiliateAccountDetail getAffiliateAccountDetail() {
        Optional<Setting> secretKey = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_SECRET_KEY);
        Optional<Setting> publicKey = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_PUBLIC_KEY);
        Optional<Setting> affiliateCode = settingRepository.findFirstByNameEquals(ProjectConstant.AFFILIATE_CODE);

        AffiliateAccountDetail affiliateAccountDetail = new AffiliateAccountDetail();
        affiliateAccountDetail.setAffiliateCode(affiliateCode.get().getValue());
        affiliateAccountDetail.setPublicKey(publicKey.get().getValue());
        affiliateAccountDetail.setSecretKey(secretKey.get().getValue());

        return affiliateAccountDetail;
    }

    @Override
    public String getApiBaseUrl() {
        Optional<Setting> baseUrl = settingRepository.findFirstByNameEquals(ProjectConstant.API_BASE_URL);
        return baseUrl.get().getValue();
    }

    @Override
    public List<RecentBookingResponse> getRecentBooking() {
        List<RecentBookingResponse> recentBookingResponseList = new ArrayList<>();

        Page<Reservation> page = reservationRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "dateCreated")));
        page.get().forEach(reservation -> {
            RecentBookingResponse recentBookingResponse = new RecentBookingResponse();
            recentBookingResponse.setAmount(reservation.getSellingPrice().doubleValue());
            recentBookingResponse.setBookingDate(reservation.getDateCreated());
            recentBookingResponse.setBookingType(reservation.getReservationType().getValue());
            if (reservation.getReservationType().equals(ReservationType.FLIGHT)) {
                if (reservation.getFlightBookingDetail() != null) {
                    Optional<FlightBookingDetail> optFlightBookingDetail = flightBookingDetailRepository.findById(reservation.getFlightBookingDetail().getId());
                    if (optFlightBookingDetail.isPresent()) {
                        recentBookingResponse.setDescription(reservation.getFlightBookingDetail().getFlightSummary());
                    }
                }
            }
            recentBookingResponse.setBookingNumber(reservation.getBookingNumber());
            recentBookingResponseList.add(recentBookingResponse);
        });

        return recentBookingResponseList;
    }

    @Override
    public List<RecentBookingResponse> getFlightBookingBySearchTerm(BookingSearchDTO bookingSearchDTO) {
        List<RecentBookingResponse> bookingList = new ArrayList<>();

        if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
            Page<Reservation> page = reservationRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "dateCreated")));
            bookingList = reservationToRecentBookingResponse(page.getContent());
        } else {
            Timestamp startDateTimeStamp = null;
            Timestamp endDateTimeStamp = null;
            try {
                startDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getStartDate()).getTime());
                endDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getEndDate()).getTime());
            } catch (ParseException e) {

            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate())
                    && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<Reservation> reservations =
                        reservationRepository.getAllByReservationStatusEqualsAndDateCreatedBetween(ProcessStatus.valueOf(bookingSearchDTO.getBookingStatus()),
                                startDateTimeStamp, endDateTimeStamp);
                bookingList = reservationToRecentBookingResponse(reservations);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<Reservation> reservations =
                        reservationRepository.getAllByReservationStatusEquals(ProcessStatus.valueOf(bookingSearchDTO.getBookingStatus()));
                bookingList = reservationToRecentBookingResponse(reservations);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                bookingList = getRecentBookingResponses(bookingSearchDTO.getBookingNo(), bookingList);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getBookingNo()) && !StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<Reservation> reservations =
                        reservationRepository.getAllByDateCreatedBetween(startDateTimeStamp,
                                endDateTimeStamp);
                bookingList = reservationToRecentBookingResponse(reservations);
            }
        }
        return bookingList;

    }

    @Override
    public RecentBookingResponse changeBookingStatus(BookingSearchDTO bookingSearchDTO) {
        Optional<Reservation> optionalReservation = reservationRepository.findFirstByBookingNumberEquals(bookingSearchDTO.getBookingNo());
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setReservationStatus(ProcessStatus.valueOf(bookingSearchDTO.getBookingStatus()));
            reservation.setLastUpdated(new Timestamp(new Date().getTime()));
            if (bookingSearchDTO.getBookingStatus().equalsIgnoreCase("PROCESSED")) {
                reservation.setDateProcessed(new Timestamp(new Date().getTime()));
            }
            reservationRepository.save(reservation);
            RecentBookingResponse recentBookingResponse = new RecentBookingResponse();
            recentBookingResponse.setBookingStatus(reservation.getReservationStatus().getValue());
            recentBookingResponse.setBookingNumber(reservation.getBookingNumber());
            return recentBookingResponse;

        } else {
            throw new BadRequestException("Reservation does not exist");
        }
    }

    @Override
    public VisaResponse changeVisaRequestStatus(BookingSearchDTO bookingSearchDTO) {
        Optional<VisaRequest> optionalVisaRequest = visaRequestRepository.findById(Long.valueOf(bookingSearchDTO.getBookingNo()));
        if (optionalVisaRequest.isPresent()) {
            VisaRequest visaRequest = optionalVisaRequest.get();
            visaRequest.setLastUpdated(new Timestamp(new Date().getTime()));
            visaRequest.setProcessed(Boolean.valueOf(bookingSearchDTO.getBookingStatus()));
            visaRequestRepository.save(visaRequest);

            VisaResponse visaResponse = new VisaResponse();
            visaResponse.setProcessed(Boolean.valueOf(bookingSearchDTO.getBookingStatus()));
            visaResponse.setId(Long.valueOf(bookingSearchDTO.getBookingNo()));
            return visaResponse;
        } else {
            throw new BadRequestException("Reservation does not exist");
        }
    }

    @Override
    public List<UserResponse> getPortalUsers() {
        Iterable<PortalUser> portalUsers = portalUserRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        portalUsers.forEach(portalUser -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setPhoneNumber(portalUser.getPhoneNumber());
            userResponse.setId(portalUser.getId());
            userResponse.setFirstName(portalUser.getFirstName());
            userResponse.setLastName(portalUser.getLastName());
            userResponse.setEmail(portalUser.getEmail());
            if (portalUser.getStatus() == EntityStatus.ACTIVE) {
                userResponse.setActive(true);
            } else {
                userResponse.setActive(false);
            }
            userResponses.add(userResponse);
        });
        return userResponses;
    }

    @Override
    public FlightReservationResponse getFlightBookingDetails(String bookingNumber) {
        Optional<Reservation> optionalReservation = reservationRepository.findFirstByBookingNumberEquals(bookingNumber);
        FlightReservationResponse response = new FlightReservationResponse();
        if (optionalReservation.isPresent()) {
            try {
                Reservation reservation = optionalReservation.get();
                if (reservation.getFlightBookingDetail() != null) {
                    Optional<FlightBookingDetail> flightBookingDetail = flightBookingDetailRepository.findById(reservation.getFlightBookingDetail().getId());
                    response.setHotelServiceRequested(flightBookingDetail.get().getHotelServiceRequested());
                    response.setNumberOfAdult(flightBookingDetail.get().getNumberOfAdult());
                    response.setNumberOfChildren(flightBookingDetail.get().getNumberOfChildren());
                    response.setNumberOfInfant(flightBookingDetail.get().getNumberOfInfant());
                    response.setVisaServiceRequested(flightBookingDetail.get().getVisaServiceRequested());

                    List<FlightRoute> flightRoutes = flightRouteRepository.findAllByFlightBookingDetail(flightBookingDetail.get());
                    List<FlightSegmentsDTO> flightSegmentsDTOS = new ArrayList<>();
                    for (int i = 0, flightRoutesSize = flightRoutes.size(); i < flightRoutesSize; i++) {
                        FlightRoute flightRoute = flightRoutes.get(i);
                        FlightSegmentsDTO flightSegmentsDTO = new FlightSegmentsDTO();
                        flightSegmentsDTO.setAirlineCode(flightRoute.getMarketingAirlineCode());
                        flightSegmentsDTO.setAirlineName(flightRoute.getAirlineName());
                        flightSegmentsDTO.setArrivalAirportCode(flightRoute.getDestinationAirport());
                        flightSegmentsDTO.setArrivalAirportName(flightRoute.getDestinationCityName());
                        flightSegmentsDTO.setArrivalTime(flightRoute.getArrivalTime().toString());
                        flightSegmentsDTO.setBookingClass(flightRoute.getBookingClass());
                        flightSegmentsDTO.setDepartureAirportCode(flightRoute.getDepartureCityName());
                        flightSegmentsDTO.setDepartureAirportName(flightRoute.getDepartureAirport());
                        flightSegmentsDTO.setDepartureTime(flightRoute.getDepartureTime().toString());
                        flightSegmentsDTO.setFlightNumber(flightRoute.getFlightNumber());
                        flightSegmentsDTO.setJourneyDuration(flightRoute.getFlightDuration());
                        flightSegmentsDTOS.add(flightSegmentsDTO);
                    }
                    response.setFlightRoutes(flightSegmentsDTOS);
                }
                Optional<PaymentHistory> paymentHistory = paymentHistoryRepository.findPaymentHistoryByReservation(reservation);


                response.setBookingDate(reservation.getDateCreated());
                response.setBookingNumber(bookingNumber);
                response.setDateProcessed(reservation.getDateProcessed());
                response.setReservationStatus(reservation.getReservationStatus().getValue());
                response.setSellingPrice(reservation.getSellingPrice());

                if (paymentHistory.isPresent()) {
                    response.setPaymentDate(paymentHistory.get().getPaymentDate());
                    response.setPaymentReference(paymentHistory.get().getPaymentReference());
                    response.setTransactionId(paymentHistory.get().getTransactionId());
                    response.setPaymentStatus(paymentHistory.get().getPaymentStatus().getValue());
                }

                Optional<ReservationOwner> optionalReservationOwner = reservationOwnerRepository.findById(reservation.getReservationOwner().getId());
                TravellerDTO reservationOwner = new TravellerDTO();
                reservationOwner.setEmail(optionalReservationOwner.get().getEmail());
                reservationOwner.setFirstName(optionalReservationOwner.get().getFirstName());
                reservationOwner.setLastName(optionalReservationOwner.get().getLastName());
                reservationOwner.setPhoneNumber(optionalReservationOwner.get().getPhoneNumber());
                reservationOwner.setTitle(optionalReservationOwner.get().getTitle());
                response.setReservationOwner(reservationOwner);


                List<Traveller> travellers = travellerRepository.getAllByReservation(reservation);
                List<TravellerDTO> travellerDTOList = new ArrayList<>();
                for (int i = 0, travellersSize = travellers.size(); i < travellersSize; i++) {
                    Traveller traveller = travellers.get(i);
                    TravellerDTO travellerDTO = new TravellerDTO();
                    travellerDTO.setTitle(traveller.getTitle());
                    travellerDTO.setLastName(traveller.getLastName());
                    travellerDTO.setFirstName(traveller.getFirstName());
                    travellerDTO.setDateOfBirth(traveller.getDateOfBirth().toString());
                    travellerDTOList.add(travellerDTO);
                }
                response.setTravellers(travellerDTOList);


            } catch (Exception e) {
                e.printStackTrace();
            }
            return response;
        } else {
            throw new BadRequestException("Reservation does not exist");
        }
    }

    @Override
    public List<VisaResponse> getRecentVisaRequest(BookingSearchDTO bookingSearchDTO) {
        List<VisaResponse> visaResponseList = new ArrayList<>();

        Page<VisaRequest> page = visaRequestRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "dateCreated")));
        page.get().forEach(visa -> {
            visaResponseObjectBuilder2(visaResponseList, visa);
        });

        return visaResponseList;
    }

    @Override
    public List<VisaResponse> getVisaRequestsBySearchTerm(BookingSearchDTO bookingSearchDTO) {
        List<VisaResponse> visaResponseList = new ArrayList<>();

        if (StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
            Page<VisaRequest> page = visaRequestRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "dateCreated")));
            for (VisaRequest visa : page.getContent()) {
                visaResponseObjectBuilder2(visaResponseList, visa);
            }
        } else {
            Timestamp startDateTimeStamp = null;
            Timestamp endDateTimeStamp = null;
            try {
                startDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getStartDate()).getTime());
                endDateTimeStamp = new Timestamp(new SimpleDateFormat("dd/MM/yyyy").parse(bookingSearchDTO.getEndDate()).getTime());
            } catch (ParseException e) {

            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<VisaRequest> visaRequests =
                        visaRequestRepository.getAllByStatusEqualsAndDateCreatedBetween(Boolean.valueOf(bookingSearchDTO.getBookingStatus()),
                                startDateTimeStamp, endDateTimeStamp);
                visaResponseObjectBuilder(visaResponseList, visaRequests);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && !StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<VisaRequest> visaRequests =
                        visaRequestRepository.getAllByProcessed(Boolean.valueOf(bookingSearchDTO.getBookingStatus()));
                visaResponseObjectBuilder(visaResponseList, visaRequests);
            }

            if (StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                visaResponseList = getRecentVisaRequest(bookingSearchDTO);
            }

            if (!StringUtils.isEmpty(bookingSearchDTO.getStartDate()) && StringUtils.isEmpty(bookingSearchDTO.getBookingStatus())) {
                List<VisaRequest> visaRequests =
                        visaRequestRepository.getAllByDateCreatedBetween(startDateTimeStamp,
                                endDateTimeStamp);
                visaResponseObjectBuilder(visaResponseList, visaRequests);
            }
        }

        return visaResponseList;
    }

    private void visaResponseObjectBuilder2(List<VisaResponse> visaResponseList, VisaRequest visa) {
        VisaResponse visaResponse = new VisaResponse();
        visaResponse.setCountryOfResidence((visa.getCountryOfResidence() != null) ? visa.getCountryOfResidence().getName() : "");
        visaResponse.setDepartureDate(visa.getDepartureDate());
        visaResponse.setDestinationCountry((visa.getDestinationCountry() != null) ? visa.getDestinationCountry().getName() : "");
        visaResponse.setEmail(visa.getEmail());
        visaResponse.setFirstName(visa.getFirstName());
        visaResponse.setId(visa.getId());
        visaResponse.setLastName(visa.getLastName());
        visaResponse.setMessage(visa.getMessage());
        visaResponse.setProcessed(visa.isProcessed());
        visaResponse.setPhoneNumber(visa.getPhoneNumber());
        visaResponse.setReturnDate(visa.getReturnDate());

        visaResponseList.add(visaResponse);
    }

    private void visaResponseObjectBuilder(List<VisaResponse> visaResponseList, List<VisaRequest> visaRequests) {
        for (int i = 0, visaRequestsSize = visaRequests.size(); i < visaRequestsSize; i++) {
            VisaRequest visa = visaRequests.get(i);
            visaResponseObjectBuilder2(visaResponseList, visa);
        }
    }

    private List<RecentBookingResponse> getRecentBookingResponses(String bookingNo, List<RecentBookingResponse> bookingList) {
        Optional<Reservation> optionalReservation = reservationRepository.findFirstByBookingNumberEquals(bookingNo);
        if (optionalReservation.isPresent()) {
            RecentBookingResponse recentBookingResponse = new RecentBookingResponse();
            recentBookingResponse.setAmount(optionalReservation.get().getSellingPrice().doubleValue());
            recentBookingResponse.setBookingDate(optionalReservation.get().getDateCreated());
            recentBookingResponse.setBookingStatus(optionalReservation.get().getReservationStatus().getValue());
            recentBookingResponse.setBookingNumber(optionalReservation.get().getBookingNumber());
            bookingList.add(recentBookingResponse);
        }
        return bookingList;
    }

    private List<RecentBookingResponse> reservationToRecentBookingResponse(List<Reservation> reservationList) {
        List<RecentBookingResponse> bookingList = new ArrayList<>();
        reservationList.forEach(reservation -> {
            RecentBookingResponse recentBookingResponse = new RecentBookingResponse();
            recentBookingResponse.setAmount(reservation.getSellingPrice().doubleValue());
            recentBookingResponse.setBookingDate(reservation.getDateCreated());
            recentBookingResponse.setBookingStatus(reservation.getReservationStatus().getValue());
            recentBookingResponse.setBookingNumber(reservation.getBookingNumber());
            bookingList.add(recentBookingResponse);
        });
        return bookingList;
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
