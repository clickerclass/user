package com.clickerclass.user.service;

import com.clickerclass.user.model.UserModel;
import com.clickerclass.user.persistence.entity.Authentication;
import com.clickerclass.user.persistence.entity.DocumentType;
import com.clickerclass.user.persistence.entity.User;
import com.clickerclass.user.persistence.repository.AuthenticationRepository;
import com.clickerclass.user.persistence.repository.UserRepository;
import com.commons.gema.kafka.aspect.annotation.GenerateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationRepository authenticationRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @GenerateEvent
    public void saveUser(UserModel userModel) {
        User user = userModel.toEntity();
        Authentication authentication = new Authentication();
        authentication.setActive((short) 1);
        authentication.setPassword(passwordEncode.encode(userModel.getPassword()));
        authentication.setUserId(user);
        authentication.setCreationDate(new Timestamp(System.currentTimeMillis()));
        userRepository.saveAndFlush(user);
        authenticationRepository.saveAndFlush(authentication);
    }

    public UserModel searchUser(String id, Integer documentType, String document) {
        UserModel userModel = null;

        if (Objects.nonNull(id)) {
            userModel = new UserModel(this.userRepository.findById(id).get());

        } else if (Objects.nonNull(documentType) && Objects.nonNull(document)) {
            userModel = new UserModel(
                    userRepository.findByDocumentAndDocumentTypeId(document, new DocumentType(documentType)));
        }

        return userModel;
    }
}
