package com.example.ride_sharing.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.example.ride_sharing.models.Captain;

@Entity
@Table(name="trips")
public class Trip {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="captain_id")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="trip_date", nullable=false)
    private LocalDateTime startTime;

    @Column(name="origin", nullable=false)
    private String origin;

    @Column(name="destination", nullable=false)
    private String destination;

    @Column(name="trip_cost", nullable=false)
    private double cost;

    @Transient
    private LocalDateTime endTime;

    public Trip() {}
    public Trip(LocalDateTime startTime, String origin, String destination, double cost) {
        this.startTime = startTime;
        this.origin    = origin;
        this.destination = destination;
        this.cost      = cost;
    }

    // Original constructor with all fields
    public Trip(Captain captain, Customer customer, String origin, String destination, LocalDateTime startTime, LocalDateTime endTime) {
        this.captain = captain;
        this.customer = customer;
        this.origin = origin;
        this.destination = destination;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public void setTripCost(double cost) {
        this.setCost(cost);
    }
}
