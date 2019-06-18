package com.naijatravelshop.service.hotel.pojos.response.bookingHistory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "Property")
public class Property {

    private Integer propertyBookingReference;

    private Integer duration;

    private String arrivalDate;

    private String propertyName;

    private Double rating;

    private String status;

    private String country;

    private String region;

    private String resort;

    private String hotelAddress;

    @XmlElement(name = "PropertyBookingReference")
    public Integer getPropertyBookingReference() {
        return propertyBookingReference;
    }

    public void setPropertyBookingReference(Integer propertyBookingReference) {
        this.propertyBookingReference = propertyBookingReference;
    }

    @XmlElement(name = "Duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @XmlElement(name = "ArrivalDate")
    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @XmlElement(name = "PropertyName")
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @XmlElement(name = "Rating")
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @XmlElement(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @XmlElement(name = "HotelAddress")
    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    @Override
    public String toString() {
        return "Property{" + "propertyBookingReference=" + propertyBookingReference + ", duration=" + duration + ", arrivalDate=" + arrivalDate + ", propertyName=" + propertyName + ", rating=" + rating + ", status=" + status + ", country=" + country + ", region=" + region + ", resort=" + resort + ", hotelAddress=" + hotelAddress + '}';
    }

}

