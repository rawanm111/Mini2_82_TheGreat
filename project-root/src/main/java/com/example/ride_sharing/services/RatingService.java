package com.example.ride_sharing.services;

import com.example.ride_sharing.models.Rating;
import com.example.ride_sharing.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findAll().stream()
                .filter(rating -> rating.getScore() >= minScore)
                .collect(Collectors.toList());
    }

    public Rating getRatingById(String id) {
        return ratingRepository.findById(id).orElse(null);
    }
    public List<Rating> findRatingsByTripId(Long tripId) {
        return ratingRepository.findByTripId(tripId);
    }

    public Rating updateRating(String id, Rating updated) {
        return ratingRepository.findById(id)
                .map(r -> {
                    r.setTripId(updated.getTripId());
                    r.setCustomer(updated.getCustomer());
                    r.setScore(updated.getScore());
                    r.setComment(updated.getComment());
                    r.setTimestamp(updated.getTimestamp());
                    return ratingRepository.save(r);
                })
                .orElse(null);
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }
}
