package com.example.carsrd.controllers;

import com.example.carsrd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "car")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping(name = "/")
    public String showCarTablePage (Model model){
        model.addAttribute("cars", carService.findAll());
        return "carcoicetable";
    }
}
