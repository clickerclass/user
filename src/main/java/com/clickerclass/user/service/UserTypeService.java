package com.clickerclass.user.service;

import com.clickerclass.user.model.UserTypeModel;
import com.clickerclass.user.persistence.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    public List<UserTypeModel> queryTypeUsers() {
        return userTypeRepository.findAll().stream().map(v -> new UserTypeModel(v)).collect(Collectors.toList());

    }
}
