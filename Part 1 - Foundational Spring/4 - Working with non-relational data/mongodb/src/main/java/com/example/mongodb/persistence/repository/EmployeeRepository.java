package com.example.mongodb.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodb.persistence.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
    
}
