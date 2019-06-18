package com.naijatravelshop.service.hotel.pojos.response.bookingHistory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "OptionalSupplement")
public class OptionalSupplement {

    private Integer contractSupplementID;

    private String supplement;

    private String description;

    @XmlElement(name = "ContractSupplementID")
    public Integer getContractSupplementID() {
        return contractSupplementID;
    }

    public void setContractSupplementID(Integer contractSupplementID) {
        this.contractSupplementID = contractSupplementID;
    }

    @XmlElement(name = "Supplement")
    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "OptionalSupplement{" + "contractSupplementID=" + contractSupplementID + ", supplement=" + supplement + ", description=" + description + '}';
    }

}

