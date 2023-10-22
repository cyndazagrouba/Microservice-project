package tn.esprit.spring.pacifico.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.spring.pacifico.entities.Comment;
import tn.esprit.spring.pacifico.entities.Responses;
import tn.esprit.spring.pacifico.repository.CommentRepository;
import tn.esprit.spring.pacifico.repository.ResponsesRepository;
import tn.esprit.spring.pacifico.dto.ResponsesDto;

@Service
@Slf4j
@AllArgsConstructor
public class ResponseService implements IResponseService{

    ResponsesRepository responseRepository ;
    CommentRepository commentRepository ;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponsesDto createResponseForComment(Long commentaireId, ResponsesDto responsesDto) {
        Responses responses = modelMapper.map(responsesDto, Responses.class);
        Comment comment = commentRepository.findById(commentaireId).orElseThrow(() -> new NotFoundException("Comment not found"));
      //  User user = new User();
       // user.setIdUser(responsesDto.getUserId());
      //  responses.setUsers(user);
        responses.setCommentaires(comment);
        responses = responseRepository.save(responses);
        return modelMapper.map(responses, ResponsesDto.class);
    }
    @Override
    public void deleteResponses(Long idResponses) {
        responseRepository.deleteById(idResponses);
    }
}
