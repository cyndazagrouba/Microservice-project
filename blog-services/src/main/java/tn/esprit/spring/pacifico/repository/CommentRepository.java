package tn.esprit.spring.pacifico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.pacifico.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
