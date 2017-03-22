package com.example.repository;

import com.example.domain.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shaurav on 3/17/2017.
 */
public interface CarMongoRepository extends CrudRepository<Car, String>{
}
