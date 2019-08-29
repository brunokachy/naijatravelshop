package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Bruno on
 * 14/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class RoomType {
    private String name;
    private RateBases rateBases;
    private String _roomtypecode;
}
