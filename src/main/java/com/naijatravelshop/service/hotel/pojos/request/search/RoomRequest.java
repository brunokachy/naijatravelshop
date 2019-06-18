package com.naijatravelshop.service.hotel.pojos.request.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "RoomRequest")
public class RoomRequest {
    private Integer adults;

    private Integer children;

    private Integer infants;

    private List<ChildAge> childAges;

    @XmlElement(name = "Adults")
    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @XmlElement(name = "Children")
    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @XmlElement(name = "Infants")
    public Integer getInfants() {
        return infants;
    }

    public void setInfants(Integer infants) {
        this.infants = infants;
    }

    @XmlElement(name = "ChildAge")
    @XmlElementWrapper(name = "ChildAges")
    public List<ChildAge> getChildAges() {
        return childAges;
    }

    public void setChildAges(List<ChildAge> childAges) {
        this.childAges = childAges;
    }

    @Override
    public String toString() {
        return "RoomRequest{" + "adults=" + adults + ", children=" + children + ", infants=" + infants + ", childAges=" + childAges + '}';
    }

}
