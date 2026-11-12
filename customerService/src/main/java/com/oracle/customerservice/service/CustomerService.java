package com.oracle.customerservice.service;


import com.oracle.customerservice.entity.Customer;
import com.oracle.customerservice.entity.CustomerDTO;
import com.oracle.customerservice.exception.EmailAlreadyUsedException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO save(CustomerDTO request) throws EmailAlreadyUsedException;
    CustomerDTO getCustomerById(String id);
}
