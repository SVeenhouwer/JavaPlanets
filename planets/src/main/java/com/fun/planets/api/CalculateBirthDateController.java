package com.fun.planets.api;

import com.fun.planets.model.CalculateBirthDate;
import com.fun.planets.model.Planet;
import com.fun.planets.service.CalculateBirthDateService;
import com.fun.planets.service.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@RestController
@RequestMapping("api/calculateBirthDate")
@CrossOrigin(origins = "http://localhost:4200")
public class CalculateBirthDateController {

    private CalculateBirthDateService calculateBirthDateService;
    private PlanetService planetService;

    public CalculateBirthDateController(CalculateBirthDateService calculateBirthDateService, PlanetService planetService) {
        this.calculateBirthDateService = calculateBirthDateService;
        this.planetService = planetService;
    }

    @PostMapping
    public CalculateBirthDate create(@RequestBody CalculateBirthDate calculateBirthDate) {
        return this.calculateBirthDateService.save(calculateBirthDate);
    }

    @GetMapping
    public Iterable<CalculateBirthDate> list(){
        return this.calculateBirthDateService.findAll();
    }


    @GetMapping("{id}")
    public CalculateBirthDate get(@PathVariable long id) {
        Optional<CalculateBirthDate> optionalResult = this.calculateBirthDateService.findById(id);
        if (optionalResult.isPresent()) {
            CalculateBirthDate result = optionalResult.get();
            return result;
        } else {
            return null; // fix this later!
        }
    }

    @PutMapping("{calculateBirthDateId}/addPlanet/{planetId}")
    public CalculateBirthDate addPlanet(@PathVariable long calculateBirthDateId, @PathVariable long planetId, @RequestBody CalculateBirthDate input) {
        Optional<CalculateBirthDate> optionalCalculateBirthDate = this.calculateBirthDateService.findById(calculateBirthDateId);
        Optional<Planet> optionalPlanet = this.planetService.findById(planetId);
        if (optionalCalculateBirthDate.isPresent() && optionalPlanet.isPresent()) {
            (optionalCalculateBirthDate.get()).setPlanet(optionalPlanet.get());
            (optionalPlanet.get()).setCalculateBirthDate(optionalCalculateBirthDate.get());
            this.calculateBirthDateService.save(optionalCalculateBirthDate.get());
            this.planetService.save(optionalPlanet.get());
            return optionalCalculateBirthDate.get();
        }
        else {
            return null;
        }
    }

    @PutMapping("{id}")
    public CalculateBirthDate update(@PathVariable long id, @RequestBody CalculateBirthDate input) {
        Optional<CalculateBirthDate> optionalResult = this.calculateBirthDateService.findById(id);
        Optional<Planet> optionalPlanet = this.planetService.findById(id);
        if (optionalResult.isPresent() && optionalPlanet.isPresent()) {
            CalculateBirthDate targetCalculateBirthDate = optionalResult.get();
            Planet targetPlanet = optionalPlanet.get();
            targetCalculateBirthDate.setEnteredDate(input.getEnteredDate());
            targetCalculateBirthDate.setToday(LocalDate.now());
            targetCalculateBirthDate.setDatePeriod(Period.between(targetCalculateBirthDate.getToday(), targetCalculateBirthDate.getEnteredDate()));
            targetCalculateBirthDate.setDateDays(targetCalculateBirthDate.getToday().toEpochDay()-targetCalculateBirthDate.getEnteredDate().toEpochDay());
            System.out.println("EnteredDate: "+targetCalculateBirthDate.getEnteredDate()+", DatePeriod: "+targetCalculateBirthDate.getDatePeriod()+", DateDays: "+targetCalculateBirthDate.getDateDays());
            targetCalculateBirthDate.setCalculatedPlanetDays(targetCalculateBirthDate.getDateDays()/targetPlanet.getOrbitalPeriodAxis());
            targetCalculateBirthDate.setCalculatedPlanetYears(targetCalculateBirthDate.getDateDays()/targetPlanet.getOrbitalPeriodSolar());
            this.calculateBirthDateService.save(targetCalculateBirthDate);
            return targetCalculateBirthDate;
        } else {
            return null; // fix this later
        }
    }
}
