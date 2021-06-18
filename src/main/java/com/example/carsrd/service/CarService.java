package com.example.carsrd.service;

import com.example.carsrd.domain.Car;
import com.example.carsrd.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public List<Car> findAll() { return carRepository.findAll();
    }
}
