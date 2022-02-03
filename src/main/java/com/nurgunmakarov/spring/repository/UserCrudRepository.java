package com.nurgunmakarov.spring.repository;

import com.nurgunmakarov.spring.entities.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    User findById(Integer id);

    User findByMail(String mail);

    User findByName(String name);

    @Query("select id from User where name =:name")
    int getId(@Param("name") String name);
}
