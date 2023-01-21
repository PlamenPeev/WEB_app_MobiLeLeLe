package com.example.web_app_mobilelele.mobiLeLeLe.repositories;

import com.example.web_app_mobilelele.mobiLeLeLe.domain.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {
}
