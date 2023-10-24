package micro.micro_gestion_panier.RestController;

import micro.micro_gestion_panier.Entity.Panier;
import micro.micro_gestion_panier.Service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        public ResponseEntity<Panier> getPanierById(@PathVariable Long id) {
                Optional<Panier> panier = panierService.getPanierById(id);
                return panier.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Panier> savePanier(@RequestBody Panier panier) {
                Panier savedPanier = panierService.savePanier(panier);
                return ResponseEntity.status(HttpStatus.CREATED).body(savedPanier);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePanier(@PathVariable Long id) {
                panierService.deletePanier(id);
                return ResponseEntity.noContent().build();
        }
}
