package com.naijatravelshop.service.portal.service;

import com.naijatravelshop.service.portal.pojo.request.BookingSearchDTO;
import com.naijatravelshop.service.portal.pojo.request.PasswordDTO;
import com.naijatravelshop.service.portal.pojo.request.UserDTO;
import com.naijatravelshop.service.portal.pojo.response.*;

import java.util.List;

public interface PortalService {

    UserResponse createUserAccount(UserDTO userDTO);

    UserResponse updateUserAccount(UserDTO userDTO);

    UserResponse deactivateUserAccount(UserDTO userDTO);

    UserResponse reactivateUserAccount(UserDTO userDTO);

    UserResponse resetPassword(UserDTO userDTO);

    UserResponse changePassword(PasswordDTO passwordDTO);

    UserResponse login(UserDTO userDTO);

    AffiliateAccountDetail getAffiliateAccountDetail();

    String getApiBaseUrl();

    List<RecentBookingResponse> getRecentBooking();

    List<RecentBookingResponse> getFlightBookingBySearchTerm(BookingSearchDTO bookingSearchDTO);

    RecentBookingResponse changeBookingStatus(BookingSearchDTO bookingSearchDTO);

    FlightReservationResponse getFlightBookingDetails(String bookingNumber);

    List<VisaResponse> getRecentVisaRequest(BookingSearchDTO bookingSearchDTO);

    List<VisaResponse> getVisaRequestsBySearchTerm(BookingSearchDTO bookingSearchDTO);

    VisaResponse changeVisaRequestStatus(BookingSearchDTO bookingSearchDTO);

    List<UserResponse> getPortalUsers();

}
