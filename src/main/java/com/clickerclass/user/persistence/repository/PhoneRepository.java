package com.clickerclass.user.persistence.repository;

import java.util.List;

import com.clickerclass.user.persistence.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

	public List<Phone> findByUserId(String userId);
}
