package com.naijatravelshop.service.hotel.pojos.request.book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "BookingDetails")
public class BookingDetail {

    private Integer propertyID;

    private String arrivalDate;

    private Integer duration;

    private List<RoomBooking> roomBookings;

    private String preBookingToken;

    private String leadGuestTitle;

    private String leadGuestFirstName;

    private String leadGuestLastName;

    private String leadGuestAddress1;

    private String leadGuestAddress2;

    private String leadGuestTownCity;

    private String leadGuestCounty;

    private String leadGuestPostCode;

    private Integer leadGuestBookingCountryID;

    private String leadGuestPhone;

    private String leadGuestFax;

    private String leadGuestEmail;

    private Date leadGuestDateOfBirth;

    private String request;

    private String tradeReference;

    @XmlElement(name = "PropertyID")
    public Integer getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }

    @XmlElement(name = "ArrivalDate")
    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @XmlElement(name = "Duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @XmlElement(name = "RoomBooking")
    @XmlElementWrapper(name = "RoomBookings")
    public List<RoomBooking> getRoomBookings() {
        return roomBookings;
    }

    public void setRoomBookings(List<RoomBooking> roomBookings) {
        this.roomBookings = roomBookings;
    }

    @XmlElement(name = "PreBookingToken")
    public String getPreBookingToken() {
        return preBookingToken;
    }

    public void setPreBookingToken(String preBookingToken) {
        this.preBookingToken = preBookingToken;
    }

    @XmlElement(name = "LeadGuestTitle")
    public String getLeadGuestTitle() {
        return leadGuestTitle;
    }

    public void setLeadGuestTitle(String leadGuestTitle) {
        this.leadGuestTitle = leadGuestTitle;
    }

    @XmlElement(name = "LeadGuestFirstName")
    public String getLeadGuestFirstName() {
        return leadGuestFirstName;
    }

    public void setLeadGuestFirstName(String leadGuestFirstName) {
        this.leadGuestFirstName = leadGuestFirstName;
    }

    @XmlElement(name = "LeadGuestLastName")
    public String getLeadGuestLastName() {
        return leadGuestLastName;
    }

    public void setLeadGuestLastName(String leadGuestLastName) {
        this.leadGuestLastName = leadGuestLastName;
    }

    @XmlElement(name = "LeadGuestAddress1")
    public String getLeadGuestAddress1() {
        return leadGuestAddress1;
    }

    public void setLeadGuestAddress1(String leadGuestAddress1) {
        this.leadGuestAddress1 = leadGuestAddress1;
    }

    @XmlElement(name = "LeadGuestAddress2")
    public String getLeadGuestAddress2() {
        return leadGuestAddress2;
    }

    public void setLeadGuestAddress2(String leadGuestAddress2) {
        this.leadGuestAddress2 = leadGuestAddress2;
    }

    @XmlElement(name = "LeadGuestTownCity")
    public String getLeadGuestTownCity() {
        return leadGuestTownCity;
    }

    public void setLeadGuestTownCity(String leadGuestTownCity) {
        this.leadGuestTownCity = leadGuestTownCity;
    }

    @XmlElement(name = "LeadGuestCounty")
    public String getLeadGuestCounty() {
        return leadGuestCounty;
    }

    public void setLeadGuestCounty(String leadGuestCounty) {
        this.leadGuestCounty = leadGuestCounty;
    }

    @XmlElement(name = "LeadGuestPostCode")
    public String getLeadGuestPostCode() {
        return leadGuestPostCode;
    }

    public void setLeadGuestPostCode(String leadGuestPostCode) {
        this.leadGuestPostCode = leadGuestPostCode;
    }

    @XmlElement(name = "LeadGuestBookingCountryID")
    public Integer getLeadGuestBookingCountryID() {
        return leadGuestBookingCountryID;
    }

    public void setLeadGuestBookingCountryID(Integer leadGuestBookingCountryID) {
        this.leadGuestBookingCountryID = leadGuestBookingCountryID;
    }

    @XmlElement(name = "LeadGuestPhone")
    public String getLeadGuestPhone() {
        return leadGuestPhone;
    }

    public void setLeadGuestPhone(String leadGuestPhone) {
        this.leadGuestPhone = leadGuestPhone;
    }

    @XmlElement(name = "LeadGuestFax")
    public String getLeadGuestFax() {
        return leadGuestFax;
    }

    public void setLeadGuestFax(String leadGuestFax) {
        this.leadGuestFax = leadGuestFax;
    }

    @XmlElement(name = "LeadGuestEmail")
    public String getLeadGuestEmail() {
        return leadGuestEmail;
    }

    public void setLeadGuestEmail(String leadGuestEmail) {
        this.leadGuestEmail = leadGuestEmail;
    }

    @XmlElement(name = "Request")
    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @XmlElement(name = "TradeReference")
    public String getTradeReference() {
        return tradeReference;
    }

    public void setTradeReference(String tradeReference) {
        this.tradeReference = tradeReference;
    }

    public Date getLeadGuestDateOfBirth() {
        return leadGuestDateOfBirth;
    }

    public void setLeadGuestDateOfBirth(Date leadGuestDateOfBirth) {
        this.leadGuestDateOfBirth = leadGuestDateOfBirth;
    }

    @Override
    public String toString() {
        return "BookingDetails{" + "propertyID=" + propertyID + ", arrivalDate=" + arrivalDate + ", duration=" + duration + ", roomBookings=" + roomBookings + ", preBookingToken=" + preBookingToken + ", leadGuestTitle=" + leadGuestTitle + ", leadGuestFirstName=" + leadGuestFirstName + ", leadGuestLastName=" + leadGuestLastName + ", leadGuestAddress1=" + leadGuestAddress1 + ", leadGuestAddress2=" + leadGuestAddress2 + ", leadGuestTownCity=" + leadGuestTownCity + ", leadGuestCounty=" + leadGuestCounty + ", leadGuestPostCode=" + leadGuestPostCode + ", leadGuestBookingCountryID=" + leadGuestBookingCountryID + ", leadGuestPhone=" + leadGuestPhone + ", leadGuestFax=" + leadGuestFax + ", leadGuestEmail=" + leadGuestEmail + ", request=" + request + ", tradeReference=" + tradeReference + '}';
    }

}

