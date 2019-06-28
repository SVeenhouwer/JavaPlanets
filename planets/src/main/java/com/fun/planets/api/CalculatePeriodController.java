package com.fun.planets.api;

import com.fun.planets.model.CalculatePeriod;
import com.fun.planets.model.Planet;
import com.fun.planets.service.CalculatePeriodService;
import com.fun.planets.service.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/calculatePeriod")
@CrossOrigin(origins = "http://localhost:4200")
public class CalculatePeriodController {

    private CalculatePeriodService calculatePeriodService;
    private PlanetService planetService;

    public CalculatePeriodController(CalculatePeriodService calculatePeriodService, PlanetService planetService) {
        this.calculatePeriodService = calculatePeriodService;
        this.planetService = planetService;
    }

    @PostMapping
    public CalculatePeriod create(@RequestBody CalculatePeriod calculatePeriod) {
        return this.calculatePeriodService.save(calculatePeriod);
    }

    @GetMapping
    public Iterable<CalculatePeriod> list(){
        return this.calculatePeriodService.findAll();
    }


    @GetMapping("{id}")
    public CalculatePeriod get(@PathVariable long id) {
        Optional<CalculatePeriod> optionalResult = this.calculatePeriodService.findById(id);
        if (optionalResult.isPresent()) {
            CalculatePeriod result = optionalResult.get();
            return result;
        } else {
            return null; // fix this later!
        }
    }

    @PutMapping("{calculatePeriodId}/addPlanet/{planetId}")
    public CalculatePeriod addPlanet(@PathVariable long calculatePeriodId, @PathVariable long planetId, @RequestBody CalculatePeriod input) {
        Optional<CalculatePeriod> optionalCalculatePeriod = this.calculatePeriodService.findById(calculatePeriodId);
        Optional<Planet> optionalPlanet = this.planetService.findById(planetId);
        if (optionalCalculatePeriod.isPresent() && optionalPlanet.isPresent()) {
            (optionalCalculatePeriod.get()).setPlanet(optionalPlanet.get());
            (optionalPlanet.get()).setCalculatePeriod(optionalCalculatePeriod.get());
            this.calculatePeriodService.save(optionalCalculatePeriod.get());
            this.planetService.save(optionalPlanet.get());
            return optionalCalculatePeriod.get();
        }
        else {
            return null;
        }
    }

    @PutMapping("{id}")
    public CalculatePeriod update(@PathVariable long id, @RequestBody CalculatePeriod input) {
        Optional<CalculatePeriod> optionalCalculatePeriod = this.calculatePeriodService.findById(id);
        Optional<Planet> optionalPlanet = this.planetService.findById(id);
        if (optionalCalculatePeriod.isPresent() && optionalPlanet.isPresent()) {
            CalculatePeriod target = optionalCalculatePeriod.get();
            Planet targetPlanet = optionalPlanet.get();
            Planet earth = this.planetService.findById((long)3).get();
            if (input.getEnteredYears() != 0) {
                target.setEnteredYears(input.getEnteredYears());
            } else {
                target.setEnteredYears(0);
            }
            if (input.getEnteredDays() != 0) {
                target.setEnteredDays(input.getEnteredDays());
            } else {
                target.setEnteredDays(0);
            }
            target.setCalculatedDays(target.getEnteredYears()*earth.getOrbitalPeriodSolar());
            target.setCalculatedPlanetYearsDays(target.getCalculatedDays()/targetPlanet.getOrbitalPeriodAxis());
            target.setCalculatedPlanetYears(target.getCalculatedDays()/targetPlanet.getOrbitalPeriodSolar());
            target.setCalculatedPlanetDays(target.getEnteredDays()/targetPlanet.getOrbitalPeriodAxis());
            target.setCalculatedPlanetDaysYears(target.getEnteredDays()/targetPlanet.getOrbitalPeriodSolar());
            this.calculatePeriodService.save(target);
            return target;
        }
        else {
            return null;
        }
    }
}
