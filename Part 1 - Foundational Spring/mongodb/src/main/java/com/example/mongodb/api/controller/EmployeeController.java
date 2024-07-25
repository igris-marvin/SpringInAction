package com.example.mongodb.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mongodb.api.dto.EmployeeDTO;
import com.example.mongodb.api.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empServ;

    @PostMapping("/insert")
    public String postMethodName(
        @ModelAttribute("emp_dto") EmployeeDTO emp_dto,
        Model model
    ) {
        Boolean flag = empServ.insertEmployee(emp_dto);

        model.addAttribute(
            "result", 
            Boolean.toString(flag)
                .toUpperCase()
        );

        return "result";
    }
    
}
