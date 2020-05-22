package com.microservices.rating.repository;

import com.microservices.rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    @Query("select r from Rating r where r.movieId=:movieId")
    Optional<Rating> findByMovieId(@Param("movieId") String movieId);
}
