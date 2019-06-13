package com.fun.planets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet {

    private String name;
    private double orbitalPeriodSolar;
    private double orbitalPeriodAxis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
