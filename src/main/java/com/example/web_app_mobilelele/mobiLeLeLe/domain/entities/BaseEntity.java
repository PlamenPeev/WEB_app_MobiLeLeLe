package com.example.web_app_mobilelele.mobiLeLeLe.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseEntity {

//@Id
//@GeneratedValue(generator = "uuid-string")
//@GenericGenerator(name = "uuid-string",
//strategy = "org.hibernate.id.UUIDGenerator")
//    private String id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }
}

