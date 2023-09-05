package com.example.challenge3.Service;

import com.example.challenge3.Dtos.CarsDtoRequest;
import com.example.challenge3.Dtos.CarsDtoResponse;

import java.util.List;

public interface CarsService {
    CarsDtoResponse create(CarsDtoRequest request);

    List<CarsDtoResponse> getAll();
}
