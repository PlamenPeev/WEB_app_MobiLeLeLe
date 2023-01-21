package com.example.web_app_mobilelele.mobiLeLeLe.repositories;

import com.example.web_app_mobilelele.mobiLeLeLe.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
