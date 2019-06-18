package com.naijatravelshop.service.hotel.pojos.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
public class ReturnStatus {

    private boolean success;

    private String exception;

    @XmlElement(name = "Success")
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @XmlElement(name = "Exception")
    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "ReturnStatus{" + "success=" + success + ", exception=" + exception + '}';
    }


}
