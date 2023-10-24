package tn.esprit.spring.pacifico.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogDto  {

    private Long idBlog;
    private String titre;
    private String image;
    private String sponsor;
    private String description;



}
