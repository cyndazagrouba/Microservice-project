package tn.esprit.spring.pacifico.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

public class LikeBlog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean etat;

   /* @ManyToOne
    User user;*/
    @ManyToOne
    Blog blogg;



}
