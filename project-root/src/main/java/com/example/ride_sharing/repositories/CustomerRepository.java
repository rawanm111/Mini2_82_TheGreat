package com.example.ride_sharing.repositories;

import com.example.ride_sharing.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

