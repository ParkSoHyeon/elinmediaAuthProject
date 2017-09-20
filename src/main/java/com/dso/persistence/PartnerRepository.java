package com.dso.persistence;

import com.dso.domain.Partner;
import org.springframework.data.repository.CrudRepository;

public interface PartnerRepository extends CrudRepository<Partner, Long> {
}
