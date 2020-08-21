package com.clickerclass.user.service;

import com.clickerclass.user.model.PhoneModel;
import com.clickerclass.user.persistence.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    public List<PhoneModel> searchPhonesByUser(String userId) {
        return phoneRepository.findByUserId(userId).stream().map(t -> new PhoneModel(t))
                .collect(Collectors.toList());
    }

    public void savePhone(PhoneModel phoneModel) {
        phoneRepository.saveAndFlush(phoneModel.toEntity());
    }
}
