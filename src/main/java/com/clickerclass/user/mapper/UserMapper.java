package com.clickerclass.user.mapper;

import com.clickerclass.user.entity.User;
import com.clickerclass.user.model.UserModel;
import org.bouncycastle.util.Strings;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract UserModel toModel(User user);

    @Mapping(source = "name", target = "name", qualifiedByName = "toUpperCase")
    @Mapping(source = "lastName", target = "lastName", qualifiedByName = "toUpperCase")
    @Mapping(source = "email", target = "email", qualifiedByName = "toUpperCase")
    @Mapping(source = "address.country", target = "address.country", qualifiedByName = "toUpperCase")
    @Mapping(source = "address.state", target = "address.state", qualifiedByName = "toUpperCase")
    @Mapping(source = "address.city", target = "address.city", qualifiedByName = "toUpperCase")
    @Mapping(source = "address.description", target = "address.description", qualifiedByName = "toUpperCase")
    @Mapping(source = "password", target = "password", qualifiedByName = "Encrypting")
    @Mapping(source = "creationDate", target = "creationDate")
    public abstract User toEntity(UserModel userModel);

    @Named("toUpperCase")
    String toUpperCase(String string) {
        return string.toUpperCase();
    }

    @Named("Encrypting")
    String encrypting(String value) {
        String valueEncrypt = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
            valueEncrypt = Strings.fromByteArray(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return valueEncrypt;
    }
}
