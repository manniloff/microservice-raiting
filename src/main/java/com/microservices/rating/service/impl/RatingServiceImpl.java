package com.microservices.rating.service.impl;

import com.microservices.rating.model.Rating;
import com.microservices.rating.model.UserRating;
import com.microservices.rating.repository.RatingRepository;
import com.microservices.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final static Logger LOGGER = LoggerFactory.getLogger(RatingServiceImpl.class);
    private final RatingRepository ratingRepository;


    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> findById(int id) {
        return ratingRepository.findById(id);
    }

    @Override
    public boolean create(Rating newRating) {
        try {
            ratingRepository.save(newRating);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Rating rating, int id) {
        try {
            Rating updated = new Rating();
            ratingRepository.findById(id)
                    .ifPresent(r -> {
                        updated.setId(r.getId());
                        updated.setMovieId(rating.getMovieId());
                        updated.setRating(rating.getRating());
                    });
            ratingRepository.save(updated);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    public int deleteById(int id) {
        ratingRepository.findById(id).ifPresent(r ->
                ratingRepository.deleteById(r.getId())
        );
        return id;
    }

    @Override
    public Optional<Rating> findByMovieId(String movieId) {
        return ratingRepository.findByMovieId(movieId);
    }

    @Override
    public UserRating findAllUserRating() {
        UserRating userRating = new UserRating();
        userRating.setRatingList(ratingRepository.findAll());
        return userRating;
    }
}
