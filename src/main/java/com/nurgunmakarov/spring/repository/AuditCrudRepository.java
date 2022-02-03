package com.nurgunmakarov.spring.repository;

import com.nurgunmakarov.spring.entities.Audit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuditCrudRepository extends CrudRepository<Audit, Long> {

}
