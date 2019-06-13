package com.fun.planets.service;

import com.fun.planets.model.Planet;
import com.fun.planets.persistance.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanetService {

    private PlanetRepository planetRepository;

    PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet save(Planet planet){
        return this.planetRepository.save(planet);
    }

    public Optional<Planet> findById(Long aLong) {
        return planetRepository.findById(aLong);
    }

    public Iterable<Planet> findAll() {
        return planetRepository.findAll();
    }

    public void deleteById(Long aLong) {
        planetRepository.deleteById(aLong);
    }
}
