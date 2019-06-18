package com.naijatravelshop.service.hotel.pojos.response.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "Adjustment")
public class Adjustment {

    private String adjustmentType;

    private String adjustmentName;

    private String adjustment;

    private Double totalAmount;

    private Double total;

    @XmlElement(name = "AdjustmentType")
    public String getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    @XmlElement(name = "AdjustmentName")
    public String getAdjustmentName() {
        return adjustmentName;
    }

    public void setAdjustmentName(String adjustmentName) {
        this.adjustmentName = adjustmentName;
    }

    @XmlElement(name = "Adjustment")
    public String getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(String adjustment) {
        this.adjustment = adjustment;
    }

    @XmlElement(name = "TotalAmount")
    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }


    @XmlElement(name = "Total")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Adjustment{" + "adjustmentType=" + adjustmentType + ", adjustmentName=" + adjustmentName + ", total=" + total + '}';
    }

}
