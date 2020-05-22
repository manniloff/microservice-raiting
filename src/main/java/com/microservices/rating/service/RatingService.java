package com.microservices.rating.service;

import com.microservices.rating.model.Rating;
import com.microservices.rating.model.UserRating;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    List<Rating> findAll();
    Optional<Rating> findById(int id);
    boolean create(Rating newRating);
    boolean update(Rating rating, int id);
    int deleteById(int id);
    Optional<Rating> findByMovieId(String movieId);
    UserRating findAll(String userId);
}
