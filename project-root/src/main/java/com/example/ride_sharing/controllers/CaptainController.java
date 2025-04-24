package com.example.ride_sharing.controllers;

import com.example.ride_sharing.models.Captain;
import com.example.ride_sharing.services.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/captain")
public class CaptainController {

    @Autowired
    private CaptainService captainService;

    @PostMapping("/addCaptain")
    public Captain addCaptain(@RequestBody Captain captain) {
        return captainService.addCaptain(captain);
    }

    @GetMapping("/allCaptains")
    public List<Captain> getAllCaptains() {
        return captainService.getAllCaptains();
    }

    @GetMapping("/filterByRating")
    public List<Captain> getCaptainsByRating(@RequestParam("ratingThreshold") Double ratingThreshold) {
        return captainService.getCaptainsByRating(ratingThreshold);
    }
    @GetMapping("/filterByLicenseNumber")
    public Captain getByLicense(@RequestParam("licenseNumber") String lic) {
        return captainService.getCaptainByLicenseNumber(lic);
    }

    @GetMapping("/{id}")
    public Captain getCaptainById(@PathVariable Long id) {
        return captainService.getCaptainById(id);
    }
}
