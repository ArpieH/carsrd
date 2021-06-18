package com.example.carsrd.repository;

import com.example.carsrd.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAll() {
        TypedQuery<Employee> employees = entityManager.createQuery("select e from Employee e",Employee.class);
        return employees.getResultList();
    }

    @Transactional(rollbackOn = Exception.class)
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }
    @Transactional
    public void deleteById(int id) {
        Employee employee = findById(id);
        entityManager.remove(employee);
    }}