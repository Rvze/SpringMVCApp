package com.nurgunmakarov.spring.repository;

import com.nurgunmakarov.spring.entities.AccessToken;
import org.springframework.data.repository.CrudRepository;

public interface AccessTokenCrudRepository extends CrudRepository<AccessToken, Long> {
}
