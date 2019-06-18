package com.naijatravelshop.service.hotel.pojos.request.search;


import com.naijatravelshop.service.hotel.pojos.request.JacTravelApiCredential;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "SearchRequest")
public class SearchHotelRequest {
    private JacTravelApiCredential loginDetails;

    private SearchDetail searchDetails;

    public void setLoginDetails(JacTravelApiCredential loginDetails) {
        this.loginDetails = loginDetails;
    }

    public void setSearchDetails(SearchDetail searchDetails) {
        this.searchDetails = searchDetails;
    }

    @XmlElement(name = "LoginDetails")
    public JacTravelApiCredential getLoginDetails() {
        return loginDetails;
    }


    @XmlElement(name = "SearchDetails")
    public SearchDetail getSearchDetails() {
        return searchDetails;
    }

    @Override
    public String toString() {
        return "SearchHotelRequest{" + "loginDetails=" + loginDetails + ", searchDetails=" + searchDetails + '}';
    }
}
