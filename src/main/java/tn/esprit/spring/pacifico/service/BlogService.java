package tn.esprit.spring.pacifico.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.pacifico.dto.BlogDto;
import tn.esprit.spring.pacifico.entities.Blog;
import tn.esprit.spring.pacifico.mappers.BlogMapper;
import tn.esprit.spring.pacifico.repository.BlogRepository;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class BlogService implements IBlogService {

    private BlogRepository iBlog;
    private ModelMapper modelMapper;
//    private ProductRepository productRepository;

    @Override
    public BlogDto createBlog(@Valid BlogDto blogDto) throws Exception {
        try {
            Blog blog = modelMapper.map(blogDto, Blog.class);
           /* Product product = new Product();
            product.setIdProduct(blogDto.getProductId());
            Product productSaved = productRepository.findById(product.getIdProduct())
                    .orElse(productRepository.save(product));

            blog.setProduct(productSaved);*/

            Blog bloge = iBlog.save(blog);
            return modelMapper.map(bloge, BlogDto.class);
        } catch (Exception e) {
            throw new Exception("Error creating blog: " + e.getMessage());
        }
    }


    /*
     @Override
     public BlogDto add(BlogDto blog) {
         Blog blog1 = iBlog.save(BlogMapper.maptoEntity(blog));
         return BlogMapper.mapToDo(blog1);
     }
     */
    public BlogDto getBlog(Long idBlog) throws BlogNotFoundException {
        try {
            Blog blog = iBlog.findById(idBlog)
                    .orElseThrow(() -> new BlogNotFoundException("Blog not found with id: " + idBlog));
            return modelMapper.map(blog, BlogDto.class);
        } catch (Exception e) {
            throw new BlogNotFoundException("Error getting blog: " + e.getMessage());
        }
    }

    public BlogDto updateBlog(Long id, BlogDto blogDto) throws BlogNotFoundException {
        try {
            Blog blog = iBlog.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
            modelMapper.map(blogDto, blog);
//            Product product = new Product();
//            product.setIdProduct(blogDto.getProductId());
//            blog.setProduct(product);
            blog = iBlog.save(blog);
            return modelMapper.map(blog, BlogDto.class);
        } catch (Exception e) {
            throw new BlogNotFoundException("Error getting blog: " + e.getMessage());
        }
    }

    @Override
    public void deleteBlog(Long idBlog) throws BlogNotFoundException {
        System.out.println("enetr delete" + idBlog);

        Blog blog = iBlog.findById(idBlog)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found with id: " + idBlog));
        System.out.println("fsdfsfs" + blog.getTitre());
        iBlog.deleteBlog(idBlog);
        System.out.println(retrieveAll().size());
    }


    @Override
    public List<BlogDto> retrieveAll() {
        return iBlog.findAll()
                .stream()
                .map(BlogMapper::mapToDo)
                .collect(Collectors.toList());

    }

    public class BlogNotFoundException extends Exception {
        public BlogNotFoundException(Long blogId) {
            super("Blog not found with ID: " + blogId);
        }

        public BlogNotFoundException(String message) {
            super(message);
        }

        public BlogNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public BlogNotFoundException(Throwable cause) {
            super(cause);
        }

    }


    public static String uploadDirectory = System.getProperty("user.dir") + "./images";


    @Override
    public void AjoutConfig(@Valid BlogDto blogDto, MultipartFile image) {
        /// part upload files
        //StringBuilder fileName = new StringBuilder();
        List<String> imagestab = new ArrayList();

        try {
            for (MultipartFile file : new MultipartFile[]{image}) {
                if (file.isEmpty()) {
                    continue; // skip if no file is uploaded
                }
                Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
                Files.write(fileNameAndPath, file.getBytes());
                imagestab.add(file.getOriginalFilename());

            }
            if (!imagestab.isEmpty()) {
                String encodedfile = new String(Base64.encodeBase64(imagestab.get(0).getBytes()), "UTF-8");
                blogDto.setImage(encodedfile);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        // End Upload files
        Blog blog = modelMapper.map(blogDto, Blog.class);
        iBlog.save(blog);
    }






















/*

    //  @Override
    //  public Blog updateBlog(Blog blog) {
    //      return iBlog.save(blog);
    //  }

    @Override
    public void removeBlog(Long idBlog) {
        iBlog.deleteById(idBlog);
    }

    @Override
    public List<Blog> retreiveAllBlogs() {
        List<Blog> es = iBlog.findAll();
        for(Blog blog:es) {
            log.info("Blog :" +blog);
        }
        return es;
    }

    @Override
    public Blog retreiveBlogById(Long idBlog) {
        Optional<Blog> blog = iBlog.findById(idBlog);
        return blog.isPresent() ? blog.get() : null;
    }

    @Override
    public void updateblog(Blog blog, Long idBlog) {
        Optional<Blog> existingBlog = iBlog.findById(idBlog);
        if (existingBlog.isPresent()) {
            Blog updatedBlog = existingBlog.get();
            updatedBlog.setImage(blog.getImage());
            updatedBlog.setSponsor(blog.getSponsor());
            updatedBlog.setDescription(blog.getDescription());
            updatedBlog.setTitre(blog.getTitre());
            iBlog.save(updatedBlog);
        }


    }

    @Override
    public Collection<Blog> findAll() {
        return iBlog.findAll();
    }

    @Override
    public Optional<Blog> findById(long id) {
        return Optional.empty();
    }


    // @Override
    // public void assignBlogToProduct(Integer id, Long idProduct) {
    //     Blog blog=iBlog.findById(id).get();
    //     Product product=iProduct.findById(idProduct).get();
    //     blog.getProduct().add(product);
    //     updateBlog(blog);
//
    // }


 */


}
