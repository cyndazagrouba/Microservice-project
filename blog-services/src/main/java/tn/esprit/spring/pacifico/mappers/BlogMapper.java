package tn.esprit.spring.pacifico.mappers;

import tn.esprit.spring.pacifico.entities.Blog;
import tn.esprit.spring.pacifico.dto.BlogDto;

public class BlogMapper {
    public static BlogDto mapToDo(Blog blog)
    {
        return BlogDto.builder()
                .idBlog(blog.getIdBlog())
                .titre(blog.getTitre())
                .image(blog.getImage())
                .description(blog.getDescription())
                .sponsor(blog.getSponsor())
                .build();
    }
    public static Blog maptoEntity (BlogDto blogDto)
    {

        Blog blog = new Blog();
        blog.setTitre(blogDto.getTitre());
        blog.setImage(blogDto.getImage());
        blog.setSponsor(blogDto.getSponsor());
        blog.setDescription(blogDto.getDescription());
        return blog;


    }

}
