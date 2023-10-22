package tn.esprit.spring.pacifico.mappers;

import tn.esprit.spring.pacifico.dto.RatingDto;
import tn.esprit.spring.pacifico.entities.Rating;

public class RatingMapper {
    public static RatingDto mapToDo(Rating rating) {
        return RatingDto.builder()
                .note(rating.getNote())
                .dateRating(rating.getDateRating())
                .review(rating.getReview())
                .build();
    }

    public static Rating maptoEntity(RatingDto ratingDto) {

        Rating rating = new Rating();
        rating.setNote(ratingDto.getNote());
        rating.setReview(ratingDto.getReview());
        rating.setDateRating(ratingDto.getDateRating());
        return rating;


    }
}
