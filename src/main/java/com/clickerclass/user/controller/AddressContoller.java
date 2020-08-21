package com.clickerclass.user.controller;

import com.clickerclass.user.model.AddressModel;
import com.clickerclass.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user/address")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressContoller {
    @Autowired
    private AddressService addressService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
    public ResponseEntity<List<AddressModel>> searchAddressByUser(@RequestParam String userId) {
        return ResponseEntity.ok(this.addressService.searchAddressByUser(userId));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> saveAddress(@RequestBody @Valid AddressModel addressModel) {
        this.addressService.saveAddress(addressModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
