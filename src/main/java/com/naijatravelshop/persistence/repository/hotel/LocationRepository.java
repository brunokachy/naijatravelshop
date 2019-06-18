package com.naijatravelshop.persistence.repository.hotel;

import com.naijatravelshop.persistence.model.hotel.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {

    List<Location> getAllByRegionLike(String region);
}
