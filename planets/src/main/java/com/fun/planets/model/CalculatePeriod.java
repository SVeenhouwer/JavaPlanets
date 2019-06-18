package com.fun.planets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class CalculatePeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int enteredYears;
    private double calculatedDays;
    private double calculatedPlanetYears;
    private double calculatedPlanetYearsDays;

    private int enteredDays;
    private double calculatedPlanetDaysYears;
    private double calculatedPlanetDays;

    @OneToOne
    @JsonIgnoreProperties("calculatePeriod")
    private Planet planet;

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public long getId() {
        return id;
    }

    public int getEnteredYears() {
        return enteredYears;
    }

    public void setEnteredYears(int enteredYears) {
        this.enteredYears = enteredYears;
    }

    public double getCalculatedDays() {
        return calculatedDays;
    }

    public void setCalculatedDays(double calculatedDays) {
        this.calculatedDays = calculatedDays;
    }

    public double getCalculatedPlanetYears() {
        return calculatedPlanetYears;
    }

    public void setCalculatedPlanetYears(double calculatedPlanetYears) {
        this.calculatedPlanetYears = calculatedPlanetYears;
    }

    public double getCalculatedPlanetYearsDays() {
        return calculatedPlanetYearsDays;
    }

    public void setCalculatedPlanetYearsDays(double calculatedPlanetYearsDays) {
        this.calculatedPlanetYearsDays = calculatedPlanetYearsDays;
    }

    public int getEnteredDays() {
        return enteredDays;
    }

    public void setEnteredDays(int enteredDays) {
        this.enteredDays = enteredDays;
    }

    public double getCalculatedPlanetDaysYears() {
        return calculatedPlanetDaysYears;
    }

    public void setCalculatedPlanetDaysYears(double calculatedPlanetDaysYears) {
        this.calculatedPlanetDaysYears = calculatedPlanetDaysYears;
    }

    public double getCalculatedPlanetDays() {
        return calculatedPlanetDays;
    }

    public void setCalculatedPlanetDays(double calculatedPlanetDays) {
        this.calculatedPlanetDays = calculatedPlanetDays;
    }
}
