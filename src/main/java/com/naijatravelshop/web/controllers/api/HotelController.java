package com.naijatravelshop.web.controllers.api;

import com.naijatravelshop.service.hotel.pojos.request.book.BookRequest;
import com.naijatravelshop.service.hotel.pojos.request.prebook.PreBookRequest;
import com.naijatravelshop.service.hotel.pojos.request.search.SearchDetail;
import com.naijatravelshop.service.hotel.pojos.response.LocationPojo;
import com.naijatravelshop.service.hotel.pojos.response.PropertyResponse;
import com.naijatravelshop.service.hotel.pojos.response.book.BookResponse;
import com.naijatravelshop.service.hotel.pojos.response.prebook.PreBookResponse;
import com.naijatravelshop.service.hotel.pojos.response.search.PropertyResult;
import com.naijatravelshop.service.hotel.service.HotelService;
import com.naijatravelshop.web.pojo.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bruno on
 * 08/05/2019
 */
@RestController
@RequestMapping(value = "naijatravelshop/api/hotel")
public class HotelController {

    private static final Logger log = LoggerFactory.getLogger(HotelController.class);

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @ApiOperation(value = "Retrieves list of cities")
    @GetMapping(value = {"/get-locations"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<LocationPojo>>> processHotelLocationSearch(@PathVariable String term) {
        log.info("CITY SEARCH TERM: {}", term);
        ApiResponse<List<LocationPojo>> apiResponse = new ApiResponse<>();

        List<LocationPojo> hotelCityResponse = hotelService.getHotelSearchLocation(term);
        apiResponse.setMessage("Hotel cities retrieved successfully");
        apiResponse.setData(hotelCityResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Handles hotel search")
    @PostMapping(value = {"/search-hotels"}, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<PropertyResult>>> processHotelSearch(@RequestBody SearchDetail searchDetail) {
        log.info("SEARCH DETAIL: {}", searchDetail.toString());
        ApiResponse<List<PropertyResult>> apiResponse = new ApiResponse<>();

        List<PropertyResult> hotelListResponse = hotelService.handleSearchHotelRequest(searchDetail);
        apiResponse.setMessage("Hotel search was successful");
        apiResponse.setData(hotelListResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Handles get property details")
    @PostMapping(value = {"/get-property-detail"}, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<PropertyResponse>>> getPropertyDetail(@RequestBody List<Long> propertyIds) {
        ApiResponse<List<PropertyResponse>> apiResponse = new ApiResponse<>();

        List<PropertyResponse> propertyResponse = hotelService.getPropertiesDetail(propertyIds);
        apiResponse.setMessage("Property detail retrieved successfully");
        apiResponse.setData(propertyResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Handles get pre-booking to generate booking ID")
    @PostMapping(value = {"/check-offer-availability"}, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<PreBookResponse>> processCheckOfferAvailability(@RequestBody PreBookRequest preBookRequest) {
        log.info("OFFER AVAILABILITY REQUEST: {}", preBookRequest.toString());
        ApiResponse<PreBookResponse> apiResponse = new ApiResponse<>();

        PreBookResponse preBookResponse = hotelService.handlePreBookRequest(preBookRequest);
        apiResponse.setMessage("Booking ID Retrieved successfully");
        apiResponse.setData(preBookResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Handles hotel booking")
    @PostMapping(value = {"/create-booking"}, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<BookResponse>> processCreateBooking(@RequestBody BookRequest bookRequest) {
        log.info("BOOK REQUEST: {}", bookRequest.toString());
        ApiResponse<BookResponse> apiResponse = new ApiResponse<>();

        BookResponse bookResponse = hotelService.handleBookRequest(bookRequest);
        apiResponse.setMessage("Booking request was successful");
        apiResponse.setData(bookResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @ApiOperation(value = "Handles get pre-cancel to generate cancellation ID")
//    @PostMapping(value = {"/pre-cancel-request"}, consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ApiResponse<PreCancelResponse>> handlePreCancelRequest(@RequestBody PreCancelRequest preCancelRequest) {
//        log.info("PRE-CANCEL REQUEST: {}", preCancelRequest.toString());
//        ApiResponse<PreCancelResponse> apiResponse = new ApiResponse<>();
//
//        PreCancelResponse preCancelResponse = hotelService.handlePreCancelRequest(preCancelRequest);
//        apiResponse.setMessage("Cancellation ID Retrieved successfully");
//        apiResponse.setData(preCancelResponse);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

//    @ApiOperation(value = "Handles hotel booking cancellation")
//    @PostMapping(value = {"/cancel-request"}, consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ApiResponse<CancelResponse>> handleCancelRequest(@RequestBody CancelRequest cancelRequest) {
//        log.info("CANCEL REQUEST: {}", cancelRequest.toString());
//        ApiResponse<CancelResponse> apiResponse = new ApiResponse<>();
//
//        CancelResponse cancelResponse = hotelService.handleCancelRequest(cancelRequest);
//        apiResponse.setMessage("Cancellation request was successful");
//        apiResponse.setData(cancelResponse);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

//    @ApiOperation(value = "Handles search hotel booking")
//    @PostMapping(value = {"/search-booking"}, consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ApiResponse<BookingResponse>> handleSearchBooking(@RequestBody BookHistoryRequest bookHistoryRequest) {
//        log.info("SEARCH REQUEST: {}", bookHistoryRequest.toString());
//        ApiResponse<BookingResponse> apiResponse = new ApiResponse<>();
//
//        BookingResponse bookingResponse = hotelService.handleSearchBooking(bookHistoryRequest);
//        apiResponse.setMessage("Booking search request was successful");
//        apiResponse.setData(bookingResponse);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

}
