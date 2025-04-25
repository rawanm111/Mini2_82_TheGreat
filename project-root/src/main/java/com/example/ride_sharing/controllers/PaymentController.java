package com.example.ride_sharing.controllers;

import com.example.ride_sharing.models.Payment;
import com.example.ride_sharing.repositories.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentRepository paymentRepo;

    public PaymentController(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @PostMapping("/addPayment")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentRepo.save(payment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return paymentRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/allPayments")
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @GetMapping("/findByAmountThreshold")
    public List<Payment> findByAmountThreshold(@RequestParam double threshold) {
        return paymentRepo.findByAmountGreaterThan(threshold);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updated) {
        return paymentRepo.findById(id)
                .map(existing -> {
                    existing.setAmount(updated.getAmount());
                    existing.setPaymentMethod(updated.getMethod());
                    existing.setStatus(updated.isStatus());
                    existing.setId(updated.getId());
                    return ResponseEntity.ok(paymentRepo.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {

        if (paymentRepo.existsById(id)) {
            paymentRepo.deleteById(id);
        }
        return ResponseEntity.ok("Payment deleted");
    }

}
