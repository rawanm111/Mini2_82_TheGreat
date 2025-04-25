package com.example.ride_sharing.controllers;

import com.example.ride_sharing.models.Trip;
import com.example.ride_sharing.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/addTrip")
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    @GetMapping("/allTrips")
    public List<Trip> getAllTrips() {
        try {
            return tripService.getAllTrips();
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
    }


    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @PutMapping("/update/{id}")
    public Trip updateTrip(@PathVariable Long id, @RequestBody Trip updatedTrip) {
        return tripService.updateTrip(id, updatedTrip);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.ok("Trip deleted successfully");
    }
    @GetMapping("/findByDateRange")
    public List<Trip> getTripsWithinDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {

        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end   = LocalDateTime.parse(endDate);
        return tripService.getTripsWithinDateRange(start, end);
    }

    @GetMapping("/findByCaptainId")
    public List<Trip> findByCaptainId(@RequestParam Long captainId) {
        return tripService.getTripsByCaptainId(captainId);
    }

    @GetMapping("/findByCustomerId")
    public List<Trip> findByCustomerId(@RequestParam Long customerId) {
        return tripService.getTripsByCustomerId(customerId);
    }
}
