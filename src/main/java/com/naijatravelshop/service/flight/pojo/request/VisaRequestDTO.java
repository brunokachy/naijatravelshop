package com.naijatravelshop.service.flight.pojo.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Bruno on
 * 05/06/2019
 */
@Getter
@Setter
@ToString
public class VisaRequestDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Date departureDate;

    private Date returnDate;

    private String countryOfResidence;

    private String destinationCountry;

    private String message;

    private String requestById;
}
