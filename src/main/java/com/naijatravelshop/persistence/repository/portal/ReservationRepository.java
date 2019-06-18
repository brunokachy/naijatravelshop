package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.portal.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Optional<Reservation> findFirstByBookingNumberEquals(String bookingNumber);
}
