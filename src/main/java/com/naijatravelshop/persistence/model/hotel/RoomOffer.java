package com.naijatravelshop.persistence.model.hotel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 07/05/2019
 */
@Entity
@Table(name = "room_offer")
public class RoomOffer implements Serializable {
    @Column(nullable = false)
    private String offerId;
    @Column(nullable = false)
    private Long priceInKobo = 0L;
    private String roomType;
    @Column(nullable = false)
    private String roomDescription;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private HotelBookingDetail hotelBookingDetail;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public Long getPriceInKobo() {
        return priceInKobo;
    }

    public void setPriceInKobo(Long priceInKobo) {
        this.priceInKobo = priceInKobo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HotelBookingDetail getHotelBookingDetail() {
        return hotelBookingDetail;
    }

    public void setHotelBookingDetail(HotelBookingDetail hotelBookingDetail) {
        this.hotelBookingDetail = hotelBookingDetail;
    }
}
