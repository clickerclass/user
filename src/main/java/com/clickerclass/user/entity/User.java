package com.clickerclass.user.entity;

import com.clickerclass.user.enumaration.DocumentType;
import com.clickerclass.user.enumaration.UserType;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("user")
public class User {
    private String id;
    private String document;
    private DocumentType documentType;
    private String name;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private Address address;
    private UserType userType;
    private String password;
    private String phone;
    private Date creationDate;
}
