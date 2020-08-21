package com.clickerclass.user.persistence.repository;

import com.clickerclass.user.persistence.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType,Integer> {
}
