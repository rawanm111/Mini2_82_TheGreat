package com.example.ride_sharing.services;

import com.example.ride_sharing.models.Captain;
import com.example.ride_sharing.repositories.CaptainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CaptainService {

    @Autowired
    private CaptainRepository captainRepository;

    public Captain addCaptain(Captain captain) {
        return captainRepository.save(captain);
    }

    public Captain getCaptainById(Long id) {
        return captainRepository.findById(id).orElse(null);
    }

    public List<Captain> getAllCaptains() {
        return captainRepository.findAll();
    }

    public List<Captain> getCaptainsByRating(Double ratingThreshold) {
        return captainRepository.findAll().stream()
                .filter(c -> c.getRating() >= ratingThreshold)
                .collect(Collectors.toList());
    }

    public void deleteCaptain(Long id) {
        captainRepository.deleteById(id);
    }
    public Captain getCaptainByLicenseNumber(String licenseNumber) {
        return captainRepository
                .findByLicenseNumber(licenseNumber)
                .orElse(null);
    }
}

