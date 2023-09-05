package com.example.challenge3.Dtos;

import com.example.challenge3.Entity.Pilot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarsDtoResponse {
    private Long id;
    private String brand;
    private String model;
    private Pilot pilot;
    private Date date;
}
