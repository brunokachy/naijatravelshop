package com.naijatravelshop.persistence.model.hotel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "location")
public class Location implements Serializable {
    private String country;
    @Column(name = "region_i_d")
    private Integer regionID;
    private String region;
    @Column(name = "resort_i_d")
    private Integer resortID;
    private String resort;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getResortID() {
        return resortID;
    }

    public void setResortID(Integer resortID) {
        this.resortID = resortID;
    }

    public String getResort() {
        return resort;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
