package com.naijatravelshop.persistence.repository.hotel;

import com.naijatravelshop.persistence.model.hotel.Property;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PropertyRepository extends CrudRepository<Property, Long> {
    Optional<Property> findFirstByReferenceIdEquals(Long referenceId);
}
