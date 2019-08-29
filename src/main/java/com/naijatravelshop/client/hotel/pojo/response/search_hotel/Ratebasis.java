package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by Bruno on
 * 12/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class Ratebasis {

    Ratetype rateType;
    private String total;
    private String _id;
}
