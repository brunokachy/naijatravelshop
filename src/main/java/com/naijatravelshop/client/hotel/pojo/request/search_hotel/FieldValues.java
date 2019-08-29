package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Getter
@Setter
@ToString
@Builder
public class FieldValues {

    List<String> fieldValue;
}
