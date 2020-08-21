package com.clickerclass.user.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_type_rol")
@Data
public class UserTypeRol {
	@Id
	private Integer id;
	@ManyToOne(targetEntity = UserType.class)
	@JoinColumn(name = "user_type_id")
	private UserType userTypeId;
	@ManyToOne(targetEntity = Rol.class)
	@JoinColumn(name = "rol_id")
	private Rol rolId;

}
