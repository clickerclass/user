package com.clickerclass.user.model;

import com.clickerclass.user.persistence.entity.Authentication;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class AuthenticationModel {
    @NotNull
    @Min(value = 6, message = "password invalid")
    @Max(value = 16, message = "password invalid")
    private String password;
    private UserModel user;

    public AuthenticationModel(Authentication authentication) {
        this.password = authentication.getPassword();
        this.user = new UserModel(authentication.getUserId());
    }

    public AuthenticationModel() {
        super();
    }

}
