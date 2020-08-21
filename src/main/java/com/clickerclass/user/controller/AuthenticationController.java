package com.clickerclass.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clickerclass.user.service.AuthenticationService;
import com.clickerclass.user.model.AuthenticationModel;

@RestController
@RequestMapping("/autenticacion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {
	@Autowired
	private AuthenticationService autenticacionServicio;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<AuthenticationModel> validacionUsuario(@RequestParam(required = false) String nombreUsuario,
                                                                 @RequestParam(required = false) String correo) {
		return ResponseEntity.ok(autenticacionServicio.validarUsuario(correo, nombreUsuario));
	}
}
