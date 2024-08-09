package com.foundationalspring.partone.configurationprts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foundationalspring.partone.configurationprts.model.NameManager;

@Controller
@RequestMapping("/")
@ConfigurationProperties(prefix = "name.manager")
public class HomeController {
    
    private int size = 10;

    @Autowired
    private NameManager manager;

    @GetMapping
    public String getHome(
        Model model
    ) {
        List<String> names = manager.generateNames();

        names = manager.pageableFilter(names, size);

        model.addAttribute("names", names);

        return "index";
    }
}
