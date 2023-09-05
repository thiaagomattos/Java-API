package com.example.challenge3.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ROAD")
@Getter
@Setter
@AllArgsConstructor
public class Road {
    private String name;
    private String country;
    private Date date;
}
