package com.naijatravelshop.service.hotel.pojos.response.prebook;

import com.naijatravelshop.service.hotel.pojos.response.ReturnStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "PreBookResponse")
public class PreBookResponse implements Serializable {

    private ReturnStatus returnStatus;

    private String preBookingToken;

    private Integer currencyID;

    private Integer totalPrice;

    private Integer totalCommission;

    private Integer VATOnCommission;

    private List<Cancellation> cancellations;

    @XmlElement(name = "ReturnStatus")
    public ReturnStatus getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(ReturnStatus returnStatus) {
        this.returnStatus = returnStatus;
    }

    @XmlElement(name = "PreBookingToken")
    public String getPreBookingToken() {
        return preBookingToken;
    }

    public void setPreBookingToken(String preBookingToken) {
        this.preBookingToken = preBookingToken;
    }

    @XmlElement(name = "CurrencyID")
    public Integer getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
    }

    @XmlElement(name = "TotalPrice")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @XmlElement(name = "TotalCommission")
    public Integer getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Integer totalCommission) {
        this.totalCommission = totalCommission;
    }

    @XmlElement(name = "VATOnCommission")
    public Integer getVATOnCommission() {
        return VATOnCommission;
    }

    public void setVATOnCommission(Integer VATOnCommission) {
        this.VATOnCommission = VATOnCommission;
    }

    @XmlElement(name = "Cancellation")
    @XmlElementWrapper(name = "Cancellations")
    public List<Cancellation> getCancellations() {
        return cancellations;
    }

    public void setCancellations(List<Cancellation> cancellations) {
        this.cancellations = cancellations;
    }

    @Override
    public String toString() {
        return "PreBookResponse{" + "returnStatus=" + returnStatus + ", preBookingToken=" + preBookingToken + ", currencyID=" + currencyID + ", totalPrice=" + totalPrice + ", totalCommission=" + totalCommission + ", VATOnCommission=" + VATOnCommission + ", cancellations=" + cancellations + '}';
    }

}

