package com.example.panier.Repository;

import com.example.panier.Entite.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier, Long> {
}

