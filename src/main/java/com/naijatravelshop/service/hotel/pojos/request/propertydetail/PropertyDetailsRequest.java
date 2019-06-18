package com.naijatravelshop.service.hotel.pojos.request.propertydetail;

import com.naijatravelshop.service.hotel.pojos.request.JacTravelApiCredential;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "PropertyDetailsRequest")
public class PropertyDetailsRequest {

    private JacTravelApiCredential loginDetails;

    private Integer propertyID;

    private Integer propertyReferenceID;

    @XmlElement(name = "LoginDetails")
    public JacTravelApiCredential getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(JacTravelApiCredential loginDetails) {
        this.loginDetails = loginDetails;
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

}
