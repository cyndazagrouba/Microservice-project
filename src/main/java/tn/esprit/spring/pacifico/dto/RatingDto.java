package tn.esprit.spring.pacifico.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDto {
    private Long id;
    private Date dateRating;
    private int note;
    private String review;
    private Long idBlog;
    private Long idUser;
}
