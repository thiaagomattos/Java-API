package com.example.challenge3.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cars {

    @Id
    private String id;
    private String brand;
    private String model;
    private Pilot pilot;
    private Date year;

}
