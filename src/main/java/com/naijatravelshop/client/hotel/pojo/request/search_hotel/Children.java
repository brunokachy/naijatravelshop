package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class Children {
    private String _no;
    private List<Child> child;
}
