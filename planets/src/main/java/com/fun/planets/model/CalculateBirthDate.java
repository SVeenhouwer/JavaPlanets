package com.fun.planets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class CalculateBirthDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    LocalDate today = LocalDate.now();
    LocalDate enteredDate;
    String enteredDateString;
    long dateDays;
    Period datePeriod;

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
}
