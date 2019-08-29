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
public class Hotel {
    private Description description1;
    private Description description2;
    private String hotelName;
    private String address;
    private String cityName;
    private String cityCode;
    private String countryName;
    private String countryCode;
    private Amenitie amenitie;
    private Leisure leisure;
    private Business business;
    private String rating;
    private Images images;
    private GeoPoint geoPoint;
    private String _runno;
    private String _preferred;
    private String _exclusive;
    private String _cityname;
    private String _hotelid;
    private String _name;
    private String _id;
    private String allowBook;
    private Rooms rooms;
}
