package com.example.ride_sharing.repositories;

import com.example.ride_sharing.models.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaptainRepository extends JpaRepository<Captain, Long> {
    Optional<Captain> findByLicenseNumber(String licenseNumber);
}
