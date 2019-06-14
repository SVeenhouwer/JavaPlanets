package com.fun.planets.service;

import com.fun.planets.model.Monument;
import com.fun.planets.persistance.MonumentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonumentService {

    private MonumentRepository monumentRepository;

    public MonumentService(MonumentRepository monumentRepository) {
        this.monumentRepository = monumentRepository;
    }

    public Monument save(Monument monument){
        return this.monumentRepository.save(monument);
    }

    public Optional<Monument> findById(Long aLong) {
        return monumentRepository.findById(aLong);
    }

    public Iterable<Monument> findAll() {
        return monumentRepository.findAll();
    }

    public void deleteById(Long aLong) {
        monumentRepository.deleteById(aLong);
    }
}
