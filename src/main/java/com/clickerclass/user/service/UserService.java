package com.clickerclass.user.service;

import com.clickerclass.user.model.UserModel;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserModel> findUserByDocumentAndDocumentType(String document, String documentType);

    Mono<UserModel> findUserByEmail(String email);

    Mono<UserModel> findUserByEmailWithPassword(String email);

    Mono<UserModel> save(UserModel userModel);

    Mono<UserModel> findById(String id);


}
