package com.naijatravelshop.service.hotel.pojos.response.book;

import com.naijatravelshop.service.hotel.pojos.response.ReturnStatus;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "BookResponse")
public class BookResponse {

    private ReturnStatus returnStatus;

    private Integer currencyID;

    private String bookingReference;

    private String tradeReference;

    private Double totalPrice;

    private Double totalCommission;

    private Double customerTotalPrice;

    private List<PaymentDue> paymentDue;

    private List<PropertyBooking> propertyBookings;

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

    @XmlElement(name = "TradeReference")
    public String getTradeReference() {
        return tradeReference;
    }

    public void setTradeReference(String tradeReference) {
        this.tradeReference = tradeReference;
    }

    @XmlElement(name = "TotalPrice")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @XmlElement(name = "TotalCommission")
    public Double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }

    @XmlElement(name = "CustomerTotalPrice")
    public Double getCustomerTotalPrice() {
        return customerTotalPrice;
    }

    public void setCustomerTotalPrice(Double customerTotalPrice) {
        this.customerTotalPrice = customerTotalPrice;
    }

    @XmlElement(name = "PaymentDue")
    @XmlElementWrapper(name = "PaymentDues")
    public List<PaymentDue> getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(List<PaymentDue> paymentDue) {
        this.paymentDue = paymentDue;
    }

    @XmlElement(name = "PropertyBooking")
    @XmlElementWrapper(name = "PropertyBookings")
    public List<PropertyBooking> getPropertyBookings() {
        return propertyBookings;
    }

    public void setPropertyBookings(List<PropertyBooking> propertyBookings) {
        this.propertyBookings = propertyBookings;
    }

    @Override
    public String toString() {
        return "BookResponse{" + "returnStatus=" + returnStatus + ", currencyID=" + currencyID + ", bookingReference=" + bookingReference + ", tradeReference=" + tradeReference + ", totalPrice=" + totalPrice + ", totalCommission=" + totalCommission + ", customerTotalPrice=" + customerTotalPrice + ", paymentDue=" + paymentDue + ", propertyBookings=" + propertyBookings + '}';
    }

}

