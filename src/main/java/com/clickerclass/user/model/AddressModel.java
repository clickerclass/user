package com.clickerclass.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.clickerclass.user.persistence.entity.Address;
import com.clickerclass.user.persistence.entity.User;
import lombok.Data;
import java.sql.Timestamp;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotBlank;
import com.clickerclass.user.constans.ExpreReg;
import com.clickerclass.user.constans.ExpreRegMensage;

@Data
public class AddressModel {
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer id;
	@NotBlank
	private String address;
	@Pattern(regexp = ExpreReg.REGEX_LETRAS_NUMEROS, message = ExpreRegMensage.MENSAJE_LETRAS_NUMEROS)
	private String name;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Short active;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Timestamp creationDate;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Timestamp inactivationDate;
	@Pattern(regexp = ExpreReg.REGEX_SOLO_NUMEROS, message = ExpreRegMensage.MENSAJE_SOLO_NUMEROS)
	private String userId;

	public AddressModel() {
	}

	public AddressModel(Address direccion) {
		this.id = direccion.getId();
		this.address = direccion.getAddress();
		this.active = direccion.getActive();
		this.creationDate = direccion.getCreationDate();
		this.inactivationDate = direccion.getInactivationDate();
		this.name = direccion.getName();
		this.userId = direccion.getUserId().getId();
	}

	public Address toEntity() {
		Address direccion = new Address();
		direccion.setAddress(this.address.toUpperCase());
		direccion.setName(this.name.toUpperCase());
		direccion.setUserId(new User(this.userId));
		return direccion;

	}

}
