package com.example.cardealership.vehicle;

import com.example.cardealership.enums.VehicleStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("vehicle_id")
    private long vehicleId;

    @JsonProperty("license_plate")
    @NotBlank
    @Column(unique = true, nullable = false)
    private String licensePlate;

    @NotBlank
    @Column(nullable = false)
    private String color;

    @NotBlank
    @Column(nullable = false)
    private String model;

    @NotBlank
    @Column(nullable = false)
    private String manufacturer;

    @NotNull
    @Column(nullable = false)
    private int year;

    @NotNull
    @Column(nullable = false)
    private double price;

    private VehicleStatus status;

}
