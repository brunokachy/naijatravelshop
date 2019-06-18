package com.naijatravelshop.persistence.model.hotel;

import com.naijatravelshop.persistence.model.generic.AuditModel;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "hotel_booking_detail")
public class HotelBookingDetail extends AuditModel implements Serializable {
    @Column(nullable = false)
    private Timestamp checkinDate;
    @Column(nullable = false)
    private Timestamp checkoutDate;
    @ManyToOne
    private Property property;
    private Integer numberOfRoom = 0;
    private Integer numberOfInfant = 0;
    private Integer numberOfAdult = 0;
    private Integer numberOfChildren = 0;
    private Long commissionableTotalInKobo;
    private Long nightlyRateTotalInKobo;
    private Long surchargeTotalInKobo;
    private Long markupInKobo;
    private Long totalAmountPayableInKobo;
    private Integer numberOfNightsStay;
    private String smokingPreference;
    private String bookingResponseJSONDump;
    private String bookingResponseMessage;
    private String supplierReference;
    private String cancelResponseMessage;

    public Timestamp getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Timestamp checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Timestamp getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Timestamp checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Integer getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(Integer numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public Integer getNumberOfInfant() {
        return numberOfInfant;
    }

    public void setNumberOfInfant(Integer numberOfInfant) {
        this.numberOfInfant = numberOfInfant;
    }

    public Integer getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(Integer numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Long getCommissionableTotalInKobo() {
        return commissionableTotalInKobo;
    }

    public void setCommissionableTotalInKobo(Long commissionableTotalInKobo) {
        this.commissionableTotalInKobo = commissionableTotalInKobo;
    }

    public Long getNightlyRateTotalInKobo() {
        return nightlyRateTotalInKobo;
    }

    public void setNightlyRateTotalInKobo(Long nightlyRateTotalInKobo) {
        this.nightlyRateTotalInKobo = nightlyRateTotalInKobo;
    }

    public Long getSurchargeTotalInKobo() {
        return surchargeTotalInKobo;
    }

    public void setSurchargeTotalInKobo(Long surchargeTotalInKobo) {
        this.surchargeTotalInKobo = surchargeTotalInKobo;
    }

    public Long getMarkupInKobo() {
        return markupInKobo;
    }

    public void setMarkupInKobo(Long markupInKobo) {
        this.markupInKobo = markupInKobo;
    }

    public Long getTotalAmountPayableInKobo() {
        return totalAmountPayableInKobo;
    }

    public void setTotalAmountPayableInKobo(Long totalAmountPayableInKobo) {
        this.totalAmountPayableInKobo = totalAmountPayableInKobo;
    }

    public Integer getNumberOfNightsStay() {
        return numberOfNightsStay;
    }

    public void setNumberOfNightsStay(Integer numberOfNightsStay) {
        this.numberOfNightsStay = numberOfNightsStay;
    }

    public String getSmokingPreference() {
        return smokingPreference;
    }

    public void setSmokingPreference(String smokingPreference) {
        this.smokingPreference = smokingPreference;
    }

    public String getBookingResponseJSONDump() {
        return bookingResponseJSONDump;
    }

    public void setBookingResponseJSONDump(String bookingResponseJSONDump) {
        this.bookingResponseJSONDump = bookingResponseJSONDump;
    }

    public String getBookingResponseMessage() {
        return bookingResponseMessage;
    }

    public void setBookingResponseMessage(String bookingResponseMessage) {
        this.bookingResponseMessage = bookingResponseMessage;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getCancelResponseMessage() {
        return cancelResponseMessage;
    }

    public void setCancelResponseMessage(String cancelResponseMessage) {
        this.cancelResponseMessage = cancelResponseMessage;
    }
}
