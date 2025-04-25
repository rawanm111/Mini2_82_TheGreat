package com.example.ride_sharing.services;

import com.example.ride_sharing.models.Trip;
import com.example.ride_sharing.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip updateTrip(Long id, Trip updatedTrip) {
        Optional<Trip> existingTripOpt = tripRepository.findById(id);
        if (existingTripOpt.isPresent()) {
            Trip existingTrip = existingTripOpt.get();
            existingTrip.setCaptain(updatedTrip.getCaptain());
            existingTrip.setCustomer(updatedTrip.getCustomer());
            existingTrip.setOrigin(updatedTrip.getOrigin());
            existingTrip.setDestination(updatedTrip.getDestination());
            existingTrip.setStartTime(updatedTrip.getStartTime());
            existingTrip.setEndTime(updatedTrip.getEndTime());
            return tripRepository.save(existingTrip);
        }
        return null;
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public List<Trip> getTripsByCaptainId(Long captainId) {
        return tripRepository.findByCaptainId(captainId);
    }

    public List<Trip> getTripsByCustomerId(Long customerId) {
        return tripRepository.findByCustomerId(customerId);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
    public List<Trip> getTripsWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return tripRepository.findAll().stream()
                .filter(trip -> trip.getStartTime() != null &&
                        !trip.getStartTime().isBefore(startDate) &&
                        !trip.getStartTime().isAfter(endDate))
                .collect(Collectors.toList());
    }

}
