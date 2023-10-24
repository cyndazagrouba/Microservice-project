package tn.esprit.spring.pacifico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Temporal(TemporalType.DATE)
    @Column(name="dateRating")
    private Date DateRating;
    @Size(min = 0, max = 5)
    private int note ;
    private String review ;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idB", referencedColumnName="idBlog" , insertable =true , updatable=false)
    Blog blog;
   /*@JsonIgnore
    @ManyToOne
    @JoinColumn(name="idU", referencedColumnName="idUser" , insertable =true , updatable=false)
    User user ;*/

}
