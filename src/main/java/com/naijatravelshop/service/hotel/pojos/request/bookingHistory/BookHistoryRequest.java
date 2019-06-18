package com.naijatravelshop.service.hotel.pojos.request.bookingHistory;

import com.naijatravelshop.service.hotel.pojos.request.JacTravelApiCredential;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "BookRequest")
public class BookHistoryRequest {

    private JacTravelApiCredential loginDetails;

    private Integer bookingReference;

    @XmlElement(name = "LoginDetails")
    public JacTravelApiCredential getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(JacTravelApiCredential loginDetails) {
        this.loginDetails = loginDetails;
    }

    @XmlElement(name = "BookingReference")
    public Integer getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(Integer bookingReference) {
        this.bookingReference = bookingReference;
    }

    @Override
    public String toString() {
        return "BookHistoryRequest{" + "loginDetails=" + loginDetails + ", bookingReference=" + bookingReference + '}';
    }

}

