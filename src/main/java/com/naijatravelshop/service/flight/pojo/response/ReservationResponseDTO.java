package com.naijatravelshop.service.flight.pojo.response;

/**
 * Created by Bruno on
 * 18/05/2019
 */

public class ReservationResponseDTO {

    private String bookingNumber;

    private Long reservationId;

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
