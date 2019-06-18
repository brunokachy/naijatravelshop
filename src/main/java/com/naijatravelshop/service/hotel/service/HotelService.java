package com.naijatravelshop.service.hotel.service;

import com.naijatravelshop.service.hotel.pojos.request.book.BookRequest;
import com.naijatravelshop.service.hotel.pojos.request.prebook.PreBookRequest;
import com.naijatravelshop.service.hotel.pojos.request.search.SearchDetail;
import com.naijatravelshop.service.hotel.pojos.response.LocationPojo;
import com.naijatravelshop.service.hotel.pojos.response.PropertyResponse;
import com.naijatravelshop.service.hotel.pojos.response.book.BookResponse;
import com.naijatravelshop.service.hotel.pojos.response.prebook.PreBookResponse;
import com.naijatravelshop.service.hotel.pojos.response.propertydetail.Facility;
import com.naijatravelshop.service.hotel.pojos.response.search.PropertyResult;

import java.util.List;

public interface HotelService {

    List<PropertyResult> handleSearchHotelRequest(SearchDetail searchDetail);

    PreBookResponse handlePreBookRequest(PreBookRequest preBookRequest);

    BookResponse handleBookRequest(BookRequest bookRequest);

   // PreCancelResponse handlePreCancelRequest(PreCancelRequest preCancelRequest);

    //CancelResponse handleCancelRequest(CancelRequest cancelRequest);

    //BookingResponse handleSearchBooking(BookHistoryRequest bookHistoryRequest);

    List<LocationPojo> getHotelSearchLocation(String query);

    List<Facility> getHotelFacility(List<Long> facilityIds);

    List<PropertyResponse> getPropertiesDetail(List<Long> propertyIds);

}
