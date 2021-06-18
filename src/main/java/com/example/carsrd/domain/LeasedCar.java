package com.example.carsrd.domain;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LeasedCar {
    @Id
    public Long id;
    @Column(name ="Cat")
    private String cat;

    @Column(name ="Brand")
    private String brand;
    @Column(name = "Model")
    private String model;
    @Column (name = "Pack")
    private String Pack;
    @Column (name = "List_price_incl_real_VAT")
    private Double listPrice;
    @Column (name = "Benefit_in_kind_mont")
    private Double benefitInMonth;
    @Column (name = "Amount_upgrade_incl_21_VAT ")
    private  Double upgradeAmount;
    @ManyToOne
    private Employee employee;
}
