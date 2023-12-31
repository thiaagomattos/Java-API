package com.example.challenge3.Repository;

import com.example.challenge3.Entity.Cars;
import com.example.challenge3.Entity.Pilot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CarsRepository extends MongoRepository<Cars, String> {
    Optional<Cars> findByBrandAndModel(String brand, String model);
    @Query("{ 'pilot.name': ?0}")
    Pilot findByName(String name);
}
