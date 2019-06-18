package com.naijatravelshop.persistence.model.hotel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "property")
public class Property implements Serializable {

    private Long referenceId;
    private String name;
    @Column(name = "geography_level3_id")
    private Long geographyLevel3Id;
    @Column(name = "geography_level2_id")
    private Long geographyLevel2Id;
    private String firstAddress;
    private String secondAddress;
    private String townCity;
    private String county;
    private String postCodeZip;
    private String country;
    private String telephone;
    private String fax;
    private String latitude;
    private String longitude;
    private String resort;
    private String region;
    private String country1;
    private String type;
    private String propertyGroup;
    private Double rating;
    private String airport;
    @Column(name = "thumbnail_u_r_l")
    private String thumbnailURL;
    private String facilities;
    private String description;
    private String attribute;
    private String image1url;
    private String image2url;
    private String image3url;
    private String image4url;
    private String image5url;
    private String image6url;
    private String image7url;
    private String image8url;
    private String image9url;
    private String image10url;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGeographyLevel3Id() {
        return geographyLevel3Id;
    }

    public void setGeographyLevel3Id(Long geographyLevel3Id) {
        this.geographyLevel3Id = geographyLevel3Id;
    }

    public Long getGeographyLevel2Id() {
        return geographyLevel2Id;
    }

    public void setGeographyLevel2Id(Long geographyLevel2Id) {
        this.geographyLevel2Id = geographyLevel2Id;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCodeZip() {
        return postCodeZip;
    }

    public void setPostCodeZip(String postCodeZip) {
        this.postCodeZip = postCodeZip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public String getResort() {
        return resort;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry1() {
        return country1;
    }

    public void setCountry1(String country1) {
        this.country1 = country1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyGroup() {
        return propertyGroup;
    }

    public void setPropertyGroup(String propertyGroup) {
        this.propertyGroup = propertyGroup;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getImage1url() {
        return image1url;
    }

    public void setImage1url(String image1url) {
        this.image1url = image1url;
    }

    public String getImage2url() {
        return image2url;
    }

    public void setImage2url(String image2url) {
        this.image2url = image2url;
    }

    public String getImage3url() {
        return image3url;
    }

    public void setImage3url(String image3url) {
        this.image3url = image3url;
    }

    public String getImage4url() {
        return image4url;
    }

    public void setImage4url(String image4url) {
        this.image4url = image4url;
    }

    public String getImage5url() {
        return image5url;
    }

    public void setImage5url(String image5url) {
        this.image5url = image5url;
    }

    public String getImage6url() {
        return image6url;
    }

    public void setImage6url(String image6url) {
        this.image6url = image6url;
    }

    public String getImage7url() {
        return image7url;
    }

    public void setImage7url(String image7url) {
        this.image7url = image7url;
    }

    public String getImage8url() {
        return image8url;
    }

    public void setImage8url(String image8url) {
        this.image8url = image8url;
    }

    public String getImage9url() {
        return image9url;
    }

    public void setImage9url(String image9url) {
        this.image9url = image9url;
    }

    public String getImage10url() {
        return image10url;
    }

    public void setImage10url(String image10url) {
        this.image10url = image10url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
