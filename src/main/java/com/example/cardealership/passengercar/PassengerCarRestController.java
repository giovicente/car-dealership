package com.example.cardealership.passengercar;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Maintain the passenger car category of vehicles.")
@RestController
@RequestMapping("/vehicles/passenger-cars")
public class PassengerCarRestController {

    @Autowired
    private PassengerCarService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassengerCar registerPassengerCar(@Valid @RequestBody PassengerCarDTO newPassengerCar) {
        return service.save(newPassengerCar);
    }

}
