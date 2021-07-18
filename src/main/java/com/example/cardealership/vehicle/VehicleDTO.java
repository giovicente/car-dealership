package com.example.cardealership.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    @JsonProperty("license_plate")
    @NotBlank
    private String licensePlate;

    @NotBlank
    private String color;

    @NotBlank
    private String model;

    @NotBlank
    private String manufacturer;

    @NotNull
    private int year;

    @NotNull
    private double price;

}