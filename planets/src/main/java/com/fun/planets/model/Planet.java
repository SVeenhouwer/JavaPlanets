package com.fun.planets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Planet {

    private String name;
    private double orbitalPeriodSolar;
    private double orbitalPeriodAxis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JsonIgnoreProperties("planet")
    private CalculatePeriod calculatePeriod;

    public CalculatePeriod getCalculatePeriod() {
        return calculatePeriod;
    }

    public void setCalculatePeriod(CalculatePeriod calculatePeriod) {
        this.calculatePeriod = calculatePeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOrbitalPeriodSolar() {
        return orbitalPeriodSolar;
    }

    public void setOrbitalPeriodSolar(double orbitalPeriodSolar) {
        this.orbitalPeriodSolar = orbitalPeriodSolar;
    }

    public double getOrbitalPeriodAxis() {
        return orbitalPeriodAxis;
    }

    public void setOrbitalPeriodAxis(double orbitalPeriodAxis) {
        this.orbitalPeriodAxis = orbitalPeriodAxis;
    }

    public long getId() {
        return id;
    }
}
