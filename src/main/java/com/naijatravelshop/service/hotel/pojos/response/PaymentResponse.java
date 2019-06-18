package com.naijatravelshop.service.hotel.pojos.response;

import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 09/05/2019
 */

public class PaymentResponse {
    private String paymentReference;
    private String paymentStatus;
    private String paymentChannel;
    private Long amountInKobo;
    private Timestamp paymentDate;
    private String payerName;
    private String payerPhone;
    private String payerEmail;
    private String transactionId;
    private String payerPaymentChannel;
    private Long amountActualPaidInKobo;
    private Long reservationId;

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public Long getAmountInKobo() {
        return amountInKobo;
    }

    public void setAmountInKobo(Long amountInKobo) {
        this.amountInKobo = amountInKobo;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPayerPaymentChannel() {
        return payerPaymentChannel;
    }

    public void setPayerPaymentChannel(String payerPaymentChannel) {
        this.payerPaymentChannel = payerPaymentChannel;
    }

    public Long getAmountActualPaidInKobo() {
        return amountActualPaidInKobo;
    }

    public void setAmountActualPaidInKobo(Long amountActualPaidInKobo) {
        this.amountActualPaidInKobo = amountActualPaidInKobo;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
