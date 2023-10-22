package tn.esprit.spring.pacifico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.pacifico.dto.RatingDto;
import tn.esprit.spring.pacifico.entities.Rating;

import java.util.List;


public interface RatingRepository extends JpaRepository<Rating, Long> {
    <Optional> Rating findAllById(Long id);


  /*  @Query("SELECT COUNT(r) FROM Rating r WHERE  (r.blog.idBlog =:idBlog)")
    public int nbreviews(@Param("idBlog") Long idBlog);

    @Query(nativeQuery = true, value = "select `id`, `date_rating`, `review`, `idB`, `idU`, `note` from rating where id order by date_rating desc limit 3")
    public List<Rating> listLastReviews(@Param("id") Long id);

    @Query("select r from Rating r where r.blog.idBlog=:id order by r.DateRating desc")
    public List<Rating> listReviews(@Param("id") Long id);

    @Query("SELECT  r  FROM Rating r  where ( r.user.idUser=:mailAddress and r.blog.idBlog=:mailAddress1)")
    public RatingDto ratingexist(@Param("mailAddress") Long mailAddress, @Param("mailAddress1") Long mailAddress1);
*/

}
