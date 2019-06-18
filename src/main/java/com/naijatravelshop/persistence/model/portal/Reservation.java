package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.enums.ProcessStatus;
import com.naijatravelshop.persistence.model.enums.ReservationType;
import com.naijatravelshop.persistence.model.enums.SupplierGroupType;
import com.naijatravelshop.persistence.model.flight.FlightBookingDetail;
import com.naijatravelshop.persistence.model.generic.AuditModel;
import com.naijatravelshop.persistence.model.hotel.HotelBookingDetail;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Bruno on
 * 07/05/2019
 */
@Entity
@Table(name = "reservation")
public class Reservation extends AuditModel implements Serializable {
    @Column(nullable = false)
    private String bookingNumber;
    private Timestamp datePaid;
    private Long amountPaidInKobo;
    private Long supplierPrice;
    private Long margin;
    private Long sellingPrice;
    private ReservationType reservationType;
    @Column(nullable = false)
    private ProcessStatus reservationStatus;
    private Long transactionFeeInKobo;
    private Long actualAmountInKobo;
    private String ticketNumber;
    private Timestamp dateProcessed;
    private Boolean processing = false;
    private SupplierGroupType supplierGroupType;
    @ManyToOne
    private ReservationOwner reservationOwner;
    @ManyToOne
    private PortalUser processedBy;
    @OneToOne
    private HotelBookingDetail hotelBookingDetail;
    @OneToOne
    private FlightBookingDetail flightBookingDetail;

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Timestamp getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Timestamp datePaid) {
        this.datePaid = datePaid;
    }

    public Long getAmountPaidInKobo() {
        return amountPaidInKobo;
    }

    public void setAmountPaidInKobo(Long amountPaidInKobo) {
        this.amountPaidInKobo = amountPaidInKobo;
    }

    public Long getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(Long supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public Long getMargin() {
        return margin;
    }

    public void setMargin(Long margin) {
        this.margin = margin;
    }

    public Long getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Long sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public ProcessStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ProcessStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Long getTransactionFeeInKobo() {
        return transactionFeeInKobo;
    }

    public void setTransactionFeeInKobo(Long transactionFeeInKobo) {
        this.transactionFeeInKobo = transactionFeeInKobo;
    }

    public Long getActualAmountInKobo() {
        return actualAmountInKobo;
    }

    public void setActualAmountInKobo(Long actualAmountInKobo) {
        this.actualAmountInKobo = actualAmountInKobo;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Timestamp getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(Timestamp dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public Boolean getProcessing() {
        return processing;
    }

    public void setProcessing(Boolean processing) {
        this.processing = processing;
    }

    public SupplierGroupType getSupplierGroupType() {
        return supplierGroupType;
    }

    public void setSupplierGroupType(SupplierGroupType supplierGroupType) {
        this.supplierGroupType = supplierGroupType;
    }

    public ReservationOwner getReservationOwner() {
        return reservationOwner;
    }

    public void setReservationOwner(ReservationOwner reservationOwner) {
        this.reservationOwner = reservationOwner;
    }

    public PortalUser getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(PortalUser processedBy) {
        this.processedBy = processedBy;
    }

    public HotelBookingDetail getHotelBookingDetail() {
        return hotelBookingDetail;
    }

    public void setHotelBookingDetail(HotelBookingDetail hotelBookingDetail) {
        this.hotelBookingDetail = hotelBookingDetail;
    }

    public FlightBookingDetail getFlightBookingDetail() {
        return flightBookingDetail;
    }

    public void setFlightBookingDetail(FlightBookingDetail flightBookingDetail) {
        this.flightBookingDetail = flightBookingDetail;
    }
}
