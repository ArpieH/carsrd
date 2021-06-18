package com.example.carsrd.service;

import com.example.carsrd.domain.Employee;
import com.example.carsrd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Get All Employees
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    //Get Employee By Id
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    //Delete Employee
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    //Save Employee
    public void save( Employee employee) {
        employeeRepository.save(employee);
    }

    //Update Employee
    public void update( Employee employee) {
        employeeRepository.update(employee);
    }

}

