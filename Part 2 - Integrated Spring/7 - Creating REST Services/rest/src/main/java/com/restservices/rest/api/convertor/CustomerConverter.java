package com.restservices.rest.api.convertor;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.restservices.rest.api.dto.CustomerDTO;
import com.restservices.rest.persistence.entity.Customer;

@Component
public class CustomerConverter {
    
    public Customer convertToCustomer(
        CustomerDTO dto
    ) {
        String name = dto.getName();
        Integer age = Integer.parseInt(dto.getAge());
        Date timestamp = Date.from(Instant.now());

        Customer cust = new Customer(name, age, timestamp);

        return cust;
    }
}
