package com.naijatravelshop.service.hotel.pojos.response.precancel;

import com.naijatravelshop.service.hotel.pojos.response.ReturnStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "PreCancelResponse")
public class PreCancelResponse {

    private ReturnStatus returnStatus;

    private Integer currencyID;

    private String bookingReference;

    private Double cancellationCost;

    private String cancellationToken;

    @XmlElement(name = "ReturnStatus")
    public ReturnStatus getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(ReturnStatus returnStatus) {
        this.returnStatus = returnStatus;
    }

    @XmlElement(name = "CurrencyID")
    public Integer getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
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
        return "PreCancelResponse{" + "returnStatus=" + returnStatus + ", currencyID=" + currencyID + ", bookingReference=" + bookingReference + ", cancellationCost=" + cancellationCost + ", cancellationToken=" + cancellationToken + '}';
    }

}

