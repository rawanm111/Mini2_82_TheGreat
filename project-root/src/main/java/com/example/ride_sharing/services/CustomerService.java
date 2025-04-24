package com.example.ride_sharing.services;

import com.example.ride_sharing.models.Customer;
import com.example.ride_sharing.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    public List<Customer> findByEmailDomain(String domain) {
        return customerRepository.findAll().stream()
                .filter(c -> c.getEmail() != null && c.getEmail().endsWith("@" + domain))
                .collect(Collectors.toList());
    }


    public List<Customer> findByPhonePrefix(String prefix) {
        return customerRepository.findAll().stream()
                .filter(c -> c.getPhone() != null && c.getPhone().startsWith(prefix))
                .collect(Collectors.toList());
    }
}

