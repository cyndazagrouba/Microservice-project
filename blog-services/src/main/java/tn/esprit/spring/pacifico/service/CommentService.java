package tn.esprit.spring.pacifico.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.pacifico.dto.CommentDto;
import tn.esprit.spring.pacifico.entities.Comment;
import tn.esprit.spring.pacifico.repository.BlogRepository;
import tn.esprit.spring.pacifico.repository.CommentRepository;


@Service
@Slf4j
@AllArgsConstructor
public class CommentService implements ICommentService{
    @Autowired
    CommentRepository commentRepository ;
    @Autowired
    BlogRepository blogRepository ;

   /* @Autowired
    UserRepository userRepository ;
    @Autowired*/
    private ModelMapper modelMapper;

 /*
    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        Blog blog = new Blog();
        blog.setIdBlog(commentDto.getBlogId());
        comment.setBlog(blog);
        comment = commentRepository.save(comment);
            return modelMapper.map(comment,CommentDto.class);
    }
  */
    /*public CommentDto createCommentaireForBlog(Long blogId,Long idUser, CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new NotFoundException("Blog not found"));
        User user = userRepository.findAllByIdUser(idUser);
        comment.setUsers(user);
        comment.setBlog(blog);
        comment = commentRepository.save(comment);
        return modelMapper.map(comment,CommentDto.class);
    }*/



    @Override
    public CommentDto getComment(Long idComment) {
        Comment comment = commentRepository.findById(idComment)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(Long idComment, CommentDto commentDto) {
        Comment comment = commentRepository.findById(idComment)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        modelMapper.map(commentDto, comment);

        comment = commentRepository.save(comment);
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public void deleteComment(Long idComment) {
        commentRepository.deleteById(idComment);
    }
}
