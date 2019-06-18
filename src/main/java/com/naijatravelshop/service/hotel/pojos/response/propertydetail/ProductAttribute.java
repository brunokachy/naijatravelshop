package com.naijatravelshop.service.hotel.pojos.response.propertydetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "ProductAttribute")
public class ProductAttribute {

    private Integer productAttributeID;

    private String productAttribute;

    @XmlElement(name = "ProductAttributeID")
    public Integer getProductAttributeID() {
        return productAttributeID;
    }

    public void setProductAttributeID(Integer productAttributeID) {
        this.productAttributeID = productAttributeID;
    }

    @XmlElement(name = "ProductAttribute")
    public String getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(String productAttribute) {
        this.productAttribute = productAttribute;
    }

    @Override
    public String toString() {
        return "ProductAttribute{" + "productAttributeID=" + productAttributeID + ", productAttribute=" + productAttribute + '}';
    }



}