package com.restservices.rest.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.rest.api.dto.CustomerDTO;
import com.restservices.rest.api.service.CustomerService;
import com.restservices.rest.persistence.entity.Customer;

@RestController
@RequestMapping( //Handles resquest for /api/customer
    path = "/api/customer",
    produces = "application/json"
)
@CrossOrigin(
    origins = "http://localhost:9090/" //alows cross origin requests, allows clients from localhost, port 9090 to consume the API
)
public class CustomerController {
    
    @Autowired
    private CustomerService custServ;

    @GetMapping(params = "customer") //get customers
    public Iterable<Customer> getCustomers(

    ) {
        Iterable<Customer> list = custServ.fetchCustomers();

        return list;
    }

    @GetMapping("/{id}") //GET request to be sent should be -> <domain>/api/customer/1 -> 1 being the id
    public ResponseEntity<Customer> getCustomer(
        @PathVariable("id") Long id
    ) {
        Optional<Customer> optCust = custServ.getCustomer(id);

        return optCust.isPresent() 
            ? new ResponseEntity<Customer>(optCust.get(), HttpStatus.OK) 
            : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer posCustomer(
        @RequestBody CustomerDTO dto

    ) {
        return custServ.createCustomer(dto);
    }     
    // The consumes attribute is to request     
    // input what produces is to request output. Here you use consumes to say that the
    // method will only handle requests whose Content-type matches application/json.
    // code 201, created
    
    // Annotated with @RequestBody to indicate that the
    // body of the request should be converted to a Taco object and bound to the parameter.
    // @RequestBody annotation ensures that JSON in the request body
    // is bound to the Taco object instead.

}
