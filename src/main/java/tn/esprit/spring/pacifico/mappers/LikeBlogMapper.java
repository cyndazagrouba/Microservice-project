package tn.esprit.spring.pacifico.mappers;

import tn.esprit.spring.pacifico.entities.LikeBlog;
import tn.esprit.spring.pacifico.dto.LikeBlogDto;

public class LikeBlogMapper {
    public static LikeBlogDto mapToDo(LikeBlog likeBlog)
    {
        LikeBlogDto likeBlogDto = LikeBlogDto.builder()

                .etat(likeBlog.isEtat())
                .build();
        return likeBlogDto;
    }
    public static LikeBlog maptoEntity (LikeBlogDto likeBlogDto)
    {

        LikeBlog likeBlog = new LikeBlog();
        likeBlog.setEtat(likeBlog.isEtat());
        return likeBlog;


    }
}
