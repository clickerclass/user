package com.clickerclass.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.Pattern;

import com.clickerclass.user.constans.ExpreReg;
import com.clickerclass.user.constans.ExpreRegMensage;
@Data
public class DocumentTypeModel {
	@Pattern(regexp = ExpreReg.REGEX_SOLO_NUMEROS, message = ExpreRegMensage.MENSAJE_SOLO_NUMEROS)
	private Integer id;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String name;

	public DocumentTypeModel() {
	}

	public DocumentTypeModel(Integer id) {
		this.id = id;
	}

	public DocumentTypeModel(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
}
