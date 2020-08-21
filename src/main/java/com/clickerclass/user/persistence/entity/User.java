package com.clickerclass.user.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	private String id;
	@ManyToOne(targetEntity = DocumentType.class)
	@JoinColumn(name = "document_type_id")
	private DocumentType documentTypeId;
	private String document;
	private String email;
	private String userName;
	private String name;
	private String lastName;
	private Date birthDate;
	@ManyToOne(targetEntity = UserType.class)
	@JoinColumn(name = "user_type_id")
	private UserType userTypeId;
	public User(String id) {
		this.id = id;
	}
	public User() {
	}
}
