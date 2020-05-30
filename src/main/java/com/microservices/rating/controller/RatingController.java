package com.microservices.rating.controller;

import com.microservices.rating.model.Rating;
import com.microservices.rating.model.UserRating;
import com.microservices.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RatingController.class);
    private final RatingService ratingService;

    @GetMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<?> findAll() {
        return ResponseEntity.ok(ratingService.findAll());
    }

    @GetMapping(value = {"/{id}"}, produces = "application/json")
    ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok(ratingService.findById(id));
    }

    @PostMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<?> create(@RequestBody Rating newRating) {
        return ResponseEntity.ok(ratingService.create(newRating));
    }

    @PutMapping(value = {"/{id}"}, produces = "application/json")
    ResponseEntity<?> update(@RequestBody Rating newRating, @PathVariable int id) {
        return ResponseEntity.ok(ratingService.update(newRating, id));
    }

    @DeleteMapping(value = {"/{id}"}, produces = "application/json")
    ResponseEntity<?> deleteById(@PathVariable int id) {
        return ResponseEntity.ok(ratingService.deleteById(id));
    }

    @GetMapping(value = {"/movie/{movieId}"}, produces = "application/json")
    Rating getMovieInfo(@PathVariable String movieId) {
        return ratingService.findByMovieId(movieId).get();
    }

    @GetMapping(value = {"/user"}, produces = "application/json")
    UserRating getRatingList() {
        return ratingService.findAllUserRating();
    }
}
