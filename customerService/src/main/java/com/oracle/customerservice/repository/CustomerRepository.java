package com.oracle.customerservice.repository;

import com.oracle.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String>{
    Customer findByEmail(String email);
}
