package com.example.ride_sharing.controllers;

import com.example.ride_sharing.models.Rating;
import com.example.ride_sharing.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/addRating")
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    @GetMapping("/getAllRatings")
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/findAboveScore")
    public List<Rating> findRatingsAboveScore(@RequestParam("minScore") int minScore) {
        return ratingService.findRatingsAboveScore(minScore);
    }

    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable String id) {
        return ratingService.getRatingById(id);
    }
    @GetMapping("/findByEntity")
    public List<Rating> findByEntity(
            @RequestParam Long entityId,
            @RequestParam String entityType
    ) {
        if ("trip".equalsIgnoreCase(entityType)) {
            return ratingService.findRatingsByTripId(entityId);
        }

        return Collections.emptyList();
    }

    @PutMapping("/update/{id}")
    public Rating updateRating(
            @PathVariable String id,
            @RequestBody Rating updatedRating
    ) {
        return ratingService.updateRating(id, updatedRating);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable String id) {
        ratingService.deleteRating(id);
        return ResponseEntity.ok("Rating deleted successfully");
    }

}
