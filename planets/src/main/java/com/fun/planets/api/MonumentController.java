package com.fun.planets.api;

import com.fun.planets.model.Monument;
import com.fun.planets.service.MonumentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@RestController
@RequestMapping("api/monuments")
@CrossOrigin(origins = "http://localhost:4200")
public class MonumentController {

    private MonumentService monumentService;

    public MonumentController(MonumentService monumentService) {
        this.monumentService = monumentService;
    }

    @PostMapping
    public Monument create(@RequestBody Monument monument) {
        return this.monumentService.save(monument);
    }

    @GetMapping
    public Iterable<Monument> list(){
        return this.monumentService.findAll();
    }

    @GetMapping("{id}")
    public Monument get(@PathVariable long id) {
        Optional<Monument> optionalResult = this.monumentService.findById(id);
        if (optionalResult.isPresent()) {
            Monument result = optionalResult.get();
            return result;
        } else {
            return null; // fix this later!
        }
    }

    @PutMapping("{id}")
    public Monument update(@PathVariable long id, @RequestBody Monument input) {
        Optional<Monument> optionalResult = this.monumentService.findById(id);
        if (optionalResult.isPresent()) {
            Monument target = optionalResult.get();
//            target.setName(input.getName());
            target.setToday(LocalDate.now());
            target.setBuildDate(input.getBuildDate());
            target.setBuildDateString(input.getBuildDateString());
            target.setAgePeriod(Period.between(target.getBuildDate(),target.getToday()));
            target.setAgePeriodString(target.getAgePeriod().getYears()+" years, "+target.getAgePeriod().getMonths()+" months, "+target.getAgePeriod().getDays()+" days.");
            target.setAgeDays(ChronoUnit.DAYS.between(target.getBuildDate(),target.getToday()));
            this.monumentService.save(target);
            return target;
        } else {
            return null; // fix this later
        }
    }
}
