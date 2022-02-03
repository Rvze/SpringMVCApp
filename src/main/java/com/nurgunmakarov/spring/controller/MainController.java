package com.nurgunmakarov.spring.controller;

import com.nurgunmakarov.spring.dataService.AccessTokenDataServiceImpl;
import com.nurgunmakarov.spring.dataService.AuditDataServiceImpl;
import com.nurgunmakarov.spring.dataService.UserDataServiceImpl;
import com.nurgunmakarov.spring.entities.AccessToken;
import com.nurgunmakarov.spring.entities.User;
import com.nurgunmakarov.spring.repository.UserCrudRepository;
import com.nurgunmakarov.spring.secondary.SignValidator;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@Getter
@RequestMapping()
public class MainController {
    @Autowired
    private UserCrudRepository userCrudRepository;

    private AccessToken accessToken;

    private final UserDataServiceImpl userDataService;
    private final AuditDataServiceImpl auditDataService;
    private final AccessTokenDataServiceImpl accessTokenDataService;

    private static final Logger logger = LogManager.getLogger(MainController.class);


    @Autowired
    public MainController(UserDataServiceImpl userDataService,
                          AuditDataServiceImpl auditDataService,
                          AccessTokenDataServiceImpl accessTokenDataService) {
        this.userDataService = userDataService;
        this.auditDataService = auditDataService;
        this.accessTokenDataService = accessTokenDataService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") User user,@RequestParam(defaultValue = "") Map<String, Object> model) {
        SignValidator signValidator = new SignValidator(user, userCrudRepository);
        if (userDataService.findByName(user.getName()) != null) {
            logger.warn("User is exist!");
//            model.put("")
            return "/registration";
        }
        userDataService.addUser(user);
        return "/login";
    }
}