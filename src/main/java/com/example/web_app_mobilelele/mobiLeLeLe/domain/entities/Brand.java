package com.example.web_app_mobilelele.mobiLeLeLe.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private LocalDate created;

    @Column
    private LocalDate modified;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private Set<Model> models;

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Brand setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public LocalDate getModified() {
        return modified;
    }

    public Brand setModified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    public Set<Model> getModels() {
        return models;
    }

    public Brand setModels(Set<Model> models) {
        this.models = models;
        return this;
    }
}

