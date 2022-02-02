package com.nurgunmakarov.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "access_token")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class AccessToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tokenId;
    private Integer auditId;
    private Integer userId;
    private Date dateTime;

    public AccessToken buildAccessToken(Audit audit, Long time) {
        Date date = new Date(audit.getDateTime().getTime() + time);
        return AccessToken.builder()
                .auditId(audit.getAuditId())
                .userId(audit.getUserId())
                .dateTime(date)
                .build();
    }
}
