package com.example.ride_sharing.repositories;

import com.example.ride_sharing.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByCaptainId(Long captainId);
    List<Trip> findByCustomerId(Long customerId);
}

