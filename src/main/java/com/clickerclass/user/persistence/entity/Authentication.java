package com.clickerclass.user.persistence.entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@Entity
@Table(name="authentication")
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    @Column(name="creation_date")
    private Timestamp creationDate;
    private Short active;
    @JoinColumn(name="user_id")
    @ManyToOne(targetEntity = User.class)
    private User userId;
}
