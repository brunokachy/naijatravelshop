package com.naijatravelshop.service.hotel.pojo.request;

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
@Getter
@Setter
@ToString
public class RoomDTO {
    //private String adultsCode;

    // private String roomNumber;

    // private List<ChildDTO> children;

    private Integer numberOfAdults;
    private Integer numberOfChildren;
    private List<Integer> adultsAgeList;
    private List<Integer> childrenAgeList;
}
