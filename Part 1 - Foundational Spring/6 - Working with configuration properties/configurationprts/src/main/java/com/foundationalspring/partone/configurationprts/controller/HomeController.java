package com.foundationalspring.partone.configurationprts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foundationalspring.partone.configurationprts.model.NameManager;
import com.foundationalspring.partone.configurationprts.model.SizeProp;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private NameManager manager;

    @Autowired
    private SizeProp sizeProp;

    @GetMapping
    public String getHome(
        Model model
    ) {
        List<String> names = manager.generateNames();

        names = manager.pageableFilter(names, sizeProp.getSize());

        model.addAttribute("names", names);

        return "index";
    }
}
