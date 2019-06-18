package com.naijatravelshop.service.hotel.pojos.request.cancel;

import com.naijatravelshop.service.hotel.pojos.request.JacTravelApiCredential;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "CancelRequest")
public class CancelRequest {

    private JacTravelApiCredential loginDetails;

    private String bookingReference;

    private Double cancellationCost;

    private String cancellationToken;

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

    @XmlElement(name = "CancellationCost")
    public Double getCancellationCost() {
        return cancellationCost;
    }

    public void setCancellationCost(Double cancellationCost) {
        this.cancellationCost = cancellationCost;
    }

    @XmlElement(name = "CancellationToken")
    public String getCancellationToken() {
        return cancellationToken;
    }

    public void setCancellationToken(String cancellationToken) {
        this.cancellationToken = cancellationToken;
    }

    @Override
    public String toString() {
        return "CancelRequest{" + "loginDetails=" + loginDetails + ", bookingReference=" + bookingReference + ", cancellationCost=" + cancellationCost + ", cancellationToken=" + cancellationToken + '}';
    }

}

