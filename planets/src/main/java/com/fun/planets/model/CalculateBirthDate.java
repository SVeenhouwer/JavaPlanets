package com.fun.planets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class CalculateBirthDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private LocalDate today = LocalDate.now();
    private LocalDate enteredDate;
    private String enteredDateString;
    private long dateDays;
    private Period datePeriod;

    private double calculatedPlanetYears;
    private double calculatedPlanetDays;

    @OneToOne
    @JsonIgnoreProperties("calculateBirthDate")
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

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public LocalDate getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDate enteredDate) {
        this.enteredDate = enteredDate;
    }

    public String getEnteredDateString() {
        return enteredDateString;
    }

    public void setEnteredDateString(String enteredDateString) {
        this.enteredDateString = enteredDateString;
    }

    public long getDateDays() {
        return dateDays;
    }

    public void setDateDays(long dateDays) {
        this.dateDays = dateDays;
    }

    public Period getDatePeriod() {
        return datePeriod;
    }

    public void setDatePeriod(Period datePeriod) {
        this.datePeriod = datePeriod;
    }

    public double getCalculatedPlanetYears() {
        return calculatedPlanetYears;
    }

    public void setCalculatedPlanetYears(double calculatedPlanetYears) {
        this.calculatedPlanetYears = calculatedPlanetYears;
    }

    public double getCalculatedPlanetDays() {
        return calculatedPlanetDays;
    }

    public void setCalculatedPlanetDays(double calculatedPlanetDays) {
        this.calculatedPlanetDays = calculatedPlanetDays;
    }
}
