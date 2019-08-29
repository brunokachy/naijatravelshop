package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

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
public class Condition {
    private String fieldName;
    private String fieldTest;
    private FieldValues fieldValues;
    private String __prefix;
    private Condition condition;
}
