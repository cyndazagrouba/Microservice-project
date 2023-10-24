package tn.esprit.spring.pacifico.controller;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.spring.pacifico.entities.Blog;
import tn.esprit.spring.pacifico.repository.BlogRepository;
import tn.esprit.spring.pacifico.service.BlogService;
import tn.esprit.spring.pacifico.service.IBlogService;
import tn.esprit.spring.pacifico.dto.BlogDto;
import tn.esprit.spring.pacifico.utils.ImageUtil;

import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.List;




@RestController
@AllArgsConstructor
@RequestMapping("/blog")
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
@Slf4j
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addProductWithImage(
            @RequestParam("titre") String titre,
            @RequestParam("description") String description,
            @RequestParam("sponsor") int sponsor,
            @RequestParam("image") MultipartFile image) {

        String originalFilename = image.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();

        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png", "gif");

        if (!allowedExtensions.contains(fileExtension)) {
            return new ResponseEntity<>("Le fichier n'est pas une image valide.", HttpStatus.BAD_REQUEST);
        }

        // Vous pouvez stocker uniquement le nom du fichier dans le modèle de produit
        String imageFileName = originalFilename;

        // Enregistrez le reste des informations du blog dans votre base de données
        Blog blogDto = new Blog();

        blogDto.setDescription(description);
        blogDto.setTitre(titre);
        blogDto.setSponsor(String.valueOf(sponsor));

        blogDto.setImage(imageFileName);

        blogRepository.save(blogDto);

        return new ResponseEntity<>("Le blog a été ajouté avec succès.", HttpStatus.OK);
    }

    @PostMapping("/ad-blog")
    public BlogDto createBlog(@RequestParam("image") MultipartFile image, @RequestBody @Valid BlogDto blogDto) throws Exception {
        // Traitez l'image et le blogDto comme requis.
        // Par exemple, sauvegardez l'image sur le disque.
        String imageName = image.getOriginalFilename();
        // Votre logique pour gérer l'image ici.

        // Enregistrez les détails du blog dans votre service.
        blogDto.setImage(imageName); // Vous pouvez stocker le nom du fichier ou d'autres informations pertinentes.
        return iBlogService.createBlog(blogDto);
    }
    @PostMapping("/add-blog")
    public ResponseEntity<BlogDto> addBlog(@RequestParam("blog") String blogjson, @RequestParam("image") MultipartFile image) throws Exception {

        BlogDto blog = new Gson().fromJson(blogjson, BlogDto.class);
        String imageName = image.getOriginalFilename();
        // Rename and copy the image to a certain path
        log.info("imageName {}",imageName);
        Path dir = Paths.get("images");
        log.debug("Directorie {}",dir.getRoot());
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }

        Path filepath = Paths.get(dir.toString(), image.getOriginalFilename());
        image.transferTo(filepath);
        log.info("file saved");
        String encodedfile = new String(Base64.encodeBase64(image.getBytes()), "UTF-8");
        blog.setImage(encodedfile);
        iBlogService.createBlog(blog);
        log.info("Blog saved");
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{idBlog}")
    public BlogDto getBlog(@PathVariable Long idBlog) throws Exception {
        return iBlogService.getBlog(idBlog);
    }

    @GetMapping("/all-blogs")
    public List<BlogDto> getBlogs() {

        log.info("[GET] all-blogs");
        return iBlogService.retrieveAll();
    }

    @PutMapping("/edit-blog/{idBlog}")
    public BlogDto updateBlog(@PathVariable Long idBlog, @RequestBody @Valid BlogDto blogDto) throws BlogService.BlogNotFoundException {
        try {
            return iBlogService.updateBlog(idBlog, blogDto);
        } catch (BlogService.BlogNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update blog", e);
        }
    }

    @DeleteMapping("/delete-blog/{idBlog}")
    public ResponseEntity<Void> deleteBlog(@PathVariable("idBlog") Long idBlog) {
        try {
            iBlogService.deleteBlog(idBlog);
            return ResponseEntity.noContent().build();
        } catch (BlogService.BlogNotFoundException e) {
            System.out.println("enter BlogNotFoundException execption ");

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("enter execption ");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete blog", e);
        }
    }

}
