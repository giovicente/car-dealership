package com.example.cardealership.passengercar;

import com.example.cardealership.vehicle.VehicleDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PassengerCarDTO extends VehicleDTO {

    private int doors;

    @JsonProperty("air_conditioning")
    private boolean hasAirConditioning;

    @JsonProperty("hydraulic_driving")
    private boolean hasHydraulicDriving;

}
