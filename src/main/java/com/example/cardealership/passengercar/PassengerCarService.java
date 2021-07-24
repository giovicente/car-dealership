package com.example.cardealership.passengercar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerCarService {

    @Autowired
    private PassengerCarRepository repository;

    PassengerCar save(PassengerCarDTO passengerCarDTO) { return save(PassengerCar.of(passengerCarDTO)); }

    public PassengerCar save(PassengerCar newPassengerCar) { return repository.save(newPassengerCar); }

    public PassengerCar getByLicensePlate(String licensePlate) throws RuntimeException {
        return repository.findOneByLicensePlateIgnoreCase(licensePlate)
                .orElseThrow(RuntimeException::new);
    }

}
