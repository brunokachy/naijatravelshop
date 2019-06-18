package com.naijatravelshop.service.hotel.pojos.response.cancel;

import com.naijatravelshop.service.hotel.pojos.response.ReturnStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "CancelResponse")
public class CancelResponse {

    private ReturnStatus returnStatus;

    @XmlElement(name = "ReturnStatus")
    public ReturnStatus getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(ReturnStatus returnStatus) {
        this.returnStatus = returnStatus;
    }

    @Override
    public String toString() {
        return "CancelResponse{" + "returnStatus=" + returnStatus + '}';
    }

}

