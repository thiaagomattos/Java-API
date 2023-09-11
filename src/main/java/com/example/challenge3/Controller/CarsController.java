package com.example.challenge3.Controller;

import com.example.challenge3.Dtos.CarsDtoRequest;
import com.example.challenge3.Dtos.CarsDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.example.challenge3.Service.CarsService;


@RestController
@RequestMapping("/ms-cars")
public class CarsController {

    private final CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @PostMapping("/")
    public CarsDtoResponse createCar(@RequestBody CarsDtoRequest carsDtoRequest) {
        return carsService.createCar(carsDtoRequest);
    }

    @GetMapping("/")
    public List<CarsDtoResponse> getAllCars() {
        return carsService.getAllCars();
    }

    @GetMapping("/{id}")
    public Optional<CarsDtoResponse> getCarById(@PathVariable String id) {
        return carsService.getCarById(id);
    }

    @PutMapping("/{id}")
    public CarsDtoResponse updateCar(@PathVariable String id, @RequestBody CarsDtoRequest carsDtoRequest) {
        return carsService.updateCar(id, carsDtoRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable String id) {
        carsService.deleteCar(id);
    }
}
