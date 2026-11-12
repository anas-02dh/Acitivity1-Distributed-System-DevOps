package com.oracle.customerservice.data;


import com.oracle.customerservice.entity.Customer;
import com.oracle.customerservice.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader {
    private CustomerRepository customerRepository;

    @PostConstruct
    private void loadData() {
        customerRepository.saveAll(
                List.of(
                        Customer.builder()
                                .firstName("anas")
                                .lastName("Driouch")
                                .email("an.driouch@gmail.com")
                                .build(),

                        Customer.builder()
                                .firstName("youssef")
                                .lastName("Saif")
                                .email("yf.saif@gmail.com")
                                .build(),

                        Customer.builder()
                                .firstName("Ahmed")
                                .lastName("Benali")
                                .email("ah.benali@gmail.com")
                                .build(),

                        Customer.builder()
                                .firstName("Sara")
                                .lastName("Kebbaj")
                                .email("sar.kebbaj@gmail.com")
                                .build()

                )

        );
    }
}
