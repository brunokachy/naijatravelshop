package com.naijatravelshop.service.hotel.pojos.response.propertydetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "SpecialOffer")
public class SpecialOffer {

    private Integer contractSpecialOfferID;

    private Integer specialOfferTemplateID;

    private String offerName;

    private String offerType;

    private String propertyRoomType;

    private String mealBasis;

    private String notes;

    private String customerNote;

    @XmlElement(name = "ContractSpecialOfferID")
    public Integer getContractSpecialOfferID() {
        return contractSpecialOfferID;
    }

    public void setContractSpecialOfferID(Integer contractSpecialOfferID) {
        this.contractSpecialOfferID = contractSpecialOfferID;
    }

    @XmlElement(name = "SpecialOfferTemplateID")
    public Integer getSpecialOfferTemplateID() {
        return specialOfferTemplateID;
    }

    public void setSpecialOfferTemplateID(Integer specialOfferTemplateID) {
        this.specialOfferTemplateID = specialOfferTemplateID;
    }

    @XmlElement(name = "OfferName")
    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    @XmlElement(name = "OfferType")
    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    @XmlElement(name = "PropertyRoomType")
    public String getPropertyRoomType() {
        return propertyRoomType;
    }

    public void setPropertyRoomType(String propertyRoomType) {
        this.propertyRoomType = propertyRoomType;
    }

    @XmlElement(name = "MealBasis")
    public String getMealBasis() {
        return mealBasis;
    }

    public void setMealBasis(String mealBasis) {
        this.mealBasis = mealBasis;
    }

    @XmlElement(name = "Notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlElement(name = "CustomerNote")
    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    @Override
    public String toString() {
        return "SpecialOffer{" + "contractSpecialOfferID=" + contractSpecialOfferID + ", specialOfferTemplateID=" + specialOfferTemplateID + ", offerName=" + offerName + ", offerType=" + offerType + ", propertyRoomType=" + propertyRoomType + ", mealBasis=" + mealBasis + ", notes=" + notes + ", customerNote=" + customerNote + '}';
    }

}

