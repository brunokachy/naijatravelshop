package com.naijatravelshop.service.hotel.pojos.response.propertydetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "RestrictedArrival")
public class RestrictedArrival {

    private String startDate;

    private String endDate;

    private Boolean arriveMon;

    private Boolean arriveTue;

    private Boolean arriveWed;

    private Boolean arriveThu;

    private Boolean arriveFri;

    private Boolean arriveSat;

    private Boolean arriveSun;

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

    @Override
    public String toString() {
        return "RestrictedArrival{" + "startDate=" + startDate + ", endDate=" + endDate + ", arriveMon=" + arriveMon + ", arriveTue=" + arriveTue + ", arriveWed=" + arriveWed + ", arriveThu=" + arriveThu + ", arriveFri=" + arriveFri + ", arriveSat=" + arriveSat + ", arriveSun=" + arriveSun + '}';
    }



}
