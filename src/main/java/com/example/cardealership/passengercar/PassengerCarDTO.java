package com.example.cardealership.passengercar;

import com.example.cardealership.vehicle.VehicleDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PassengerCarDTO extends VehicleDTO {

    @NotNull
    private int doors;

    @JsonProperty("air_conditioning")
    @NotNull
    private boolean hasAirConditioning;

    @JsonProperty("hydraulic_driving")
    @NotNull
    private boolean hasHydraulicDriving;

}
