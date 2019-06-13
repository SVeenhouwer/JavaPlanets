package com.fun.planets.service;

import com.fun.planets.model.CalculateBirthDate;
import com.fun.planets.persistance.CalculateBirthDateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalculateBirthDateService {

    private CalculateBirthDateRepository calculateBirthDateRepository;

    public CalculateBirthDateService(CalculateBirthDateRepository calculateBirthDateRepository) {
        this.calculateBirthDateRepository = calculateBirthDateRepository;
    }

    public CalculateBirthDate save(CalculateBirthDate calculateBirthDate){
        return this.calculateBirthDateRepository.save(calculateBirthDate);
    }

    public Optional<CalculateBirthDate> findById(Long aLong) {
        return calculateBirthDateRepository.findById(aLong);
    }

    public Iterable<CalculateBirthDate> findAll() {
        return calculateBirthDateRepository.findAll();
    }

    public void deleteById(Long aLong) {
        calculateBirthDateRepository.deleteById(aLong);
    }
}
