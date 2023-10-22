package tn.esprit.spring.pacifico.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.pacifico.entities.Rating;
import tn.esprit.spring.pacifico.repository.BlogRepository;
import tn.esprit.spring.pacifico.repository.RatingRepository;
import tn.esprit.spring.pacifico.service.IRatinggService;
import tn.esprit.spring.pacifico.dto.RatingDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    /*@Autowired
    IRatinggService ratingService;
  *//*  @Autowired
    private UserRepository userRepository;*//*
    @Autowired
    private BlogRepository blogRepository ;
    @Autowired
   RatingRepository ratingRepository;

   *//* @PostMapping("/addRating")
    public String addRating( @RequestBody @Valid RatingDto ratingDto){
        return	ratingService.addRating(ratingDto);
    }
*//*
    @GetMapping(value ="/retrieve-all-ratings")
    @ResponseBody
    public List<Rating> getRatings()
    {
        return ratingService.retrieveAllRating();
    }



    @DeleteMapping("/remove-rating/{id}")
    @ResponseBody
    public void removeRating(@PathVariable("id") Long id) {
        ratingService.deleteRating(id);
    }


   *//* @PutMapping("/update-rating/{id}/{idBlog}")
    @ResponseBody
    public String modifyRating(@PathVariable("id") Long id,@PathVariable("idBlog") Long idBlog ,@RequestBody RatingDto r) {

        return ratingService.updateRating(id,idBlog,r);

    }*//*
    @GetMapping(value ="/retrieve-nbvu/{idBlog}")
    @ResponseBody
    public int getNbvu(@PathVariable("idBlog") Long idBlog)
    {

        return ratingService.nbReview(idBlog);

    }


    @GetMapping(value = "retrieve-all-ratingParProduct/{id}")
    @ResponseBody
    public List<Rating> getReviewsParProduct(@PathVariable("id") Long id) {

        return ratingService. retrieveAllReviews(id);

    }



    @GetMapping(value ="/retrieve-last-reviews/{id}")
    @ResponseBody
    public List<Rating> getLastReviews(@PathVariable("id")Long id)
    {

        return ratingService.listLastReviews(id);

    }
*/
}
