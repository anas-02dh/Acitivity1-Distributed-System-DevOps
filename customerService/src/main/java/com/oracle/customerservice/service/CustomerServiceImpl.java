package com.oracle.customerservice.service;

import com.oracle.customerservice.entity.Customer;
import com.oracle.customerservice.entity.CustomerDTO;
import com.oracle.customerservice.exception.CustomerNotFound;
import com.oracle.customerservice.exception.EmailAlreadyUsedException;
import com.oracle.customerservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
       return customerRepository.findAll().stream().map(c->mapper.fromCustomer(c)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO save(CustomerDTO request) throws EmailAlreadyUsedException {
        Customer customerExist = customerRepository.findByEmail(request.getEmail());

        if(customerExist != null) {
            throw new EmailAlreadyUsedException("email is already used");
        }

        else {
            Customer customer = mapper.fromCustomerDTO(request);
            Customer customerSaved =customerRepository.save(customer);
            return mapper.fromCustomer(customerSaved);
        }

    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        Customer customer =customerRepository.findById(id).orElse(null);

        if(customer == null) {
            throw new CustomerNotFound("Customer Not Found");
        }

        return mapper.fromCustomer(customer);
    }
}
