package com.naijatravelshop.service.hotel.pojos.response.bookingHistory;

import com.naijatravelshop.service.hotel.pojos.request.book.Guest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "Room")
public class Room {

    private String roomType;

    private String roomView;

    private String mealBasis;

    private Integer mealBasisId;

    private Integer adults;

    private Integer children;

    private Integer infants;

    private List<Guest> guests;

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

    @XmlElement(name = "MealBasisID")
    public Integer getMealBasisId() {
        return mealBasisId;
    }

    public void setMealBasisId(Integer mealBasisId) {
        this.mealBasisId = mealBasisId;
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

    @Override
    public String toString() {
        return "Room{" + "roomType=" + roomType + ", roomView=" + roomView + ", mealBasis=" + mealBasis + ", adults=" + adults + ", children=" + children + ", infants=" + infants + ", guests=" + guests + '}';
    }

}
