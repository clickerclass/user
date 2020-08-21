package com.clickerclass.user.persistence.repository;

import com.clickerclass.user.persistence.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository  extends JpaRepository<DocumentType,Integer> {
}
