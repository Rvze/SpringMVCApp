package com.nurgunmakarov.spring.entities;

import com.nurgunmakarov.spring.secondary.ActionType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

//@Component
//@Entity
//@Table(name = "users")
//@NoArgsConstructor
////@AllArgsConstructor
//@Data
//@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    @Email(message = "Email should be valid")
    private String mail;
//    private boolean active;


    public User(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
    }



}
