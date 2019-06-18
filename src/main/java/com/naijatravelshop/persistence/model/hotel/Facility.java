package com.naijatravelshop.persistence.model.hotel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "facility")
public class Facility implements Serializable {

    private String name;
    private String type;
    private String facilityGroup;
    private Long costInformation;
    private String note;
    private Long facilityId;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFacilityGroup() {
        return facilityGroup;
    }

    public void setFacilityGroup(String facilityGroup) {
        this.facilityGroup = facilityGroup;
    }

    public Long getCostInformation() {
        return costInformation;
    }

    public void setCostInformation(Long costInformation) {
        this.costInformation = costInformation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

