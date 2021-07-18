package com.example.cardealership.utilityvehicle;

import com.example.cardealership.enums.TractionType;
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
public class UtilityVehicle extends Vehicle {

    @JsonProperty("traction_type")
    private TractionType tractionType;

    @JsonProperty("sunroof")
    private boolean hasSunroof;

    @JsonProperty("rim_diameter")
    private int rimDiameter;

}
