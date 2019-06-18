package com.naijatravelshop.web.controllers.api;

import com.naijatravelshop.service.flight.pojo.request.ReservationRequestDTO;
import com.naijatravelshop.service.flight.pojo.request.VisaRequestDTO;
import com.naijatravelshop.service.flight.pojo.response.ReservationResponseDTO;
import com.naijatravelshop.service.flight.service.FlightService;
import com.naijatravelshop.web.pojo.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bruno on
 * 08/05/2019
 */
@RestController
@RequestMapping(value = "naijatravelshop/api/flight")
public class FlightController {

    private FlightService flightService;

    private static final Logger log = LoggerFactory.getLogger(FlightService.class);

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @ApiOperation(value = "Create Flight Reservation")
    @PostMapping(value = {"/create_reservation"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ReservationResponseDTO>> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        log.info("CREATE FLIGHT RESERVATION: {}", reservationRequestDTO.toString());
        ApiResponse<ReservationResponseDTO> apiResponse = new ApiResponse<>();
        ReservationResponseDTO responseDTO = flightService.createReservation(reservationRequestDTO);
        apiResponse.setMessage("Flight reservation creation was successful");
        apiResponse.setData(responseDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Create Visa Request")
    @PostMapping(value = {"/create_visa_request"}, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ReservationResponseDTO>> createVisaRequest(@RequestBody VisaRequestDTO visaRequestDTO) {
        log.info("CREATE VISA REQUEST: {}", visaRequestDTO.toString());
        ApiResponse<ReservationResponseDTO> apiResponse = new ApiResponse<>();
        ReservationResponseDTO responseDTO = flightService.createVisaRequest(visaRequestDTO);
        apiResponse.setMessage("Visa request was created successfully");
        apiResponse.setData(responseDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

