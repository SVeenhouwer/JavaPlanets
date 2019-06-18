package com.fun.planets.persistance;

import com.fun.planets.model.CalculatePeriod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatePeriodRepository extends CrudRepository<CalculatePeriod, Long> {
}
