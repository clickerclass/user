package com.clickerclass.user.service.impl;

import com.clickerclass.user.mapper.UserMapper;
import com.clickerclass.user.model.UserModel;
import com.clickerclass.user.repository.UserRepository;
import com.clickerclass.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImp(@Autowired UserRepository userRepository, @Autowired UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Mono<UserModel> findUserByDocumentAndDocumentType(String document, String documentType) {
        return userRepository.findUserByDocumentAndDocumentType(document, documentType).map(userMapper::toModel).doOnNext(userModel -> userModel.setPassword(null));
    }

    @Override
    public Mono<UserModel> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email.toUpperCase()).map(userMapper::toModel).doOnNext(userModel -> userModel.setPassword(null));
    }

    @Override
    public Mono<UserModel> findUserByEmailWithPassword(String email) {
        return userRepository.findUserByEmail(email.toUpperCase()).map(userMapper::toModel);
    }

    @Override
    public Mono<UserModel> save(UserModel userModel) {

        userModel.setCreationDate(new Date());
        return userRepository.save(userMapper.toEntity(userModel)).map(userMapper::toModel);
    }

    @Override
    public Mono<UserModel> findById(String id) {
        return userRepository.findById(id).map(userMapper::toModel);
    }
}
