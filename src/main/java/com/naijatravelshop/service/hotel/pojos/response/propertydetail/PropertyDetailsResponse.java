package com.naijatravelshop.service.hotel.pojos.response.propertydetail;

import com.naijatravelshop.service.hotel.pojos.response.ReturnStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "PropertyDetailsResponse")
public class PropertyDetailsResponse {

    private ReturnStatus returnStatus;

    private Integer propertyID;

    private Integer propertyReferenceID;

    private String propertyName;

    private Integer propertyTypeID;

    private String propertyType;

    private Double rating;

    private Integer geographyLevel1ID;

    private Integer geographyLevel2ID;

    private Integer geographyLevel3ID;

    private String country;

    private String region;

    private String resort;

    private String address1;

    private String address2;

    private String townCity;

    private String county;

    private String postCode;

    private String telephone;

    private String fax;

    private String latitude;

    private String longitude;

    private Integer minAdults;

    private Integer maxAdults;

    private Integer maxChildren;

    private String strapline;

    private String description;

    private String CMSBaseURL;

    private String mainImage;

    private String mainImageThumbnail;

    private List<Image> images;

    private List<PropertyRoomType> propertyRoomTypes;

    private List<ProductAttributeGroup> productAttribtuteGroups;

    private List<SpecialOffer> specialOffers;

    private String arrangements;

    private List<RestrictedArrival> restrictedArrivals;

    private List<MinMaxStay> minMaxStays;

    @XmlElement(name = "ReturnStatus")
    public ReturnStatus getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(ReturnStatus returnStatus) {
        this.returnStatus = returnStatus;
    }

