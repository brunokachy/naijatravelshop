package com.naijatravelshop.service.hotel.pojos.request.prebook;

import com.naijatravelshop.service.hotel.pojos.request.JacTravelApiCredential;
import com.naijatravelshop.service.hotel.pojos.request.book.BookingDetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "PreBookRequest")
public class PreBookRequest {

    private JacTravelApiCredential loginDetails;

    private BookingDetail bookingDetails;

    @XmlElement(name = "LoginDetails")
    public JacTravelApiCredential getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(JacTravelApiCredential loginDetails) {
        this.loginDetails = loginDetails;
    }

    @XmlElement(name = "BookingDetails")
    public BookingDetail getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetail bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    @Override
    public String toString() {
        return "PreBookRequest{" + "loginDetails=" + loginDetails + ", bookingDetails=" + bookingDetails + '}';
    }

}
