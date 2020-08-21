package com.clickerclass.user.service;

import java.util.Objects;

import com.clickerclass.user.exception.RestServiceException;
import com.clickerclass.user.model.AuthenticationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.clickerclass.user.persistence.entity.Authentication;
import com.clickerclass.user.persistence.repository.AuthenticationRepository;

@Service
public class AuthenticationService {

	@Autowired
	private AuthenticationRepository authenticationService;
	@Value("${userNotFoundMessage}")
	private String userNotFound;
	public AuthenticationModel validarUsuario(String email, String userName) {
		Authentication autenticacion=authenticationService.searchUserByEmail(
				Objects.nonNull(userName) ? userName.toUpperCase() : null,
				Objects.nonNull(email) ? email.toUpperCase() : null);
		if(Objects.isNull(autenticacion)) {
			 throw new RestServiceException(404,userNotFound);
		}
		return new AuthenticationModel(autenticacion);
	}

}
