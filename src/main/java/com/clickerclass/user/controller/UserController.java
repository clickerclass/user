package com.clickerclass.user.controller;

import com.clickerclass.user.model.UserModel;
import com.clickerclass.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserModel user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserModel> getUser(@RequestParam(required = false) String id,
                                             @RequestParam(required = false) Integer documentTypeId, @RequestParam(required = false) String document) {
        return ResponseEntity.ok(userService.searchUser(id, documentTypeId, document));
    }

}
