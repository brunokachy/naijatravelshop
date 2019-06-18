package com.naijatravelshop.service.hotel.pojos.response.bookingHistory;

import com.naijatravelshop.service.hotel.pojos.response.ReturnStatus;
import com.naijatravelshop.service.hotel.pojos.response.search.Adjustment;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "BookingResponse")
public class BookingResponse {

    private ReturnStatus returnStatus;

    private Integer currencyID;

    private String bookingReference;

    private String status;

    private String accountStatus;

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

    private Double totalPrice;

    private Double totalOutstanding;

    private Double totalCommission;

    private List<Property> properties;

    private List<Room> rooms;

    private List<Adjustment> adjustments;

    private List<OptionalSupplement> optionalSupplements;

    private List<Erratum> errata;

    private List<Comment> comments;

    @XmlElement(name = "ReturnStatus")
    public ReturnStatus getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(ReturnStatus returnStatus) {
        this.returnStatus = returnStatus;
    }

    @XmlElement(name = "CurrencyID")
    public Integer getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
    }

    @XmlElement(name = "BookingReference")
    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    @XmlElement(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name = "AccountStatus")
    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
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

    @XmlElement(name = "TotalPrice")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @XmlElement(name = "TotalOutstanding")
    public Double getTotalOutstanding() {
        return totalOutstanding;
    }

    public void setTotalOutstanding(Double totalOutstanding) {
        this.totalOutstanding = totalOutstanding;
    }

    @XmlElement(name = "TotalCommission")
    public Double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }

    @XmlElement(name = "Property")
    @XmlElementWrapper(name = "Properties")
    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @XmlElement(name = "Room")
    @XmlElementWrapper(name = "Rooms")
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @XmlElement(name = "Adjustment")
    @XmlElementWrapper(name = "Adjustments")
    public List<Adjustment> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<Adjustment> adjustments) {
        this.adjustments = adjustments;
    }

    @XmlElement(name = "OptionalSupplement")
    @XmlElementWrapper(name = "OptionalSupplements")
    public List<OptionalSupplement> getOptionalSupplements() {
        return optionalSupplements;
    }

    public void setOptionalSupplements(List<OptionalSupplement> optionalSupplements) {
        this.optionalSupplements = optionalSupplements;
    }

    @XmlElement(name = "Erratum")
    @XmlElementWrapper(name = "Errata")
    public List<Erratum> getErrata() {
        return errata;
    }

    public void setErrata(List<Erratum> errata) {
        this.errata = errata;
    }

    @XmlElement(name = "Comment")
    @XmlElementWrapper(name = "Comments")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "BookingResponse{" + "returnStatus=" + returnStatus + ", currencyID=" + currencyID + ", bookingReference=" + bookingReference + ", status=" + status + ", accountStatus=" + accountStatus + ", leadGuestTitle=" + leadGuestTitle + ", leadGuestFirstName=" + leadGuestFirstName + ", leadGuestLastName=" + leadGuestLastName + ", leadGuestAddress1=" + leadGuestAddress1 + ", leadGuestAddress2=" + leadGuestAddress2 + ", leadGuestTownCity=" + leadGuestTownCity + ", leadGuestCounty=" + leadGuestCounty + ", leadGuestPostCode=" + leadGuestPostCode + ", leadGuestBookingCountryID=" + leadGuestBookingCountryID + ", leadGuestPhone=" + leadGuestPhone + ", leadGuestFax=" + leadGuestFax + ", leadGuestEmail=" + leadGuestEmail + ", totalPrice=" + totalPrice + ", totalOutstanding=" + totalOutstanding + ", totalCommission=" + totalCommission + ", properties=" + properties + ", rooms=" + rooms + ", adjustments=" + adjustments + ", optionalSupplements=" + optionalSupplements + ", errata=" + errata + ", comments=" + comments + '}';
    }

}

