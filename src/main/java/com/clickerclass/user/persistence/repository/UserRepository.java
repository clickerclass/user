package com.clickerclass.user.persistence.repository;

import com.clickerclass.user.persistence.entity.User;
import com.clickerclass.user.persistence.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByDocumentAndDocumentTypeId(String document, DocumentType documentTypeId);

	public User findByUserNameOrEmail(String userName, String email);
}
