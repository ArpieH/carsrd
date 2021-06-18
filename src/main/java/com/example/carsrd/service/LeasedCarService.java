package com.example.carsrd.service;

import com.example.carsrd.domain.Car;
import com.example.carsrd.domain.LeasedCar;
import com.example.carsrd.repository.LeasedCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeasedCarService {

    @Autowired
    private LeasedCarRepository leasedCarRepository;

    //Get All Vehicles
    public List<LeasedCar> findAll(){
        return leasedCarRepository.findAll();
    }

    //Get Vehicle By Id
    public LeasedCar findById(int id) {
        return leasedCarRepository.findByID(id);
    }
    //Optional<UsedCar>
    //Delete Vehicle
    public void delete(int id) {
        leasedCarRepository.deleteById(id);
    }

    //Update Vehicle
    public void save(LeasedCar leasedCar) {
        leasedCarRepository.save(leasedCar);
    }

    public void update(LeasedCar leasedCar) {
        leasedCarRepository.save(leasedCar);
    }
}
