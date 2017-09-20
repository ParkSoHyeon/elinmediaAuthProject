package com.dso.persistence;

import com.dso.domain.Advertiser;
import org.springframework.data.repository.CrudRepository;

public interface AdvertiserRepository extends CrudRepository<Advertiser, Long>{
}
