package com.naijatravelshop.service.portal.pojo.response;

import com.naijatravelshop.service.flight.pojo.request.FlightSegmentsDTO;
import com.naijatravelshop.service.flight.pojo.request.TravellerDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by Bruno on
 * 23/06/2019
 */
public class FlightReservationResponse {
    private String bookingNumber;
    private Long sellingPrice;
    private String reservationStatus;
    private Date dateProcessed;
    private TravellerDTO reservationOwner;

    private Date bookingDate;
    private Integer numberOfAdult = 1;
    private Integer numberOfChildren = 0;
    private Integer numberOfInfant = 0;
    private Boolean visaServiceRequested = false;
    private Boolean hotelServiceRequested = false;

    private List<TravellerDTO> travellers;

    private String paymentReference;
    private String paymentStatus;
    private Date paymentDate;
    private String transactionId;

    List<FlightSegmentsDTO> flightRoutes;

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Long getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Long sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Date getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(Date dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public TravellerDTO getReservationOwner() {
        return reservationOwner;
    }

    public void setReservationOwner(TravellerDTO reservationOwner) {
        this.reservationOwner = reservationOwner;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(Integer numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Integer getNumberOfInfant() {
        return numberOfInfant;
    }

    public void setNumberOfInfant(Integer numberOfInfant) {
        this.numberOfInfant = numberOfInfant;
    }

    public Boolean getVisaServiceRequested() {
        return visaServiceRequested;
    }

    public void setVisaServiceRequested(Boolean visaServiceRequested) {
        this.visaServiceRequested = visaServiceRequested;
    }

    public Boolean getHotelServiceRequested() {
        return hotelServiceRequested;
    }

    public void setHotelServiceRequested(Boolean hotelServiceRequested) {
        this.hotelServiceRequested = hotelServiceRequested;
    }

    public List<TravellerDTO> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<TravellerDTO> travellers) {
        this.travellers = travellers;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public List<FlightSegmentsDTO> getFlightRoutes() {
        return flightRoutes;
    }

    public void setFlightRoutes(List<FlightSegmentsDTO> flightRoutes) {
        this.flightRoutes = flightRoutes;
    }
}
