package com.example.cardealership.passengercar;

import com.example.cardealership.exception.ExceptionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@Api(value = "Maintain the passenger car category of vehicles.")
@RestController
@RequestMapping("/vehicles/passenger-cars")
public class PassengerCarRestController {

    @Autowired
    private PassengerCarService service;

    @ApiOperation(value = "Register a new vehicle of passenger car's category", response = PassengerCar.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "New passenger car registered with success", response = PassengerCar.class),
            @ApiResponse(code = 400, message = "This is an invalid passenger car", response = ExceptionResponse.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassengerCar registerPassengerCar(@Valid @RequestBody PassengerCarDTO newPassengerCar) {
        return service.save(newPassengerCar);
    }

    @ApiOperation(value = "Find a passenger car by its license plate", response = PassengerCar.class)
    @GetMapping("/{license_plate}")
    public PassengerCar getByLicensePlate(@PathVariable(name = "license_plate") String licensePlate) throws RuntimeException {
        try {
            return service.getByLicensePlate(licensePlate);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

}
