package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Builder
@ToString
@Getter
@Setter
public class Customer {

    @Value("${dotw.login.id}")
    public String username;

    @Value("${dotw.login.password}")
    private String password;

    @Value("${dotw.company.code}")
    private String id;

    @Value("${dotw.source}")
    private String source;

    @Value("${dotw.product}")
    private String product;

    private Request request;
}
