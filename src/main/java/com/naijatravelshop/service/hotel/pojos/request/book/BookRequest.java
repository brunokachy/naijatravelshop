package com.naijatravelshop.service.hotel.pojos.request.book;

import com.naijatravelshop.service.hotel.pojos.request.JacTravelApiCredential;
import com.naijatravelshop.service.hotel.pojos.response.LocationPojo;
import com.naijatravelshop.service.hotel.pojos.response.prebook.PreBookResponse;
import com.naijatravelshop.service.hotel.pojos.response.search.PropertyResult;
import com.naijatravelshop.service.hotel.pojos.response.search.RoomType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@XmlRootElement(name = "BookRequest")
public class BookRequest implements Serializable {

    private JacTravelApiCredential loginDetails;

    private BookingDetail bookingDetails;

    private PreBookResponse preBookResponse;

    private RoomType roomType;

    @XmlElement(name = "LoginDetails")
    public JacTravelApiCredential getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(JacTravelApiCredential loginDetails) {
        this.loginDetails = loginDetails;
    }

    @XmlElement(name = "BookingDetails")
    public BookingDetail getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetail bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public PreBookResponse getPreBookResponse() {
        return preBookResponse;
    }

    public void setPreBookResponse(PreBookResponse preBookResponse) {
        this.preBookResponse = preBookResponse;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "BookHistoryRequest{" + "loginDetails=" + loginDetails + ", bookingDetails=" + bookingDetails + '}';
    }

}

