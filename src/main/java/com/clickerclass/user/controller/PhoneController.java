package com.clickerclass.user.controller;

import com.clickerclass.user.model.PhoneModel;
import com.clickerclass.user.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user/phone")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PhoneModel>> getInfoPhone(@RequestParam String idCliente) {
        return ResponseEntity.ok(phoneService.searchPhonesByUser(idCliente));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> savePhone(@Valid @RequestBody PhoneModel phoneModel) {
        this.phoneService.savePhone(phoneModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
