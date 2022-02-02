package com.nurgunmakarov.spring.controller;

import com.nurgunmakarov.spring.entities.User;
import com.nurgunmakarov.spring.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {


        Iterable<User> users = userCrudRepository.findAll();

        model.put("messages", "hello, letsCode!");

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name,
                      @RequestParam Integer id,
                      @RequestParam String password,
                      @RequestParam String mail,
                      Map<String, Object> model) {
        User user = new User(id, name, password, mail);

        userCrudRepository.save(user);
        Iterable<User> users = userCrudRepository.findAll();
        model.put("users", users);

        return "main";
    }


}