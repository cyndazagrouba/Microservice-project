package com.example.panier.controller;

import com.example.panier.Entite.Panier;
import com.example.panier.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paniers")
public class PanierController {

    private final PanierService panierService;

    @Autowired
    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @GetMapping
    public List<Panier> getAllPaniers() {
        return panierService.getAllPaniers();
    }

    @GetMapping("/{id}")
    public Panier getPanierById(@PathVariable Long id) {
        return panierService.getPanierById(id)
                .orElseThrow(() -> new RuntimeException("Panier not found with id: " + id));
    }

    @PostMapping
    public Panier createPanier(@RequestBody Panier panier) {
        return panierService.savePanier(panier);
    }

    @PutMapping("/{id}")
    public Panier updatePanier(@PathVariable Long id, @RequestBody Panier panier) {
        // Implement update logic if needed
        return panierService.savePanier(panier);
    }

    @DeleteMapping("/{id}")
    public void deletePanier(@PathVariable Long id) {
        panierService.deletePanier(id);
    }

}
