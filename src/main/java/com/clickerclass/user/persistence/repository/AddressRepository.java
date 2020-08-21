package com.clickerclass.user.persistence.repository;

import com.clickerclass.user.persistence.entity.User;
import com.clickerclass.user.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    public List<Address> findByUserId(User user);
}
