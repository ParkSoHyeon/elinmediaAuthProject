package com.dso.persistence;

import com.dso.domain.WideSession;
import org.springframework.data.repository.CrudRepository;

public interface WideSessionRepository extends CrudRepository<WideSession, String> {
}
