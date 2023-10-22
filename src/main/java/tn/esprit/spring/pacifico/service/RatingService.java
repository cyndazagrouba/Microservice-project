package tn.esprit.spring.pacifico.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.pacifico.entities.Blog;
import tn.esprit.spring.pacifico.entities.Rating;
import tn.esprit.spring.pacifico.repository.RatingRepository;
import tn.esprit.spring.pacifico.dto.RatingDto;

import java.util.List;

@Service
@Transactional
public class RatingService implements IRatinggService {
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    private ModelMapper modelMapper;


    /*@Override
    public String addRating(RatingDto ratingDto )
    {

        Rating r = modelMapper.map(ratingDto, Rating.class);
        User user =new User();
        Blog blog = new Blog();
        user.setIdUser(ratingDto.getIdUser());
        blog.setIdBlog(ratingDto.getIdBlog());
        r.setBlog(blog);
        r.setUser(user);
        List<Rating> ratings;
        ratings=ratingRepository.findAll();
        for (Rating ra : ratings)
        {
        if (ratingDto.getIdBlog().equals(ra.getBlog().getIdBlog())
                && ratingDto.getIdBlog().equals(ra.getUser().getIdUser())&&
            ratingDto.getNote()== ra.getNote() &&
             ratingDto.getReview()==ra.getReview()&&
                ratingDto.getDateRating()==ra.getDateRating()
        )
            {
            return "save with succes";
             }

        }
        modelMapper.map(ratings, RatingDto.class);
        ratingRepository.save(r);

        return "rating added";

    }*/






    /*
    @Override
   public String addRating(RatingDto r, Long idp, Long u) {

        Rating rating = modelMapper.map(r, Rating.class);
      rating = ratingRepository.ratingexist(idp, u);
       if (rating != null) {
           return "Rating already exists";
       }


     //  Rating rating = modelMapper.map(r, Rating.class);

       r.setDateRating(new Date());
       r.setIdBlog(idp);
       r.setIdUser(u);

       ratingRepository.save(rating);
       return "Rating saved successfully";
   }
*/
    /*@Override
    public void deleteRating(Long i) {
        ratingRepository.deleteById(i);

    }

    @Override
    public List<Rating> retrieveAllReviews(Long id) {

        return ratingRepository.listReviews(id);

    }

    @Override
    public int nbReview(Long idBlog) {
        return ratingRepository.nbreviews(idBlog);
    }
*/
   /* @Override
    public String updateRating(Long idBlog, Long id ,RatingDto r) {


        Rating rating = modelMapper.map(r, Rating.class);
        rating = ratingRepository.findAllById(id);
        Blog blog = new Blog();
        blog.setIdBlog(r.getIdBlog());
        User user =new User();
        user.setIdUser(r.getIdUser());
        ratingRepository.save(rating);

        return "note enregistré";
    }
*/
   /* @Override
    public List<Rating> listLastReviews(Long id) {
        return ratingRepository.listLastReviews(id);
    }*/
//   @Override
//    public List<Rating> retrieveAllRating() {
//  //     Rating rating = modelMapper.map(r, Rating.class);
//        List<Rating> ratings = (List<Rating>) ratingRepository.findAll();
//		/*for (Rating rating : ratings) {
//			L.info("user +++ : " + rating);
//		}*/
//        return ratings;
//
//    }
//    public RatingDto getRating(Long id) {
//        Rating rating = ratingRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
//        return modelMapper.map(rating, RatingDto.class);
//    }



}
