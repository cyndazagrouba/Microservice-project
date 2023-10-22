package tn.esprit.spring.pacifico.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.pacifico.entities.Comment;
import tn.esprit.spring.pacifico.repository.CommentRepository;
import tn.esprit.spring.pacifico.service.IBlogService;
import tn.esprit.spring.pacifico.service.ICommentService;
import tn.esprit.spring.pacifico.dto.CommentDto;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    ICommentService iCommentService ;
    static IBlogService iBlogService ;
    CommentRepository commentRepository;

    /*@PostMapping("/blog/{blogId}/{idUser}/commentaires")
    public CommentDto createCommentaire(@PathVariable(value = "blogId") Long blogId,@PathVariable(value = "idUser") Long idUser, @RequestBody CommentDto commentDto) {
        return iCommentService.createCommentaireForBlog(blogId,idUser, commentDto);
    }
*/

   /*
    public CommentDto createComment(@RequestBody @Valid CommentDto commentDto) {
        return iCommentService.createComment(commentDto);
    }
    */

    @GetMapping("/{idComment}")
    public CommentDto getComment(@PathVariable Long idComment) {
        return iCommentService.getComment(idComment);
    }

    @PutMapping("/{idComment}")
    public CommentDto updateComment(@PathVariable Long idComment, @RequestBody @Valid CommentDto commentDto) {
        return iCommentService.updateComment(idComment, commentDto);
    }
    @DeleteMapping("/{idComment}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long idComment) {
        iCommentService.deleteComment(idComment);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/ModifierContenu/{idComment}")
    public ResponseEntity<CommentDto> ModifierContenu(@RequestParam("contenu") String contenu,
                                                        @PathVariable("idComment") Long idComment) throws IOException {
        String message = "";

        try {
            Comment comment = commentRepository.findById(idComment).get();
            comment.setContenu(contenu);
            commentRepository.save(comment);
            message = "ForumReply modifié avec succès! ";
            return ResponseEntity.status(HttpStatus.OK).body(new CommentDto());
        } catch (Exception e) {
            message = "Échec de la modification" + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new CommentDto());
        }

    }
    @DeleteMapping("/deleteCommentBlog/{idComment}")
    @ResponseBody
    public ResponseEntity<CommentDto> deleteCommentBlog(@PathVariable("idComment") Long idComment) {

        String message = "";

        try {
            Comment comment = commentRepository.findById(idComment).get();
            comment.setBlog(null);
            commentRepository.deleteById(idComment);
            message = "ForumPost supprimé avec succès: ";
            return ResponseEntity.status(HttpStatus.OK).body(new CommentDto());
        } catch (Exception e) {
            message = "Échec de la suppression" + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new CommentDto());
        }
    }
















   /*
    @Autowired
    ICommentService iCommentService ;
    @PostMapping("addComment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {

        System.out.printf(String.valueOf(comment));

        iCommentService.addComment(comment);

        return new ResponseEntity<Comment>(HttpStatus.CREATED);

    }


    @PostMapping("/{id}/reponses")
    public ResponseEntity<Comment> ajouterReponse(@PathVariable Long idComment, @RequestBody Comment reponse) {
        Comment commentaireParent = iCommentService.getCommentById(idComment);
        if (commentaireParent == null) {
            return ResponseEntity.notFound().build();
        }
        commentaireParent.ajouterReponse(reponse.getAuteur(), reponse.getContenu());
        Comment commentaireMaj = iCommentService.enregistrerCommentaire(commentaireParent);
        return ResponseEntity.ok(commentaireMaj);
    }

    */


}
