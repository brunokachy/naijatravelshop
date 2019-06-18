package com.naijatravelshop.service.hotel.pojos.response.propertydetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "MinMaxStay")
public class MinMaxStay {

    private Integer propertyRoomTypeID;

    private String startDate;

    private String endDate;

    private Integer minStay;

    private Integer maxStay;

    private Boolean arriveMon;

    private Boolean arriveTue;

    private Boolean arriveWed;

    private Boolean arriveThu;

    private Boolean arriveFri;

    private Boolean arriveSat;

    private Boolean arriveSun;

    private Boolean departMon;

    private Boolean departTue;

    private Boolean departWed;

    private Boolean departThu;

    private Boolean departFri;

    private Boolean departSat;

    private Boolean departSun;

    @XmlElement(name = "PropertyRoomTypeID")
    public Integer getPropertyRoomTypeID() {
        return propertyRoomTypeID;
    }

    public void setPropertyRoomTypeID(Integer propertyRoomTypeID) {
        this.propertyRoomTypeID = propertyRoomTypeID;
    }

    @XmlElement(name = "StartDate")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @XmlElement(name = "EndDate")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @XmlElement(name = "MinStay")
    public Integer getMinStay() {
        return minStay;
    }

    public void setMinStay(Integer minStay) {
        this.minStay = minStay;
    }

    @XmlElement(name = "MaxStay")
    public Integer getMaxStay() {
        return maxStay;
    }

    public void setMaxStay(Integer maxStay) {
        this.maxStay = maxStay;
    }

    @XmlElement(name = "ArriveMon")
    public Boolean getArriveMon() {
        return arriveMon;
    }

    public void setArriveMon(Boolean arriveMon) {
        this.arriveMon = arriveMon;
    }

    @XmlElement(name = "ArriveTue")
    public Boolean getArriveTue() {
        return arriveTue;
    }

    public void setArriveTue(Boolean arriveTue) {
        this.arriveTue = arriveTue;
    }

    @XmlElement(name = "ArriveWed")
    public Boolean getArriveWed() {
        return arriveWed;
    }

    public void setArriveWed(Boolean arriveWed) {
        this.arriveWed = arriveWed;
    }

    @XmlElement(name = "ArriveThu")
    public Boolean getArriveThu() {
        return arriveThu;
    }

    public void setArriveThu(Boolean arriveThu) {
        this.arriveThu = arriveThu;
    }

    @XmlElement(name = "ArriveFri")
    public Boolean getArriveFri() {
        return arriveFri;
    }

    public void setArriveFri(Boolean arriveFri) {
        this.arriveFri = arriveFri;
    }

    @XmlElement(name = "ArriveSat")
    public Boolean getArriveSat() {
        return arriveSat;
    }

    public void setArriveSat(Boolean arriveSat) {
        this.arriveSat = arriveSat;
    }

    @XmlElement(name = "ArriveSun")
    public Boolean getArriveSun() {
        return arriveSun;
    }

    public void setArriveSun(Boolean arriveSun) {
        this.arriveSun = arriveSun;
    }

    @XmlElement(name = "DepartMon")
    public Boolean getDepartMon() {
        return departMon;
    }

    public void setDepartMon(Boolean departMon) {
        this.departMon = departMon;
    }

    @XmlElement(name = "DepartTue")
    public Boolean getDepartTue() {
        return departTue;
    }

    public void setDepartTue(Boolean departTue) {
        this.departTue = departTue;
    }

    @XmlElement(name = "DepartWed")
    public Boolean getDepartWed() {
        return departWed;
    }

    public void setDepartWed(Boolean departWed) {
        this.departWed = departWed;
    }

    @XmlElement(name = "DepartThu")
    public Boolean getDepartThu() {
        return departThu;
    }

    public void setDepartThu(Boolean departThu) {
        this.departThu = departThu;
    }

    @XmlElement(name = "DepartFri")
    public Boolean getDepartFri() {
        return departFri;
    }

    public void setDepartFri(Boolean departFri) {
        this.departFri = departFri;
    }

    @XmlElement(name = "DepartSat")
    public Boolean getDepartSat() {
        return departSat;
    }

    public void setDepartSat(Boolean departSat) {
        this.departSat = departSat;
    }

    @XmlElement(name = "DepartSun")
    public Boolean getDepartSun() {
        return departSun;
    }

    public void setDepartSun(Boolean departSun) {
        this.departSun = departSun;
    }

    @Override
    public String toString() {
        return "MinMaxStay{" + "propertyRoomTypeID=" + propertyRoomTypeID + ", startDate=" + startDate + ", endDate=" + endDate + ", minStay=" + minStay + ", maxStay=" + maxStay + ", arriveMon=" + arriveMon + ", arriveTue=" + arriveTue + ", arriveWed=" + arriveWed + ", arriveThu=" + arriveThu + ", arriveFri=" + arriveFri + ", arriveSat=" + arriveSat + ", arriveSun=" + arriveSun + ", departMon=" + departMon + ", departTue=" + departTue + ", departWed=" + departWed + ", departThu=" + departThu + ", departFri=" + departFri + ", departSat=" + departSat + ", departSun=" + departSun + '}';
    }


}

