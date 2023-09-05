package com.example.challenge3.Controller;

import com.example.challenge3.Dtos.CarsDtoRequest;
import com.example.challenge3.Dtos.CarsDtoResponse;
import com.example.challenge3.Service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @PostMapping
    public ResponseEntity<CarsDtoResponse> create(CarsDtoRequest request) {
        return ResponseEntity.ok(carsService.create(request));

    }

    public ResponseEntity<List<CarsDtoResponse>> getAll(){
        return ResponseEntity.ok(carsService.getAll());
        }

    }

