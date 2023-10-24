package tn.esprit.spring.pacifico.mappers;

import tn.esprit.spring.pacifico.entities.Comment;
import tn.esprit.spring.pacifico.dto.CommentDto;

public class CommentMapper {
    public static CommentDto mapToDo(Comment comment)
    {
        CommentDto commentDto = CommentDto.builder()

                .contenu(comment.getContenu())


                .dateCreation(comment.getDateCreation())
                .updateTimestamp(comment.getUpdateTimestamp())

                .build();
        return commentDto ;
    }
    public static Comment maptoEntity (CommentDto commentDto)
    {

        Comment comment = new Comment();

        comment.setContenu(commentDto.getContenu());


        comment.setDateCreation(commentDto.getDateCreation());
        comment.setUpdateTimestamp(commentDto.getUpdateTimestamp());

        return comment;


    }



}
