package com.example.challenge3.Repository;

import com.example.challenge3.Entity.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends MongoRepository<Cars, Long> {
}
