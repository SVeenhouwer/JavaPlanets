package com.fun.planets.service;

import com.fun.planets.model.CalculatePeriod;
import com.fun.planets.persistance.CalculatePeriodRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalculatePeriodService {

    private CalculatePeriodRepository calculatePeriodRepository;

    public CalculatePeriodService(CalculatePeriodRepository calculatePeriodRepository) {
        this.calculatePeriodRepository = calculatePeriodRepository;
    }

    public CalculatePeriod save(CalculatePeriod calculatePeriod){
        return this.calculatePeriodRepository.save(calculatePeriod);
    }

    public Optional<CalculatePeriod> findById(Long aLong) {
        return calculatePeriodRepository.findById(aLong);
    }

    public Iterable<CalculatePeriod> findAll() {
        return calculatePeriodRepository.findAll();
    }

    public void deleteById(Long aLong) {
        calculatePeriodRepository.deleteById(aLong);
    }
}
