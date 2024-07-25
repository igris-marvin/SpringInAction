package com.example.mongodb.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb.api.dto.EmployeeDTO;
import com.example.mongodb.persistence.entity.Employee;
import com.example.mongodb.persistence.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository empRepo;

    public Boolean insertEmployee(EmployeeDTO emp_dto) {

        try {
            Employee emp = new Employee(
                emp_dto.getEname(), 
                emp_dto.getJob(), 
                Double.parseDouble(emp_dto.getSal())
            );

            empRepo.save(emp);

            return true;

        } catch(NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
}
