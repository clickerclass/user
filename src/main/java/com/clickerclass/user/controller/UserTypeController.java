package com.clickerclass.user.controller;

import com.clickerclass.user.model.UserTypeModel;
import com.clickerclass.user.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usertype")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserTypeModel>> getUser() {
        return ResponseEntity.ok(userTypeService.queryTypeUsers());
    }

}
