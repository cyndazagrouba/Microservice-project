package com.example.reclamationservice.Repositories;

import com.example.reclamationservice.Entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepo extends JpaRepository<Reclamation,Integer> {
}
