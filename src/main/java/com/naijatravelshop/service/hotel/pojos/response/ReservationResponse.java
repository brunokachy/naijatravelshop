package com.naijatravelshop.service.hotel.pojos.response;

import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 09/05/2019
 */

public class ReservationResponse {
    private String bookingNumber;
    private Timestamp dateBooked;
    private String reservationStatus;
    private Long reservationId;

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Timestamp getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(Timestamp dateBooked) {
        this.dateBooked = dateBooked;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
