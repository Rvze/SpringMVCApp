package com.nurgunmakarov.spring.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "audit")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Audit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer auditId;
    private Integer userId;
    private int actionType;
    private Date dateTime;

    public Audit getAction(User user, int actionType) {
        return Audit.builder()
                .userId(user.getId())
                .actionType(actionType)
                .dateTime(new Date(System.currentTimeMillis()))
                .build();
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = new Date(System.currentTimeMillis());
    }

}
