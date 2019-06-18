package com.naijatravelshop.service.hotel.pojos.response.propertydetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "BedType")
public class BedType {

    private String bedType;

    @XmlElement(name = "BedType")
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Override
    public String toString() {
        return "BedType{" + "bedType=" + bedType + '}';
    }



}
