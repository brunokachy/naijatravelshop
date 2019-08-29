package com.naijatravelshop.client.hotel.pojo.response.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class Image {
    private String alt;
    private Category category;
    private Url url;
    private String _runno;
}
