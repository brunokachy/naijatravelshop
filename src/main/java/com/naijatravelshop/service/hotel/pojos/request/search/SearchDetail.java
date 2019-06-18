package com.naijatravelshop.service.hotel.pojos.request.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "SearchDetails")
public class SearchDetail {

    private String checkInDate;

    private Integer duration;

    private Integer regionID;

    private Integer mealBasisID;

    private Integer minStarRating;

    private List<RoomRequest> roomRequests;

    @XmlElement(name = "ArrivalDate")
    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    @XmlElement(name = "Duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @XmlElement(name = "RegionID")
    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    @XmlElement(name = "MealBasisID")
    public Integer getMealBasisID() {
        return mealBasisID;
    }

    public void setMealBasisID(Integer mealBasisID) {
        this.mealBasisID = mealBasisID;
    }

    @XmlElement(name = "MinStarRating")
    public Integer getMinStarRating() {
        return minStarRating;
    }

    public void setMinStarRating(Integer minStarRating) {
        this.minStarRating = minStarRating;
    }

    @XmlElement(name = "RoomRequest")
    @XmlElementWrapper(name = "RoomRequests")
    public List<RoomRequest> getRoomRequests() {
        return roomRequests;
    }

    public void setRoomRequests(List<RoomRequest> roomRequests) {
        this.roomRequests = roomRequests;
    }

    @Override
    public String toString() {
        return "SearchDetails{" + "checkInDate=" + checkInDate + ", duration=" + duration + ", regionID=" + regionID + ", mealBasisID=" + mealBasisID + ", minStarRating=" + minStarRating + ", roomRequests=" + roomRequests + '}';
    }
}
