package com.restservices.rest.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.restservices.rest.api.convertor.CustomerConverter;
import com.restservices.rest.api.dto.CustomerDTO;
import com.restservices.rest.persistence.entity.Customer;
import com.restservices.rest.persistence.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository custRepo;

    @Autowired
    private CustomerConverter custConv;

    public Iterable<Customer> fetchCustomers() {

        PageRequest pageable = PageRequest.of(
            0, 
            10, 
            Sort
                .by("timestamp")
                .descending()
        );

        Iterable<Customer> list = custRepo.findAll(pageable).getContent();

        return list;
    }

    public Optional<Customer> getCustomer(
        Long id
    ) {
        Optional<Customer> cust = custRepo.findById(id);

        return cust;
    }

    public Customer createCustomer(CustomerDTO dto) {
        Customer customer = custConv.convertToCustomer(dto);

        return custRepo.save(customer);
    }
}
