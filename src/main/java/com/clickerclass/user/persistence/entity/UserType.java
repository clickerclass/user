package com.clickerclass.user.persistence.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "user_type")
@Entity
@Data
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public String name;
	@OneToMany(mappedBy = "userTypeId", targetEntity = UserTypeRol.class)
	private List<UserTypeRol> userTypeRols;

	public UserType() {
	}

	public UserType(Integer id) {
		this.id = id;
	}
}
