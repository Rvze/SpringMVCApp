package com.nurgunmakarov.spring.dataService;

import com.nurgunmakarov.spring.entities.User;
import com.nurgunmakarov.spring.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public void addUser(User user) {
        userCrudRepository.save(user);
    }

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    public User findByUserId(Integer id) {
        return userCrudRepository.findById(id);
    }

    public User findByName(String name) {
        return userCrudRepository.findByName(name);
    }

    public User findByMail(String mail) {
        return userCrudRepository.findByMail(mail);
    }


}
