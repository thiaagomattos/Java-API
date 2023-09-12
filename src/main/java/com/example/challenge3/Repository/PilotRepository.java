package com.example.challenge3.Repository;

import com.example.challenge3.Entity.Cars;
import com.example.challenge3.Entity.Pilot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PilotRepository extends MongoRepository<Cars, String> {
//    Optional<Pilot> findByName(String name);


}
