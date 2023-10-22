package com.example.panier.Repository;

import com.example.panier.Entite.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Itemrepository extends JpaRepository<Item, Long>{

}

