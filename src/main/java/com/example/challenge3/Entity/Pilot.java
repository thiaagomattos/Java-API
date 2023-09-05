package com.example.challenge3.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "PILOT")
@Getter
@Setter
@AllArgsConstructor
public class Pilot {

    private String name;
    private Integer age;
}
