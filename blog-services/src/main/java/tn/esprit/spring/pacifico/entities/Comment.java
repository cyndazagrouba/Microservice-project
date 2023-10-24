package tn.esprit.spring.pacifico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;
    private String contenu;
    @CreationTimestamp
    private LocalDateTime  dateCreation;
    @UpdateTimestamp
    private LocalDateTime updateTimestamp;



    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("comments")
    Blog blog;

    @JsonIgnore
    @OneToMany(mappedBy = "commentaires", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responses> responses = new ArrayList<>();
  /*  @JsonIgnore
    @ManyToOne
    User users;*/



}
