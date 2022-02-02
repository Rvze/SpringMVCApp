package com.nurgunmakarov.spring.dataService;

import com.nurgunmakarov.spring.entities.Audit;
import com.nurgunmakarov.spring.repository.AuditCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuditDataServiceImpl implements AuditDataService {

    @Autowired
    private AuditCrudRepository auditCrudRepository;

    @Override
    public void addAudit(Audit audit) {
        auditCrudRepository.save(audit);
    }
}
