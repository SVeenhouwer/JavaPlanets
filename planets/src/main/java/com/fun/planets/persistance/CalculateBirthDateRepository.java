package com.fun.planets.persistance;

import com.fun.planets.model.CalculateBirthDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculateBirthDateRepository extends CrudRepository<CalculateBirthDate, Long> {
}
