package com.fun.planets.api;

import com.fun.planets.model.Planet;
import com.fun.planets.service.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/planets")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping
    public Planet create(@RequestBody Planet planet) {
        return this.planetService.save(planet);
    }

    @GetMapping
    public Iterable<Planet> list(){
        return this.planetService.findAll();
    }

    @GetMapping("{id}")
    public Planet get(@PathVariable long id) {
        Optional<Planet> optionalResult = this.planetService.findById(id);
        if (optionalResult.isPresent()) {
            Planet result = optionalResult.get();
            return result;
        } else {
            return null; // fix this later!
        }
    }
}
