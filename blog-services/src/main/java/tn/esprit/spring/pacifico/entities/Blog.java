package tn.esprit.spring.pacifico.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Blog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private Long idBlog;

    @NotBlank
    private String titre ;

    @Lob
    @Column(name = "image")
    private String image;

    @NotBlank
    private String sponsor ;
    @NotBlank
    private String description ;
    @CreationTimestamp
    private LocalDateTime createTimestamp;
    @UpdateTimestamp
    private LocalDateTime updateTimestamp;


    @OneToMany( mappedBy = "blog")
    @JsonIgnoreProperties("blog")

    private List<Comment> comments;



  /*  @OneToOne
    private Product product ;*/

    @OneToMany(mappedBy="blogg")
    private List<LikeBlog> addlike;

    @OneToMany( mappedBy="blog")
    private List<Rating> rating;

}
