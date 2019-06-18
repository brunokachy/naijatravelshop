package com.naijatravelshop.service.hotel.pojos.response.book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "PropertyBooking")
public class PropertyBooking {

    private String propertyBookingReference;

    private String supplier;

    private String supplierReference;

    @XmlElement(name = "PropertyBookingReference")
    public String getPropertyBookingReference() {
        return propertyBookingReference;
    }

    public void setPropertyBookingReference(String propertyBookingReference) {
        this.propertyBookingReference = propertyBookingReference;
    }

    @XmlElement(name = "Supplier")
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @XmlElement(name = "SupplierReference")
    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    @Override
    public String toString() {
        return "PropertyBooking{" + "propertyBookingReference=" + propertyBookingReference + ", supplier=" + supplier + ", supplierReference=" + supplierReference + '}';
    }

}

