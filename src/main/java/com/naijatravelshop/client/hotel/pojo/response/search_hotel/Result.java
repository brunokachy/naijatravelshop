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
public class Result {
    private String currencyShort;
    private String successful;
    private String _command;
    private String _tID;
    private String _ip;
    private String _date;
    private String _version;
    private String _elapsedTime;
    private List<Hotel> hotels;
}