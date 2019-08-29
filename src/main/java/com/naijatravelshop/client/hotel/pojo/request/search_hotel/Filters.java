package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class Filters {
    private String city;
    private String noPrice;

    @XmlAttribute(name = "xmlns: a")
    private String xmlnsa;

    @XmlAttribute(name = "xmlns: c")
    private String xmlnsc;

    private Condition condition;
}