    @XmlElement(name = "PropertyID")
    public Integer getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }

    @XmlElement(name = "PropertyReferenceID")
    public Integer getPropertyReferenceID() {
        return propertyReferenceID;
    }

    public void setPropertyReferenceID(Integer propertyReferenceID) {
        this.propertyReferenceID = propertyReferenceID;
    }

    @XmlElement(name = "PropertyName")
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @XmlElement(name = "PropertyTypeID")
    public Integer getPropertyTypeID() {
        return propertyTypeID;
    }

    public void setPropertyTypeID(Integer propertyTypeID) {
        this.propertyTypeID = propertyTypeID;
    }

    @XmlElement(name = "PropertyType")
    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @XmlElement(name = "Rating")
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @XmlElement(name = "GeographyLevel1ID")
    public Integer getGeographyLevel1ID() {
        return geographyLevel1ID;
    }

    public void setGeographyLevel1ID(Integer geographyLevel1ID) {
        this.geographyLevel1ID = geographyLevel1ID;
    }

    @XmlElement(name = "GeographyLevel2ID")
    public Integer getGeographyLevel2ID() {
        return geographyLevel2ID;
    }

    public void setGeographyLevel2ID(Integer geographyLevel2ID) {
        this.geographyLevel2ID = geographyLevel2ID;
    }

    @XmlElement(name = "GeographyLevel3ID")
    public Integer getGeographyLevel3ID() {
        return geographyLevel3ID;
    }

    public void setGeographyLevel3ID(Integer geographyLevel3ID) {
        this.geographyLevel3ID = geographyLevel3ID;
    }

    @XmlElement(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "Region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @XmlElement(name = "Resort")
    public String getResort() {
        return resort;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    @XmlElement(name = "Address1")
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @XmlElement(name = "Address2")
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @XmlElement(name = "TownCity")
    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    @XmlElement(name = "County")
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @XmlElement(name = "PostCode")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @XmlElement(name = "Telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlElement(name = "Fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @XmlElement(name = "Latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @XmlElement(name = "Longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @XmlElement(name = "MinAdults")
    public Integer getMinAdults() {
        return minAdults;
    }

    public void setMinAdults(Integer minAdults) {
        this.minAdults = minAdults;
    }

    @XmlElement(name = "MaxAdults")
    public Integer getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(Integer maxAdults) {
        this.maxAdults = maxAdults;
    }

    @XmlElement(name = "MaxChildren")
    public Integer getMaxChildren() {
        return maxChildren;
    }

    public void setMaxChildren(Integer maxChildren) {
        this.maxChildren = maxChildren;
    }

    @XmlElement(name = "Strapline")
    public String getStrapline() {
        return strapline;
    }

    public void setStrapline(String strapline) {
        this.strapline = strapline;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "CMSBaseURL")
    public String getCMSBaseURL() {
        return CMSBaseURL;
    }

    public void setCMSBaseURL(String CMSBaseURL) {
        this.CMSBaseURL = CMSBaseURL;
    }

    @XmlElement(name = "MainImage")
    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    @XmlElement(name = "MainImageThumbnail")
    public String getMainImageThumbnail() {
        return mainImageThumbnail;
    }

    public void setMainImageThumbnail(String mainImageThumbnail) {
        this.mainImageThumbnail = mainImageThumbnail;
    }

    @XmlElement(name = "Image")
    @XmlElementWrapper(name = "Images")
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @XmlElement(name = "PropertyRoomType")
    @XmlElementWrapper(name = "PropertyRoomTypes")
    public List<PropertyRoomType> getPropertyRoomTypes() {
        return propertyRoomTypes;
    }

    public void setPropertyRoomTypes(List<PropertyRoomType> propertyRoomTypes) {
        this.propertyRoomTypes = propertyRoomTypes;
    }

    @XmlElement(name = "ProductAttributeGroup")
    @XmlElementWrapper(name = "ProductAttributeGroups")
    public List<ProductAttributeGroup> getProductAttribtuteGroups() {
        return productAttribtuteGroups;
    }

    public void setProductAttribtuteGroups(List<ProductAttributeGroup> productAttribtuteGroups) {
        this.productAttribtuteGroups = productAttribtuteGroups;
    }

    @XmlElement(name = "SpecialOffer")
    @XmlElementWrapper(name = "SpecialOffers")
    public List<SpecialOffer> getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(List<SpecialOffer> specialOffers) {
        this.specialOffers = specialOffers;
    }

    @XmlElement(name = "Arrangements")
    public String getArrangements() {
        return arrangements;
    }

    public void setArrangements(String arrangements) {
        this.arrangements = arrangements;
    }

    @XmlElement(name = "RestrictedArrival")
    @XmlElementWrapper(name = "RestrictedArrivals")
    public List<RestrictedArrival> getRestrictedArrivals() {
        return restrictedArrivals;
    }

    public void setRestrictedArrivals(List<RestrictedArrival> restrictedArrivals) {
        this.restrictedArrivals = restrictedArrivals;
    }

    @XmlElement(name = "MinMaxStay")
    @XmlElementWrapper(name = "MinMaxStays")
    public List<MinMaxStay> getMinMaxStays() {
        return minMaxStays;
    }

    public void setMinMaxStays(List<MinMaxStay> minMaxStays) {
        this.minMaxStays = minMaxStays;
    }

    @Override
    public String toString() {
        return "PropertyDetailsResponse{" + "returnStatus=" + returnStatus + ", propertyID=" + propertyID + ", propertyReferenceID=" + propertyReferenceID + ", propertyName=" + propertyName + ", propertyTypeID=" + propertyTypeID + ", propertyType=" + propertyType + ", rating=" + rating + ", geographyLevel1ID=" + geographyLevel1ID + ", geographyLevel2ID=" + geographyLevel2ID + ", geographyLevel3ID=" + geographyLevel3ID + ", country=" + country + ", region=" + region + ", resort=" + resort + ", address1=" + address1 + ", address2=" + address2 + ", townCity=" + townCity + ", county=" + county + ", postCode=" + postCode + ", telephone=" + telephone + ", fax=" + fax + ", latitude=" + latitude + ", longitude=" + longitude + ", minAdults=" + minAdults + ", maxAdults=" + maxAdults + ", maxChildren=" + maxChildren + ", strapline=" + strapline + ", description=" + description + ", CMSBaseURL=" + CMSBaseURL + ", mainImage=" + mainImage + ", mainImageThumbnail=" + mainImageThumbnail + ", images=" + images + ", propertyRoomTypes=" + propertyRoomTypes + ", productAttribtuteGroups=" + productAttribtuteGroups + ", specialOffers=" + specialOffers + ", arrangements=" + arrangements + ", restrictedArrivals=" + restrictedArrivals + ", minMaxStays=" + minMaxStays + '}';
    }

}
