package com.nurgunmakarov.spring.repository;

import com.nurgunmakarov.spring.entities.Audit;
import org.springframework.data.repository.CrudRepository;

public interface AuditCrudRepository extends CrudRepository<Audit, Long> {
}
