package micro.micro_gestion_panier.Service;

import micro.micro_gestion_panier.Entity.Panier;
import micro.micro_gestion_panier.Repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanierService {

    private final PanierRepository panierRepository;

    @Autowired
    public PanierService(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
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
