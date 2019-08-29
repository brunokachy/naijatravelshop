package com.naijatravelshop.service.hotel.pojo.response;

import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Amenitie;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Business;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Description;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.GeoPoint;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Image;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Images;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Leisure;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Thumb;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Builder
@ToString
@Getter
@Setter
public class HotelResponse {

    private String fullDescription;
    private String smallDescription;
    private String hotelName;
    private String address;
    private String cityName;
    private String cityCode;
    private String countryName;
    private String countryCode;
    private String lat;
    private String lng;
    private String hotelId;
    private String rating;
    private List<String> facilities;
    private String thumbImageURL;
    private List<String> images;
    private Double minimumPrice;
    private Double maximumPrice;
    private List<RoomResponse> rooms;

}
