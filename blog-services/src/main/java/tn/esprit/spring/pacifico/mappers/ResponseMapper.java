package tn.esprit.spring.pacifico.mappers;

import tn.esprit.spring.pacifico.entities.Responses;
import tn.esprit.spring.pacifico.dto.ResponsesDto;

public class ResponseMapper {
    public static ResponsesDto mapToDo(Responses responses)
    {
        ResponsesDto responsesDto = ResponsesDto.builder()

                .contenu(responses.getContenu())

                .dateCreation(responses.getDateCreation())
                .updateTimestamp(responses.getUpdateTimestamp())

                .build();
        return responsesDto ;
    }
    public static Responses maptoEntity (ResponsesDto responsesDto)
    {
        Responses responses = new Responses();
        responses.setContenu(responsesDto.getContenu());


        responses.setDateCreation(responsesDto.getDateCreation());
        responses.setUpdateTimestamp(responsesDto.getUpdateTimestamp());
        return responses;


    }

}
