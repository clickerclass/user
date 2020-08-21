package com.clickerclass.user.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name="address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private Short active;
    @Column(name="creation_date")
    private Timestamp creationDate;
    @Column(name="inactivation_date")
    private Timestamp inactivationDate;
    @JoinColumn(name="user_id")
    @ManyToOne(targetEntity = User.class)
    private User userId;
}
