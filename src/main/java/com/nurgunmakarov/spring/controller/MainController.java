package com.nurgunmakarov.spring.controller;

import com.nurgunmakarov.spring.entities.User;
import com.nurgunmakarov.spring.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.Map;

@RestController
@Controller
public class MainController {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @GetMapping("/registration")
    public String registration() {
        return "/registration";
    }

    @PostMapping("/registration")
    public String registerUser(@RequestParam String name,
                               @RequestParam String password,
                               @RequestParam String mail,
                               Map<String, Object> model) {
        User user = new User(name, password, mail);
        user.setActive(true);
        userCrudRepository.save(user);
        model.put("message", "user is registered!");


        return "/login";
    }
}