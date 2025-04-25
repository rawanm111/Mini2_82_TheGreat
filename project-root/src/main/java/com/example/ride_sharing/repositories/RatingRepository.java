package com.example.ride_sharing.repositories;

import com.example.ride_sharing.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByTripId(Long tripId);
}

