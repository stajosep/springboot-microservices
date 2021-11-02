package com.oracle.mongo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oracle.mongo.model.Car;

@Repository
public interface CarMongoRepository extends CrudRepository<Car, String> {


}
