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
@Getter
@Setter
@ToString
@Builder
public class BookingDetails {
    private String fromDate;

    private String toDate;

    @Value("${dotw.currency.code}")
    private String currency;

    private Rooms rooms;
}
