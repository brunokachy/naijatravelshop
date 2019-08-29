package com.naijatravelshop.client.hotel.service;

import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Result;
import com.naijatravelshop.service.hotel.pojo.request.SearchHotelDTO;

public interface GOTWClientService {

    Result searchHotel(SearchHotelDTO searchHotelDTO);
}
