package com.clickerclass.user.persistence.repository;

import com.clickerclass.user.persistence.entity.Authentication;
import com.clickerclass.user.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Integer> {

    Authentication findByUsuarioIdAndActivo(User usuario, Short activo);

    @Query(value = "update authentication a set a.active=0,inactivation_date=current_timestamp() where a.user_id:=userId ", nativeQuery = true)
    void authenticationUpdate(@Param("userId") String userId);

    @Query(value = "select a from authentication a where (a.userId.userName=:userName or a.userId.email=:email)  and a.active=1")
    Authentication searchUserByEmail(@Param("userName") String userName, @Param("email") String email);
}
