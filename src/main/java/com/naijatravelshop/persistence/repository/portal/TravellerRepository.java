package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.portal.Traveller;
import org.springframework.data.repository.CrudRepository;

public interface TravellerRepository extends CrudRepository<Traveller, Long> {
}
