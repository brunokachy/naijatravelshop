package com.naijatravelshop.service.portal.pojo.request;

import java.util.Date;

/**
 * Created by Bruno on
 * 21/06/2019
 */
public class BookingSearchDTO {

    private String startDate;

    private String endDate;

    private String bookingStatus;

    private String bookingNo;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }
}
