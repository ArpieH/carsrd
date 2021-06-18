package com.example.carsrd.domain;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;

    @ManyToOne
    private LeasedCar currentCar;
}
