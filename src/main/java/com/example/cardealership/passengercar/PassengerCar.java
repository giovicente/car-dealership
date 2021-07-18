package com.example.cardealership.passengercar;

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
public class PassengerCar extends Vehicle {

    private int doors;

    @JsonProperty("air_conditioning")
    private boolean hasAirConditioning;

    @JsonProperty("hydraulic_driving")
    private boolean hasHydraulicDriving;

    public static PassengerCar of(PassengerCarDTO passengerCarDTO) {
        PassengerCar passengerCar = new PassengerCar();
        passengerCar.setLicensePlate(passengerCarDTO.getLicensePlate());
        passengerCar.setColor(passengerCarDTO.getColor());
        passengerCar.setModel(passengerCarDTO.getModel());
        passengerCar.setManufacturer(passengerCarDTO.getManufacturer());
        passengerCar.setYear(passengerCarDTO.getYear());
        passengerCar.setPrice(passengerCarDTO.getPrice());
        passengerCar.setStatus(passengerCarDTO.getStatus());
        passengerCar.setHasAirConditioning(passengerCarDTO.isHasAirConditioning());
        passengerCar.setHasHydraulicDriving(passengerCarDTO.isHasHydraulicDriving());
        return passengerCar;
    }
}
