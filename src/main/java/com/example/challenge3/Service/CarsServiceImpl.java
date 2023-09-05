package com.example.challenge3.Service;

import com.example.challenge3.Dtos.CarsDtoRequest;
import com.example.challenge3.Dtos.CarsDtoResponse;
import com.example.challenge3.Entity.Cars;
import com.example.challenge3.Repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarsServiceImpl implements CarsService{

    @Autowired
    private CarsRepository carsRepository;

    @Override
    public CarsDtoResponse create(CarsDtoRequest request) {
        Cars car = new Cars();
        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        car.setPilot(request.getPilot());
        car.setDate(request.getDate());

        carsRepository.save(car);

        return createResponse(car);
    }

    @Override
    public List<CarsDtoResponse> getAll() {
        List<CarsDtoResponse> responses = new ArrayList<>();

        List<Cars> cars = carsRepository.findAll();

        if(!cars.isEmpty()){
            cars.forEach(car -> responses.add(createResponse(car)));
        }

        for(Cars car : cars){
            responses.add(createResponse(car));
        }

        return responses;
    }
    private CarsDtoResponse createResponse(Cars car) {
        CarsDtoResponse response = new CarsDtoResponse();
        response.setBrand(car.getBrand());
        response.setModel(car.getModel());
        response.setPilot(car.getPilot());
        response.setDate(car.getDate());

        return response;
    }


}
