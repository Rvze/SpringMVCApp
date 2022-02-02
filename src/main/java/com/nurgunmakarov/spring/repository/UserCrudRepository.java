package com.nurgunmakarov.spring.repository;

import com.nurgunmakarov.spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    User findById(Integer id);

    User findByMail(String mail);

    User findByName(String name);
}
