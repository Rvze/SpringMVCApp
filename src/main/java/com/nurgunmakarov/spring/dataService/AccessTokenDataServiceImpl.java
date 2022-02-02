package com.nurgunmakarov.spring.dataService;

import com.nurgunmakarov.spring.entities.AccessToken;
import com.nurgunmakarov.spring.repository.AccessTokenCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccessTokenDataServiceImpl implements AccessTokenDataService {

    @Autowired
    private AccessTokenCrudRepository accessTokenCrudRepository;

    @Override
    public void addAccessToken(AccessToken accessToken) {
        accessTokenCrudRepository.save(accessToken);
    }
}
