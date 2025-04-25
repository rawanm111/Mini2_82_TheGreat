package com.example.ride_sharing.models;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private Double amount;

    @Column(name = "payment_method")
    private String method;

    @Column(name = "payment_status")
    private boolean status;

    public Payment() {}


    public Payment(Double amount, String method, boolean status) {
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void setPaymentMethod(String method) {
        this.setMethod(method);  // Call the existing setMethod method
    }
}
