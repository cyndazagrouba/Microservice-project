package tn.esprit.spring.pacifico.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.pacifico.entities.LikeBlog;


public interface  LikeBlogRepository extends JpaRepository<LikeBlog,Long> {


    <Optional> LikeBlog findAllById(Long id);

   /* @Query("select l  from LikeBlog l  where ( l.user.idUser=:username and l.blogg.idBlog=:username1)")
    public LikeBlog likeexist(@Param("username") Long username,@Param("username1") Long username1);
*/
    //nb de like par post
    @Query( "select count (la) FROM LikeBlog la where la.blogg.idBlog=:Idblog and la.etat =true")
    public int nbLike(@Param ("Idblog") Long Idblog);

    //nb de dislike par post
    @Query("select count (l) FROM LikeBlog l where (l.blogg.idBlog =:Idblog and l.etat = false)")
    public int nbDisLike(@Param ("Idblog") Long Idblog);




}
