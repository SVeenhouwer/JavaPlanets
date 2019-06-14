package com.fun.planets.persistance;

import com.fun.planets.model.Monument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentRepository extends CrudRepository<Monument, Long> {
}
