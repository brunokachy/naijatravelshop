package com.naijatravelshop.persistence.repository.flight;

import com.naijatravelshop.persistence.model.flight.FlightRoute;
import org.springframework.data.repository.CrudRepository;

public interface FlightRouteRepository extends CrudRepository<FlightRoute, Long> {
}
