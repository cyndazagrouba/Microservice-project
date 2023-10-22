package tn.esprit.spring.pacifico.service;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.pacifico.dto.BlogDto;

import javax.validation.Valid;
import java.util.List;

public interface IBlogService {


    // Blog updateBlog(Blog blog);

 //   BlogDto add(BlogDto blog);

   /*
    void removeBlog(Long idBlog);

    List<Blog> retreiveAllBlogs();

    Blog retreiveBlogById(Long idBlog);

    void updateblog(Blog blog, Long idBlog);

    Collection<Blog> findAll();

    Optional<Blog> findById(long id);

    */
    BlogDto getBlog(Long idBlog) throws BlogService.BlogNotFoundException;

    BlogDto updateBlog(Long idBlog, BlogDto blogDto) throws BlogService.BlogNotFoundException;

    void deleteBlog(Long idBlog) throws BlogService.BlogNotFoundException;

    BlogDto createBlog(@Valid BlogDto blogDto) throws Exception;
    List<BlogDto> retrieveAll();

    void AjoutConfig(BlogDto blogDto, MultipartFile image);
}
