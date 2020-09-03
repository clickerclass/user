package com.clickerclass.user.model;

import com.clickerclass.user.enumaration.DocumentType;
import com.clickerclass.user.enumaration.UserType;
import com.clickerclass.user.util.ExpreReg;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {
    private String id;
    @Pattern(regexp = ExpreReg.REGEX_ONLY_LETTER)
    private String name;
    @Pattern(regexp = ExpreReg.REGEX_ONLY_LETTER)
    private String lastName;
    @Pattern(regexp = ExpreReg.REGEX_DOCUMENT)
    private String document;
    @Pattern(regexp = ExpreReg.REGEX_EMAIL)
    private String email;
    @NotNull
    private DocumentType documentType;
    @NotNull
    private UserType userType;
    @NotNull
    private AddressModel address;
    @Pattern(regexp = ExpreReg.REGEX_PHONE)
    private String phone;
    @Pattern(regexp = ExpreReg.REGEX_PASSWORD)
    private String password;
    @JsonIgnore
    private Date creationDate;
}
