package com.esprit.microservices.produittest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id ;
    private String productName ;
    private String description;
    private int price;
    private int reference ;
    private int quantity;
   private String image;  // Champ pour stocker l'emplacement de l'image

    // Getters et setters pour imageLocation
    public String getImageLocation() {return image;
    }
    public void setImageLocation(String image) {
        this.image = image;
    }

}
