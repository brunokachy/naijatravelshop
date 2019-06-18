package com.naijatravelshop.service.hotel.pojos.response.bookingHistory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "Erratum")
public class Erratum {

    private String erratum;

    @XmlElement(name = "Erratum")
    public String getErratum() {
        return erratum;
    }

    public void setErratum(String erratum) {
        this.erratum = erratum;
    }

    @Override
    public String toString() {
        return "Erratum{" + "erratum=" + erratum + '}';
    }

}