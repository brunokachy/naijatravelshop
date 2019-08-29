package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class Language {
    private String _id;
    private String _name;
    private String __cdata;
    private List<AmenitieItem> amenitieItem;
    private List<LeisureItem> leisureItem;
    private List<BusinessItem> businessItem;
}
