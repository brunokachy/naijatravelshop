package com.naijatravelshop.persistence.repository.portal;

import com.naijatravelshop.persistence.model.enums.EntityStatus;
import com.naijatravelshop.persistence.model.portal.PortalUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PortalUserRepository extends CrudRepository<PortalUser, Long> {

    Optional<PortalUser> findFirstByEmailAndStatus(String username, EntityStatus status);

}
