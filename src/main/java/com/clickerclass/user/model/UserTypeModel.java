package com.clickerclass.user.model;

import javax.validation.constraints.Pattern;

import com.clickerclass.user.constans.ExpreReg;
import com.clickerclass.user.constans.ExpreRegMensage;
import com.clickerclass.user.persistence.entity.UserType;

import lombok.Data;

@Data
public class UserTypeModel {
	@Pattern(regexp = ExpreReg.REGEX_SOLO_NUMEROS, message = ExpreRegMensage.MENSAJE_SOLO_NUMEROS)
	private Integer id;
	private String name;

	public UserTypeModel() {
	}

	public UserTypeModel(UserType userType) {
		this.id = userType.getId();
		this.name = userType.getName();
	}
}
