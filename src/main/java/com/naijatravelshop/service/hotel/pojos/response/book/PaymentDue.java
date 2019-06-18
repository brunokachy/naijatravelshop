package com.naijatravelshop.service.hotel.pojos.response.book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "PaymentDue")
public class PaymentDue {

    private Double paymentDue;

    @XmlElement(name = "PaymentDue")
    public Double getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(Double paymentDue) {
        this.paymentDue = paymentDue;
    }

    @Override
    public String toString() {
        return "PaymentDue{" + "paymentDue=" + paymentDue + '}';
    }

}
