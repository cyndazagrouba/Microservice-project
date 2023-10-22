package tn.esprit.spring.pacifico.service;

import tn.esprit.spring.pacifico.dto.ResponsesDto;

public interface IResponseService {
    ResponsesDto createResponseForComment(Long commentaireId, ResponsesDto responsesDto);

    void deleteResponses(Long idResponses);
}
