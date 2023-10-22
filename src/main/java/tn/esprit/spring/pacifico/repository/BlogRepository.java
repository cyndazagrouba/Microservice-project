package tn.esprit.spring.pacifico.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.pacifico.entities.Blog;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Transactional
    <Optional> Blog findAllByIdBlog(Long idBlog);


    List<Blog> findAll();

    @Modifying
    @Query("delete from Blog b where b.idBlog = :id")
    void deleteBlog(@Param("id") Long id);

}
