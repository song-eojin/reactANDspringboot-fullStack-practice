package com.eojin.fullstack.domain;

import com.eojin.fullstack.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
