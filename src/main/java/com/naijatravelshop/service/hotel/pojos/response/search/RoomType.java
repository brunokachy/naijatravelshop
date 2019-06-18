package com.naijatravelshop.service.hotel.pojos.response.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "RoomType")
public class RoomType implements Serializable {

    private Integer seq;

    private Integer propertyRoomTypeID;

    private String bookingToken;

    private Integer mealBasisID;

    private String roomType;

    private String roomView;

    private String mealBasis;

    private Double subTotal;

    private Double discount;

    private String specialOfferApplied;

    private boolean onRequest;

    private Double total;

    private Integer commission;

    private Double RSP;

    private Integer adults;

    private Integer infants;

    private Integer children;

    private List<Adjustment> adjustments;

    private List<Erratum> errata;

    private List<Cancellation> cancellations;

    @XmlElement(name = "Seq")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @XmlElement(name = "PropertyRoomTypeID")
    public Integer getPropertyRoomTypeID() {
        return propertyRoomTypeID;
    }

    public void setPropertyRoomTypeID(Integer propertyRoomTypeID) {
        this.propertyRoomTypeID = propertyRoomTypeID;
    }

    @XmlElement(name = "BookingToken")
    public String getBookingToken() {
        return bookingToken;
    }

    public void setBookingToken(String bookingToken) {
        this.bookingToken = bookingToken;
    }

    @XmlElement(name = "MealBasisID")
    public Integer getMealBasisID() {
        return mealBasisID;
    }

    public void setMealBasisID(Integer mealBasisID) {
        this.mealBasisID = mealBasisID;
    }

    @XmlElement(name = "RoomType")
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @XmlElement(name = "RoomView")
    public String getRoomView() {
        return roomView;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    @XmlElement(name = "MealBasis")
    public String getMealBasis() {
        return mealBasis;
    }

    public void setMealBasis(String mealBasis) {
        this.mealBasis = mealBasis;
    }

    @XmlElement(name = "SubTotal")
    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @XmlElement(name = "Discount")
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @XmlElement(name = "SpecialOfferApplied")
    public String getSpecialOfferApplied() {
        return specialOfferApplied;
    }

    public void setSpecialOfferApplied(String specialOfferApplied) {
        this.specialOfferApplied = specialOfferApplied;
    }

    @XmlElement(name = "OnRequest")
    public boolean isOnRequest() {
        return onRequest;
    }

    public void setOnRequest(boolean onRequest) {
        this.onRequest = onRequest;
    }

    @XmlElement(name = "Total")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @XmlElement(name = "Commission")
    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    @XmlElement(name = "RSP")
    public Double getRSP() {
        return RSP;
    }

    public void setRSP(Double RSP) {
        this.RSP = RSP;
    }

    @XmlElement(name = "Adults")
    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @XmlElement(name = "Infants")
    public Integer getInfants() {
        return infants;
    }

    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    @XmlElement(name = "Children")
    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @XmlElement(name = "Adjustment")
    @XmlElementWrapper(name = "Adjustments")
    public List<Adjustment> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<Adjustment> adjustments) {
        this.adjustments = adjustments;
    }

    @XmlElement(name = "Erratum")
    @XmlElementWrapper(name = "Errata")
    public List<Erratum> getErrata() {
        return errata;
    }

    public void setErrata(List<Erratum> errata) {
        this.errata = errata;
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
        return "RoomType{" + "seq=" + seq + ", propertyRoomTypeID=" + propertyRoomTypeID + ", bookingToken=" + bookingToken + ", mealBasisID=" + mealBasisID + ", roomType=" + roomType + ", roomView=" + roomView + ", mealBasis=" + mealBasis + ", subTotal=" + subTotal + ", discount=" + discount + ", specialOfferApplied=" + specialOfferApplied + ", onRequest=" + onRequest + ", total=" + total + ", commission=" + commission + ", RSP=" + RSP + ", adults=" + adults + ", infants=" + infants + ", children=" + children + ", adjustments=" + adjustments + ", errata=" + errata + '}';
    }

}

