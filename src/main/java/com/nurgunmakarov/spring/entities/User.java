package com.nurgunmakarov.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Collection;

@Component
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    @Email(message = "Email should be valid")
    private String mail;
    private boolean active;

    public User(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    public User(Integer id, String name, String password, String mail) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
    }


}
