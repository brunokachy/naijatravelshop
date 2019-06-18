package com.naijatravelshop.service.hotel.pojos.response.propertydetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "Facility")
public class Facility {

    private String facilityType;

    private Integer facilityID;

    private String facilityGroup;

    private String facility;

    private String notes;

    private Integer costInformation;

    @XmlElement(name = "FacilityType")
    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    @XmlElement(name = "FacilityID")
    public Integer getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(Integer facilityID) {
        this.facilityID = facilityID;
    }

    @XmlElement(name = "FacilityGroup")
    public String getFacilityGroup() {
        return facilityGroup;
    }

    public void setFacilityGroup(String facilityGroup) {
        this.facilityGroup = facilityGroup;
    }

    @XmlElement(name = "Facility")
    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    @XmlElement(name = "Notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlElement(name = "CostInformation")
    public Integer getCostInformation() {
        return costInformation;
    }

    public void setCostInformation(Integer costInformation) {
        this.costInformation = costInformation;
    }

    @Override
    public String toString() {
        return "Facility{" + "facilityType=" + facilityType + ", facilityID=" + facilityID + ", facilityGroup=" + facilityGroup + ", facility=" + facility + ", notes=" + notes + ", costInformation=" + costInformation + '}';
    }
}

