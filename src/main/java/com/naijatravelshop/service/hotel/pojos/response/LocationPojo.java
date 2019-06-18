package com.naijatravelshop.service.hotel.pojos.response;

/**
 * Created by Bruno on
 * 08/05/2019
 */

public class LocationPojo {

    private Long id;

    private String country;

    private String region;

    private String resort;

    private Integer regionID;

    private Integer resortID;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getResort() {
        return resort;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public Integer getResortID() {
        return resortID;
    }

    public void setResortID(Integer resortID) {
        this.resortID = resortID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
