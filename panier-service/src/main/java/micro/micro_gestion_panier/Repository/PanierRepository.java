package micro.micro_gestion_panier.Repository;

import micro.micro_gestion_panier.Entity.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier, Long> {

}
