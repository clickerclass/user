package com.clickerclass.user.service;

import com.clickerclass.user.constans.ExpreReg;
import com.clickerclass.user.constans.ExpreRegMensage;
import com.clickerclass.user.model.AddressModel;
import com.clickerclass.user.persistence.entity.User;
import com.clickerclass.user.persistence.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<AddressModel> searchAddressByUser(
            @Pattern(regexp = ExpreReg.REGEX_SOLO_NUMEROS, message = ExpreRegMensage.MENSAJE_SOLO_NUMEROS) String idCliente) {
        return addressRepository.findByUserId(new User(idCliente)).stream().map(d -> new AddressModel(d))
                .collect(Collectors.toList());
    }

    public void saveAddress(AddressModel direccionModelo) {
        addressRepository.saveAndFlush(direccionModelo.toEntity());
    }
}
