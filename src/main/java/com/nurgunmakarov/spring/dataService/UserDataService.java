package com.nurgunmakarov.spring.dataService;

import com.nurgunmakarov.spring.entities.User;

public interface UserDataService {
    void addUser(User user);

    Iterable<User> getAll();

    void delete(User user);

    User findByUserId(Integer id);

    User findByName(String name);
}
