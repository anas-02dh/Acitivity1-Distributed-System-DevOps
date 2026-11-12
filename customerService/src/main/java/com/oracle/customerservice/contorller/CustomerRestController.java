package com.oracle.customerservice.contorller;


import com.oracle.customerservice.entity.CustomerDTO;
import com.oracle.customerservice.service.CustomerService;
import com.oracle.customerservice.service.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class CustomerRestController {
    private  CustomerService customerService;

    @GetMapping("/customers")
    List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customers")
    CustomerDTO save(CustomerDTO request) {
        return customerService.save(request);
    }

    @GetMapping("/customers/{id}")
    CustomerDTO getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }
}
