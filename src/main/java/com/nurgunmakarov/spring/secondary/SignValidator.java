package com.nurgunmakarov.spring.secondary;

import com.nurgunmakarov.spring.dataService.UserDataServiceImpl;
import com.nurgunmakarov.spring.entities.User;
import com.nurgunmakarov.spring.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SignValidator {
    private final User user;
    private final Iterable<User> list;

    public SignValidator(User user, UserCrudRepository userCrudRepository) {
        this.user = user;
        list = userCrudRepository.findAll();
    }

    public boolean isUserExist() {
        for (User user1 : list) {
            if (user.getName().equals(user1.getName()))
                return true;
        }
        return false;
    }


}
