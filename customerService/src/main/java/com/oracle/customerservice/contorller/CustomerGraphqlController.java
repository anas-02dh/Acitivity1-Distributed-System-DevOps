package com.oracle.customerservice.contorller;


import com.oracle.customerservice.entity.CustomerDTO;
import com.oracle.customerservice.exception.EmailAlreadyUsedException;
import com.oracle.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class CustomerGraphqlController {

    private final CustomerService customerService;



    @QueryMapping
    public List<CustomerDTO> customers() {
        return customerService.getAllCustomers();
    }

    @QueryMapping
    public CustomerDTO customerById(@Argument String id) {
        return customerService.getCustomerById(id);
    }

    @MutationMapping
    public CustomerDTO saveCustomer(
            @Argument CustomerDTO request) {
        return customerService.save(request);
    }
}
