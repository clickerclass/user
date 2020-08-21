package com.clickerclass.user.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "phone")
@Data
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String phone;
	private Short active;
	private String name;
	@Column(name = "creation_date")
	private Timestamp creationDate;
	@Column(name = "inactivation_date")
	private Timestamp inactivationDate;
	@JoinColumn(name = "user_id")
	@ManyToOne(targetEntity = User.class)
	private User userId;
}
