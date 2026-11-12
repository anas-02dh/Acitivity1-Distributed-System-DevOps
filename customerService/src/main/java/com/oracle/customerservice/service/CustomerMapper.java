package com.oracle.customerservice.service;


import com.oracle.customerservice.entity.Customer;
import com.oracle.customerservice.entity.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    private ModelMapper modelMapper = new ModelMapper();


    public CustomerDTO fromCustomer(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public Customer fromCustomerDTO(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }
}
