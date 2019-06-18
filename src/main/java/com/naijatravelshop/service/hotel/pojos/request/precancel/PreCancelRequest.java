package com.naijatravelshop.service.hotel.pojos.request.precancel;

import com.naijatravelshop.service.hotel.pojos.request.JacTravelApiCredential;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "PreCancelRequest")
public class PreCancelRequest {

    private JacTravelApiCredential loginDetails;

    private String bookingReference;

    @XmlElement(name = "LoginDetails")
    public JacTravelApiCredential getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(JacTravelApiCredential loginDetails) {
        this.loginDetails = loginDetails;
    }

    @XmlElement(name = "BookingReference")
    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    @Override
    public String toString() {
        return "PreCancelRequest{" + "loginDetails=" + loginDetails + ", bookingReference=" + bookingReference + '}';
    }

}

