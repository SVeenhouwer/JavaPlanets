package com.fun.planets.api;

import com.fun.planets.model.CalculateBirthDate;
import com.fun.planets.service.CalculateBirthDateService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@RestController
@RequestMapping("api/calculateBirthDate")
@CrossOrigin(origins = "http://localhost:4200")
public class CalculateBirthDateController {

    private CalculateBirthDateService calculateBirthDateService;

    public CalculateBirthDateController(CalculateBirthDateService calculateBirthDateService) {
        this.calculateBirthDateService = calculateBirthDateService;
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

    @PutMapping("{id}")
    public CalculateBirthDate update(@PathVariable long id, @RequestBody CalculateBirthDate input) {
        Optional<CalculateBirthDate> optionalResult = this.calculateBirthDateService.findById(id);
        if (optionalResult.isPresent()) {
            CalculateBirthDate target = optionalResult.get();
//            target.setEnteredDateString(input.getEnteredDateString());
            target.setEnteredDate(input.getEnteredDate());
            target.setToday(LocalDate.now());
            target.setDatePeriod(Period.between(target.getToday(), target.getEnteredDate()));
            target.setDateDays(target.getToday().toEpochDay()-target.getEnteredDate().toEpochDay());
            System.out.println("EnteredDate: "+target.getEnteredDate()+", DatePeriod: "+target.getDatePeriod()+", DateDays: "+target.getDateDays());

//            String enteredYears = enteredDateString.substring(0,4);
//            String enteredMonths = enteredDateString.substring(5,7);
//            String enteredDays = enteredDateString.substring(8);
//            LocalDate enteredDate = LocalDate.of(Integer.parseInt(enteredYears),Integer.parseInt(enteredMonths),Integer.parseInt(enteredDays));
//            System.out.println("The date entered from the Angular application of Planets as a String is: "+enteredDateString);
//            System.out.println("The separated parts of the entered date - Years: "+enteredYears+", Months: "+enteredMonths+", Days: "+enteredDays);
//            System.out.println("The LocalDate object created from these separated parts is: "+enteredDate);
//            optionalResult.get().setEnteredDate(enteredDate);
//            optionalResult.get().setDateDays(optionalResult.get().getToday().toEpochDay()-optionalResult.get().getEnteredDate().toEpochDay());
//            optionalResult.get().setDatePeriod(Period.between(optionalResult.get().getToday(),optionalResult.get().getEnteredDate()));
//            this.calculateBirthDateService.save(optionalResult.get());

            this.calculateBirthDateService.save(target);
            return target;
        } else {
            return null; // fix this later
        }
    }
}
