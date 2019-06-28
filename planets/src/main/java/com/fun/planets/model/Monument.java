package com.fun.planets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Monument {

    private String name;
    private LocalDate today = LocalDate.now();
    private LocalDate buildDate;
    private Period agePeriod;
    private long ageDays;
    private String buildDateString;
    private String agePeriodString;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public LocalDate getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(LocalDate buildDate) {
        this.buildDate = buildDate;
    }

    public Period getAgePeriod() {
        return agePeriod;
    }

    public void setAgePeriod(Period agePeriod) {
        this.agePeriod = agePeriod;
    }

    public long getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(long ageDays) {
        this.ageDays = ageDays;
    }

    public long getId() {
        return id;
    }

    public String getBuildDateString() {
        return buildDateString;
    }

    public void setBuildDateString(String buildDateString) {
        this.buildDateString = buildDateString;
    }

    public String getAgePeriodString() {
        return agePeriodString;
    }

    public void setAgePeriodString(String agePeriodString) {
        this.agePeriodString = agePeriodString;
    }
}
