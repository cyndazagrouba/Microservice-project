package micro.micro_gestion_panier.Repository;

import micro.micro_gestion_panier.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
