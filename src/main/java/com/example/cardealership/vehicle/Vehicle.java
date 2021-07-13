package com.example.cardealership.vehicle;

import com.example.cardealership.enums.VehicleStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("license_plate")
    @NotBlank
    @Column(nullable = false)
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

    @JsonProperty("status")
    private VehicleStatus status;

}
