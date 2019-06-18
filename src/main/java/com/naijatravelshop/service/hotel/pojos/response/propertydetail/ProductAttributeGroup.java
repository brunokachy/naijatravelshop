package com.naijatravelshop.service.hotel.pojos.response.propertydetail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "ProductAttributeGroup")
public class ProductAttributeGroup {

    private Integer productAttributeGroupID;

    private String productAttributeGroup;

    private List<ProductAttribute> productAttributes;

    @XmlElement(name = "ProductAttributeGroupID")
    public Integer getProductAttributeGroupID() {
        return productAttributeGroupID;
    }

    public void setProductAttributeGroupID(Integer productAttributeGroupID) {
        this.productAttributeGroupID = productAttributeGroupID;
    }

    @XmlElement(name = "ProductAttributeGroup")
    public String getProductAttributeGroup() {
        return productAttributeGroup;
    }

    public void setProductAttributeGroup(String productAttributeGroup) {
        this.productAttributeGroup = productAttributeGroup;
    }

    @XmlElement(name = "ProductAttribute")
    @XmlElementWrapper(name = "ProductAttributes")
    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

    @Override
    public String toString() {
        return "ProductAttributeGroup{" + "productAttributeGroupID=" + productAttributeGroupID + ", productAttributeGroup=" + productAttributeGroup + ", productAttributes=" + productAttributes + '}';
    }



}

