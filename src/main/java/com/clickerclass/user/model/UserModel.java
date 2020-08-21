package com.clickerclass.user.model;

import com.clickerclass.user.constans.ExpreReg;
import com.clickerclass.user.constans.ExpreRegMensage;
import com.clickerclass.user.persistence.entity.DocumentType;
import com.clickerclass.user.persistence.entity.User;
import com.clickerclass.user.persistence.entity.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.*;

@Data
public class UserModel {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private DocumentTypeModel documentType;
    @Pattern(regexp = ExpreReg.REGEX_DOCUMENTO, message = ExpreRegMensage.MENSAJE_DOCUMENTO)
    private String document;
    @Email(message = ExpreRegMensage.MENSAJE_CORREO)
    private String email;
    @Pattern(regexp = ExpreReg.REGEX_NOMBRE_USUARIO, message = ExpreRegMensage.MENSAJE_NOMBRE_USUARIO)
    private String userName;
    @Pattern(regexp = ExpreReg.REGEX_SOLO_LETRAS, message = ExpreRegMensage.MENSAJE_SOLO_LETRAS)
    private String name;
    @Pattern(regexp = ExpreReg.REGEX_SOLO_LETRAS, message = ExpreRegMensage.MENSAJE_SOLO_LETRAS)
    private String lastName;
    private Date birthDate;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = ExpreReg.REGEX_PASSWORD, message = ExpreRegMensage.MENSAJE_PASSWORD)
    private String password;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<RolModel> rols;
    private UserTypeModel userType;

    public UserModel() {
    }

    public UserModel(User user) {
        this.id = user.getId();
        this.documentType = new DocumentTypeModel(user.getDocumentTypeId().getId(),
                user.getDocumentTypeId().getName());
        new DocumentType(user.getDocumentTypeId().getId(),
                this.document = user.getDocument());
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.userType = new UserTypeModel(user.getUserTypeId());
        if (Objects.nonNull(user.getUserTypeId().getUserTypeRols())
                && !user.getUserTypeId().getUserTypeRols().isEmpty()) {
            this.rols = new ArrayList<>(user.getUserTypeId().getUserTypeRols().size());
            user.getUserTypeId().getUserTypeRols().forEach(rol -> {
                this.rols.add(new RolModel(rol.getRolId()));
            });
        }
    }

    public User toEntity() {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        User user = new User();
        user.setId(this.id);
        user.setDocument(this.document);
        user.setEmail(this.email.toUpperCase());
        user.setBirthDate(this.birthDate);
        user.setUserName(this.userName.toUpperCase());
        user.setLastName(this.lastName.toUpperCase());
        user.setName(this.name.toUpperCase());
        user.setDocumentTypeId(new DocumentType(this.getDocumentType().getId()));
        user.setUserTypeId(new UserType(this.getUserType().getId()));
        return user;
    }

}
