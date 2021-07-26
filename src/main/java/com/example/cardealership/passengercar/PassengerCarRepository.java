package com.example.cardealership.passengercar;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PassengerCarRepository extends CrudRepository<PassengerCar, Long> {
    Optional<PassengerCar> findOneByLicensePlateIgnoreCase(String licensePLate);
    Iterable<PassengerCar> findAllByManufacturerOrModel(String manufacturer, String model);
}
