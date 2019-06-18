package com.naijatravelshop.service.hotel.pojos.request.book;


import com.naijatravelshop.service.hotel.pojos.request.search.ChildAge;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "RoomBooking")
public class RoomBooking {

    private Integer propertyRoomTypeID;

    private String bookingToken;

    private Integer mealBasisID;

    private Integer adults;

    private Integer children;

    private Integer infants;

    private List<Guest> guests;

    private List<ChildAge> childAge;

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

    @XmlElement(name = "Adults")
    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @XmlElement(name = "Children")
    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @XmlElement(name = "Infants")
    public Integer getInfants() {
        return infants;
    }

    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    @XmlElement(name = "Guest")
    @XmlElementWrapper(name = "Guests")
    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    @XmlElement(name = "ChildAge")
    @XmlElementWrapper(name = "ChildAges")
    public List<ChildAge> getChildAge() {
        return childAge;
    }

    public void setChildAge(List<ChildAge> childAge) {
        this.childAge = childAge;
    }

    @Override
    public String toString() {
        return "RoomBooking{" + "propertyRoomTypeID=" + propertyRoomTypeID + ", bookingToken=" + bookingToken + ", mealBasisID=" + mealBasisID + ", adults=" + adults + ", children=" + children + ", infants=" + infants + ", guests=" + guests + '}';
    }

}

