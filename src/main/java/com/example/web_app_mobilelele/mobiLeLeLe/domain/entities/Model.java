package com.example.web_app_mobilelele.mobiLeLeLe.domain.entities;

import com.example.web_app_mobilelele.mobiLeLeLe.domain.enums.ModelCategory;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private ModelCategory category;

    @Column(name ="image_url")
    private String imageUrl;    // – the url of image with size between 8 and 512 characters.

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column
    private LocalDate created;

    @Column
    private LocalDate modified;

    @ManyToOne
    private Brand brand;

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public void setCategory(ModelCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
