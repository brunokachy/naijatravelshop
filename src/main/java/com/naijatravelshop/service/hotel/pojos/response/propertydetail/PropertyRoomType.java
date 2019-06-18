package com.naijatravelshop.service.hotel.pojos.response.propertydetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "PropertyRoomType")
public class PropertyRoomType {

    private Integer propertyRoomTypeID;

    private String roomType;

    private String roomView;

    private String defaultMealBasis;

    private List<BedType> bedTypes;

    private List<Facility> facilities;

    @XmlElement(name = "PropertyRoomTypeID")
    public Integer getPropertyRoomTypeID() {
        return propertyRoomTypeID;
    }

    public void setPropertyRoomTypeID(Integer propertyRoomTypeID) {
        this.propertyRoomTypeID = propertyRoomTypeID;
    }

    @XmlElement(name = "RoomType")
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @XmlElement(name = "RoomView")
    public String getRoomView() {
        return roomView;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    @XmlElement(name = "DefaultMealBasis")
    public String getDefaultMealBasis() {
        return defaultMealBasis;
    }

    public void setDefaultMealBasis(String defaultMealBasis) {
        this.defaultMealBasis = defaultMealBasis;
    }

    @XmlElement(name = "BedType")
    @XmlElementWrapper(name = "BedTypes")
    public List<BedType> getBedTypes() {
        return bedTypes;
    }

    public void setBedTypes(List<BedType> bedTypes) {
        this.bedTypes = bedTypes;
    }

    @XmlElement(name = "Facility")
    @XmlElementWrapper(name = "Facilities")
    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "PropertyRoomType{" + "propertyRoomTypeID=" + propertyRoomTypeID + ", roomType=" + roomType + ", roomView=" + roomView + ", defaultMealBasis=" + defaultMealBasis + ", bedTypes=" + bedTypes + ", facilities=" + facilities + '}';
    }

}

