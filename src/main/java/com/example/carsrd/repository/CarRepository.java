package com.example.carsrd.repository;

import com.example.carsrd.domain.Car;
import com.example.carsrd.domain.LeasedCar;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CarRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private Object Car;

    public List<Car> findAll() {
        TypedQuery<Car> newCar = entityManager.createQuery("select e from Car e",Car.class);
        return newCar.getResultList();
    }

    @Transactional(rollbackOn = Exception.class)
    public void save(LeasedCar leasedCar) {
        entityManager.persist(Car);
    }

    public Car findById(int id) {
        return entityManager.find(Car.class, id);
    }

    @Transactional
    public void update(Car newCar) {
        entityManager.merge(newCar);
    }
    @Transactional
    public void deleteById(int id) {
        Car newCar = findById(id);
        entityManager.remove(Car);
    }}