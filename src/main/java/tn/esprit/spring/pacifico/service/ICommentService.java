package tn.esprit.spring.pacifico.service;

import tn.esprit.spring.pacifico.dto.CommentDto;

public interface ICommentService {
 //   CommentDto createComment(CommentDto commentDto);

    CommentDto getComment(Long idComment);
  //  CommentDto createCommentaireForBlog(Long blogId,Long idUser, CommentDto commentDto);

    CommentDto updateComment(Long idComment, CommentDto commentDto);

    void deleteComment(Long idComment);
}
