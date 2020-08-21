package com.clickerclass.user.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document_type")
@Data
public class DocumentType {
    @Id
    private Integer id;
    private String name;

    public DocumentType() {
    }

    public DocumentType(Integer id) {
        this.id = id;
    }

    public DocumentType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
