package com.naijatravelshop.persistence.repository.flight;

import com.naijatravelshop.persistence.model.flight.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long> {
}
