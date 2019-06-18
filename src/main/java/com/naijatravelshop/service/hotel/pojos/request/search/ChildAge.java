package com.naijatravelshop.service.hotel.pojos.request.search;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 14/04/2019
 */
@XmlRootElement(name = "ChildAge")
public class ChildAge {

    private Integer age;

    @XmlElement(name = "Age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ChildAge{" + "age=" + age + '}';
    }


}

