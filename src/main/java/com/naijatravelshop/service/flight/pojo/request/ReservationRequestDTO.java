package com.naijatravelshop.service.flight.pojo.request;

import java.util.List;

/**
 * Created by Bruno on
 * 18/05/2019
 */

public class ReservationRequestDTO {
    private String status;
    private String message;
    private String referenceNumber;
    private String bookingNumber;
    private String ticketLimitDate;
    private Integer paidAmount;
    private String paymentReference;
    private String paymentType;
    private String confirmed;
    private String bookingExpireTime;
    private String reservationType;
    private String portalUsername;
    private FlightDetailDTO flightDetails;
    private FlightDataSearchDTO flightSearch;
    private String flightSummary;

    private String title;

    private String description;

    private Integer amount;

    private TravellerDTO reservationOwner;

    private List<TravellerDTO> travellers;

    private String departureDate;

    private String arrivalDate;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getTicketLimitDate() {
        return ticketLimitDate;
    }

    public void setTicketLimitDate(String ticketLimitDate) {
        this.ticketLimitDate = ticketLimitDate;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getBookingExpireTime() {
        return bookingExpireTime;
    }

    public void setBookingExpireTime(String bookingExpireTime) {
        this.bookingExpireTime = bookingExpireTime;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public TravellerDTO getReservationOwner() {
        return reservationOwner;
    }

    public void setReservationOwner(TravellerDTO reservationOwner) {
        this.reservationOwner = reservationOwner;
    }

    public List<TravellerDTO> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<TravellerDTO> travellers) {
        this.travellers = travellers;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getPortalUsername() {
        return portalUsername;
    }

    public void setPortalUsername(String portalUsername) {
        this.portalUsername = portalUsername;
    }

    public FlightDetailDTO getFlightDetails() {
        return flightDetails;
    }

    public void setFlightDetails(FlightDetailDTO flightDetails) {
        this.flightDetails = flightDetails;
    }

    public FlightDataSearchDTO getFlightSearch() {
        return flightSearch;
    }

    public void setFlightSearch(FlightDataSearchDTO flightSearch) {
        this.flightSearch = flightSearch;
    }

    public String getFlightSummary() {
        return flightSummary;
    }

    public void setFlightSummary(String flightSummary) {
        this.flightSummary = flightSummary;
    }
}
