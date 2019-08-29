package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Bruno on
 * 11/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class Request {

    private BookingDetails bookingDetails;

    @XmlElement(name = "return")
    private Return returns;

    @Value("${dotw.request.command}")
    private String _command;
}
