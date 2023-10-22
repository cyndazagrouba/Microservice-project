package tn.esprit.spring.pacifico.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsesDto {

    private Long idResponses;
    private String contenu;
    private LocalDateTime dateCreation;
    private LocalDateTime updateTimestamp;
    private String auteur;
    private Long commentaireId;
    private Long userId;
}
