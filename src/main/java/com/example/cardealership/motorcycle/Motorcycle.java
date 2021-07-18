package com.example.cardealership.motorcycle;

import com.example.cardealership.enums.MotorcycleType;
import com.example.cardealership.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Motorcycle extends Vehicle {

    @JsonProperty("motorcycle_power")
    private int motorcyclePower;

    @JsonProperty("motorcycle_type")
    private MotorcycleType motorcycleType;

}
