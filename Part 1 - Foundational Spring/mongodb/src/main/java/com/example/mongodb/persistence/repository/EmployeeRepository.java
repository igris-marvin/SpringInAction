package com.example.mongodb.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.mongodb.persistence.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    
}
