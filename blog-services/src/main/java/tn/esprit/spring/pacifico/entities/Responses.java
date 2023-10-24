package tn.esprit.spring.pacifico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "responses")
public class Responses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idResponses;
    private String contenu;
    @CreationTimestamp
    private LocalDateTime dateCreation;
    @UpdateTimestamp
    private LocalDateTime updateTimestamp;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentaires_id")
    private Comment commentaires;
   /* @JsonIgnore
    @ManyToOne
    User users;*/


}
