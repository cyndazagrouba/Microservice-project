package com.example.panier.service;

import com.example.panier.Client.ItemFeignClient;
import com.example.panier.Entite.Panier;
import com.example.panier.Repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanierService {

    private final PanierRepository panierRepository;
    private final ItemFeignClient itemFeignClient;

    @Autowired
    public PanierService(PanierRepository panierRepository, ItemFeignClient itemFeignClient) {
        this.panierRepository = panierRepository;
        this.itemFeignClient = itemFeignClient;
    }

    public List<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    public Optional<Panier> getPanierById(Long id) {
        return panierRepository.findById(id);
    }

    public Panier savePanier(Panier panier) {
        
        return panierRepository.save(panier);
    }

    public void deletePanier(Long id) {
        panierRepository.deleteById(id);
    }
}

