package com.clickerclass.user.model;

import javax.validation.constraints.Pattern;

import com.clickerclass.user.constans.ExpreReg;
import com.clickerclass.user.constans.ExpreRegMensage;
import com.clickerclass.user.persistence.entity.Rol;

import lombok.Data;

@Data
public class RolModel {
	@Pattern(regexp = ExpreReg.REGEX_SOLO_NUMEROS, message = ExpreRegMensage.MENSAJE_SOLO_NUMEROS)
	private Integer id;
	private String name;

	public RolModel(Integer id, String nombre) {
		super();
		this.id = id;
		this.name = nombre;
	}

	public RolModel() {
		super();
	}

	public RolModel(Rol rol) {
		this.id = rol.getId();
		this.name = rol.getName();
	}

}
