package com.example.mongodb.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mongodb.api.dto.EmployeeDTO;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public String getHome(
        Model model
    ) {
        model.addAttribute("emp_dto", new EmployeeDTO());

        return "index";
    }
}
