package com.naijatravelshop.persistence.repository.hotel;

import com.naijatravelshop.persistence.model.hotel.Facility;
import org.springframework.data.repository.CrudRepository;

public interface FacilityRepository extends CrudRepository<Facility, Long> {
   Facility findFirstByFacilityId(Long facilityId);
}
