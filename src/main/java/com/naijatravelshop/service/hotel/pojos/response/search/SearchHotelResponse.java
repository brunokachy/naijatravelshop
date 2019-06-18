package com.naijatravelshop.service.hotel.pojos.response.search;

import com.naijatravelshop.service.hotel.pojos.response.ReturnStatus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "SearchResponse")
public class SearchHotelResponse {

    private ReturnStatus returnStatus;

    private Integer currencyID;

    private List<PropertyResult> propertyResults;

    @XmlElement(name = "ReturnStatus")
    public ReturnStatus getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(ReturnStatus returnStatus) {
        this.returnStatus = returnStatus;
    }

    @XmlElement(name = "CurrencyID")
    public Integer getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
    }

    @XmlElement(name = "PropertyResult")
    @XmlElementWrapper(name = "PropertyResults")
    public List<PropertyResult> getPropertyResults() {
        return propertyResults;
    }

    public void setPropertyResults(List<PropertyResult> propertyResults) {
        this.propertyResults = propertyResults;
    }

    @Override
    public String toString() {
        return "SearchHotelResponse{" + "returnStatus=" + returnStatus + ", currencyID=" + currencyID + ", propertyResults=" + propertyResults + '}';
    }

}