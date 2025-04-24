package com.example.ride_sharing.models;

import jakarta.persistence.*;

@Entity
@Table(name = "captains")
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "avg_rating_score")
    private double avgRatingScore;

    // Constructors
    public Captain(String name, String registrationNumber, Double rating) {
        this.name = name;
        this.licenseNumber = registrationNumber;
        this.avgRatingScore = rating;
    }

    public Captain() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return licenseNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.licenseNumber = registrationNumber;
    }

    public Double getRating() {
        return avgRatingScore;
    }

    public void setRating(Double rating) {
        this.avgRatingScore = rating;
    }
}
