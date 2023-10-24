package tn.esprit.spring.pacifico.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeBlogDto {

    private Long id;
    private boolean etat;
    private Long iduser;
    private Long idblog;
}
