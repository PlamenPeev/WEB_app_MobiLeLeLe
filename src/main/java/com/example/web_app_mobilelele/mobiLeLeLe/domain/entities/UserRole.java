package com.example.web_app_mobilelele.mobiLeLeLe.domain.entities;

import com.example.web_app_mobilelele.mobiLeLeLe.domain.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserRole() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
