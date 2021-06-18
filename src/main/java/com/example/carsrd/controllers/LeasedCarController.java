package com.example.carsrd.controllers;

import com.example.carsrd.domain.LeasedCar;
import com.example.carsrd.service.LeasedCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LeasedCarController {

    @Autowired
    private LeasedCarService leasedCarService;

    //Get All Vehicles
    @GetMapping("vehicles")
    public String findAll(Model model){
        model.addAttribute("vehicles", leasedCarService.findAll());
        return "vehicle";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public LeasedCar findById(Integer id)
    {
        return leasedCarService.findById(id);
    }

    //Add Vehicle
    @PostMapping(value="vehicles/addNew")
    public String addNew(LeasedCar leasedCar) {
        leasedCarService.save(leasedCar);
        return "redirect:/vehicles";
    }

    @RequestMapping(value="vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(LeasedCar leasedCar) {
        leasedCarService.save(leasedCar);
        return "redirect:/vehicles";
    }

    @RequestMapping(value="vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        leasedCarService.delete(id);
        return "redirect:/vehicles";
    }
    }


