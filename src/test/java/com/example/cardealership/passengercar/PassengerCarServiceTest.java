package com.example.cardealership.passengercar;

import com.example.cardealership.enums.VehicleStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class PassengerCarServiceTest {

    @MockBean
    PassengerCarRepository repository;

    @Autowired
    PassengerCarService service;

    private PassengerCar passengerCar;

    @BeforeEach
    public void setUp() {
        passengerCar = new PassengerCar();
        passengerCar.setHasAirConditioning(true);
        passengerCar.setColor("Yellow");
        passengerCar.setDoors(2);
        passengerCar.setHasHydraulicDriving(true);
        passengerCar.setLicensePlate("DY5E367");
        passengerCar.setManufacturer("Chevrolet");
        passengerCar.setModel("Camaro");
        passengerCar.setPrice(108000);
        passengerCar.setYear(2019);
        passengerCar.setStatus(VehicleStatus.AVAIABLE);
    }

    @Test
    public void testPassengerCarInsertion() {
        Mockito.when(repository.save(passengerCar)).thenReturn(passengerCar);
        PassengerCar passengerCarTest = service.save(passengerCar);

        Assertions.assertSame(passengerCar, passengerCarTest);
    }

    @Test
    public void testGetByLicensePlateSuccess() throws RuntimeException {
        Mockito.when(repository.findOneByLicensePlateIgnoreCase(Mockito.anyString())).thenReturn(Optional.of(passengerCar));
        PassengerCar passengerCarTest = service.getByLicensePlate("DY5E367");

        Assertions.assertSame(passengerCar, passengerCarTest);
    }

    @Test
    public void testGetByLicensePlateFail() throws RuntimeException {
        Mockito.when(repository.findOneByLicensePlateIgnoreCase(Mockito.anyString())).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> { service.getByLicensePlate(Mockito.anyString()); });
    }

}
