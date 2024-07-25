package com.example.mongodb.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mongodb.api.dto.EmployeeDTO;
import com.example.mongodb.api.service.EmployeeService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private EmployeeService empServ;
    
    @GetMapping
    public String getHome(
        Model model
    ) {
        List<String> l = empServ.fetchAllLocationsNames();

        model.addAttribute("emp_dto", new EmployeeDTO());
        model.addAttribute("locations", l);

        for (String x : l) {
            System.out.println(x);
        }

        return "index";
    }
}
