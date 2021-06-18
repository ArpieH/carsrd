package com.example.carsrd.repository;

import com.example.carsrd.domain.LeasedCar;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LeasedCarRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List <LeasedCar> findAll(){
    TypedQuery <LeasedCar> leasedCars = entityManager.createQuery("select e from LeasedCar e",LeasedCar.class);
return  leasedCars.getResultList();
    }
    @Transactional (rollbackOn = Exception.class)
    public void save (LeasedCar leasedCar){
    entityManager.persist(leasedCar);
    }
public  LeasedCar findByID (int id){
        return  entityManager.find(LeasedCar.class, id);
}
@Transactional
    public  void update (LeasedCar leasedCar){
        entityManager.merge(leasedCar);
}

@Transactional
    public void deleteById ( int id){
        LeasedCar leasedCar = findByID(id);
        entityManager.remove(leasedCar);
}
}
