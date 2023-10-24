package micro.micro_gestion_panier.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "panier_id")
    private List<Item> items;

    private BigDecimal totalAmount;

}
