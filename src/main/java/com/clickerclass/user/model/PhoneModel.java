package com.clickerclass.user.model;

import com.clickerclass.user.constans.ExpreReg;
import com.clickerclass.user.constans.ExpreRegMensage;
import com.clickerclass.user.persistence.entity.Phone;
import com.clickerclass.user.persistence.entity.User;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
public class PhoneModel {
    @Pattern(regexp = ExpreReg.REGEX_SOLO_NUMEROS, message = ExpreRegMensage.MENSAJE_SOLO_NUMEROS)
    private Integer id;
    @Pattern(regexp = ExpreReg.REGEX_TELEFONO, message = ExpreRegMensage.MENSAJE_TELEFONO)
    private String phone;
    private Short active;
    @Pattern(regexp = ExpreReg.REGEX_LETRAS_NUMEROS, message = ExpreRegMensage.MENSAJE_LETRAS_NUMEROS)
    private String name;
    private Timestamp creationDate;
    private Timestamp inactivationDate;
    @Pattern(regexp = ExpreReg.REGEX_SOLO_NUMEROS, message = ExpreRegMensage.MENSAJE_SOLO_NUMEROS)
    private String userId;

    public PhoneModel() {
    }

    public PhoneModel(Phone telefono) {
        this.id = telefono.getId();
        this.phone = telefono.getPhone();
        this.active = telefono.getActive();
        this.name = telefono.getName();
        this.creationDate = telefono.getCreationDate();
        this.inactivationDate = telefono.getInactivationDate();
        this.userId = telefono.getUserId().getId();
    }

    public Phone toEntity() {
        Phone telefono = new Phone();
        telefono.setPhone(this.phone);
        telefono.setName(this.name.toUpperCase());
        telefono.setUserId(new User(this.userId));
        return telefono;
    }
}
