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
@XmlRootElement(name = "PropertyResult")
public class PropertyResult implements Serializable {

    private Integer totalProperties;

    private Integer propertyID;

    private Integer propertyReferenceID;

    private String propertyName;

    private Integer rating;

    private Integer ourRating;

    private String country;

    private String region;

    private String resort;

    private List<RoomType> roomTypes;

    @XmlElement(name = "TotalProperties")
    public Integer getTotalProperties() {
        return totalProperties;
    }

    public void setTotalProperties(Integer totalProperties) {
        this.totalProperties = totalProperties;
    }

    @XmlElement(name = "PropertyID")
    public Integer getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }

    @XmlElement(name = "PropertyReferenceID")
    public Integer getPropertyReferenceID() {
        return propertyReferenceID;
    }

    public void setPropertyReferenceID(Integer propertyReferenceID) {
        this.propertyReferenceID = propertyReferenceID;
    }

    @XmlElement(name = "PropertyName")
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @XmlElement(name = "Rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @XmlElement(name = "OurRating")
    public Integer getOurRating() {
        return ourRating;
    }

    public void setOurRating(Integer ourRating) {
        this.ourRating = ourRating;
    }

    @XmlElement(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "Region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @XmlElement(name = "Resort")
    public String getResort() {
        return resort;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    @XmlElement(name = "RoomType")
    @XmlElementWrapper(name = "RoomTypes")
    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    @Override
    public String toString() {
        return "PropertyResult{" + "totalProperties=" + totalProperties + ", propertyID=" + propertyID + ", propertyReferenceID=" + propertyReferenceID + ", propertyName=" + propertyName + ", rating=" + rating + ", ourRating=" + ourRating + ", country=" + country + ", region=" + region + ", resort=" + resort + ", roomTypes=" + roomTypes + '}';
    }

}
