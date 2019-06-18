package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.portal.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Optional<Country> findFirstByCode(String code);
}
