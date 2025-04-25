package com.example.ride_sharing.repositories;

import com.example.ride_sharing.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByTripId(Long tripId);
    List<Payment> findByAmountGreaterThan(double threshold);
}
