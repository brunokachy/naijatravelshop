package com.naijatravelshop.service.hotel.pojos.response.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "Cancellation")
public class Cancellation {

    private String startDate;

    private String endDate;

    private Double penalty;

    @XmlElement(name = "StartDate")
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @XmlElement(name = "EndDate")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @XmlElement(name = "Penalty")
    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    @Override
    public String toString() {
        return "Cancellation{" + "startDate=" + startDate + ", endDate=" + endDate + ", penalty=" + penalty + '}';
    }

}
