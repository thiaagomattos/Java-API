package com.example.challenge3.Service;

import com.example.challenge3.Dtos.CarsDtoRequest;
import com.example.challenge3.Dtos.CarsDtoResponse;
import com.example.challenge3.Entity.Cars;
import com.example.challenge3.Repository.CarsRepository;
import com.example.challenge3.exceptions.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarsService {

    private final CarsRepository carsRepository;

    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<CarsDtoResponse> getAllCars() {
        List<Cars> cars = carsRepository.findAll();
        return cars.stream()
                .map(this::convertToCarsDtoResponse)
                .collect(Collectors.toList());
    }

    public Optional<CarsDtoResponse> getCarById(Long id) {
        return carsRepository.findById(id)
                .map(this::convertToCarsDtoResponse);
    }

    public CarsDtoResponse createCar(CarsDtoRequest carsDtoRequest) {
        Cars car = convertToEntity(carsDtoRequest);
        Cars savedCar = carsRepository.save(car);
        return convertToCarsDtoResponse(savedCar);
    }

    public CarsDtoResponse updateCar(Long id, CarsDtoRequest carsDtoRequest) {
        if (carsRepository.existsById(id)) {
            Cars updatedCar = convertToEntity(carsDtoRequest);
            updatedCar.setId(id);
            Cars savedCar = carsRepository.save(updatedCar);
            return convertToCarsDtoResponse(savedCar);
        } else {
            throw new CarNotFoundException("Car not found with id: " + id);
        }
    }

    public void deleteCar(Long id) {
        carsRepository.deleteById(id);
    }

    private CarsDtoResponse convertToCarsDtoResponse(Cars car) {
        CarsDtoResponse carsDtoResponse = new CarsDtoResponse();
        carsDtoResponse.setId(car.getId());
        carsDtoResponse.setBrand(car.getBrand());
        carsDtoResponse.setModel(car.getModel());
        carsDtoResponse.setPilot(car.getPilot());
        carsDtoResponse.setDate(car.getDate());
        return carsDtoResponse;
    }

    private Cars convertToEntity(CarsDtoRequest carsDtoRequest) {
        Cars car = new Cars();
        car.setBrand(carsDtoRequest.getBrand());
        car.setModel(carsDtoRequest.getModel());
        car.setPilot(carsDtoRequest.getPilot());
        car.setDate(carsDtoRequest.getDate());
        return car;
    }
}
