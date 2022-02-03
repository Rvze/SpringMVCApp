package com.nurgunmakarov.spring.controller;

import com.nurgunmakarov.spring.dataService.AccessTokenDataServiceImpl;
import com.nurgunmakarov.spring.dataService.AuditDataServiceImpl;
import com.nurgunmakarov.spring.dataService.UserDataServiceImpl;
import com.nurgunmakarov.spring.entities.AccessToken;
import com.nurgunmakarov.spring.entities.Audit;
import com.nurgunmakarov.spring.entities.User;
import com.nurgunmakarov.spring.repository.AccessTokenCrudRepository;
import com.nurgunmakarov.spring.repository.AuditCrudRepository;
import com.nurgunmakarov.spring.repository.UserCrudRepository;
import com.nurgunmakarov.spring.secondary.ActionType;
import com.nurgunmakarov.spring.secondary.SignValidator;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping()
@AllArgsConstructor
public class GreetingController {

    private static final Logger logger = LogManager.getLogger(MainController.class);


    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserDataServiceImpl userDataService;

    @Autowired
    private AuditCrudRepository auditDataService;

    @Autowired
    private AccessTokenCrudRepository accessTokenDataService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/profile")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "stranger") String name,
                       Model model) {

        model.addAttribute("name", name);
        Iterable<User> users = userCrudRepository.findAll();


        return "profile";
    }

    @PostMapping("/profile")
    public String add(@RequestParam(name = "name", required = false, defaultValue = "stranger") String name,
                      @RequestParam Integer id,
                      @RequestParam String password,
                      @RequestParam String mail,
                      Map<String, Object> model,
                      Model model2) {
        model2.addAttribute("name", name);
        User user = new User(id, name, password, mail);
        Audit audit = new Audit();
        audit.setDateTime(new Date());
        AccessToken accessToken = new AccessToken();


        if (userCrudRepository.findByName(user.getName()) != null) {
            logger.warn("User is exist!");
            audit.setActionType(ActionType.LOGIN_FAIL.getDescription());
            model.put("message", "User is exist!");
            return "/profile";
        }
        userCrudRepository.save(user);
        audit.setUserId(userCrudRepository.getId(user.getName()));
        audit.setActionType(ActionType.REGISTRATION.getDescription());
        audit.getAction(user, 1000);


        SignValidator signValidator = new SignValidator(user, userCrudRepository);
        if (signValidator.isUserExist()) {
            audit.setActionType(3);
        }
        auditDataService.save(audit);


        if (audit.getActionType() == 3) {
            accessToken.setUserId(audit.getUserId());
            accessToken.setAuditId(audit.getAuditId());
            Date date = new Date(audit.getDateTime().getTime() + 100000000);
            accessToken.setDateTime(date);
            accessTokenDataService.save(accessToken);
        }


        logger.info("user is registered successfully!");
        Iterable<User> users = userCrudRepository.findAll();
        Iterable<Audit> audits = auditDataService.findAll();
        Iterable<AccessToken> accessTokens = accessTokenDataService.findAll();
        model.put("users", users);
        model.put("audits", audits);
        model.put("accessTokens", accessTokens);
        return "/profile";
    }

    @RequestMapping("/")
    public String handleRequest(Model model) {
        Iterable<Audit> audits = auditDataService.findAll();
        model.addAttribute("audits", audits);
        Iterable<AccessToken> accessTokens = accessTokenDataService.findAll();
        model.addAttribute("accessTokens", accessTokens);
        return "profile";
    }


}