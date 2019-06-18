package com.naijatravelshop.persistence.model.flight;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "airport")
public class Airport implements Serializable {
    private String name;
    private String iataCode;
    private String icaoCode;
    private String latitude;
    private String longitude;
    private String timezone;
    private String gmt;
    private String contactPhone;
    private String website;
    private Integer popularityIndex;
    private Integer priority = 0;
    private Timestamp lastUpdate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private FlightCity flightCity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getGmt() {
        return gmt;
    }

    public void setGmt(String gmt) {
        this.gmt = gmt;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getPopularityIndex() {
        return popularityIndex;
    }

    public void setPopularityIndex(Integer popularityIndex) {
        this.popularityIndex = popularityIndex;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightCity getFlightCity() {
        return flightCity;
    }

    public void setFlightCity(FlightCity flightCity) {
        this.flightCity = flightCity;
    }
}
