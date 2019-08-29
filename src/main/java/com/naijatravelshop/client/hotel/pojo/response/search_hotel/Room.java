package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Bruno on
 * 14/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class Room {

    private List<RoomType> roomType;
    private String _adults;
    private String _children;
    private String _extrabeds;
}
