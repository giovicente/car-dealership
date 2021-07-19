package com.example.cardealership.passengercar;

import com.example.cardealership.enums.VehicleStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PassengerCarRestController.class)
public class PassengerCarRestControllerTest {

    @MockBean
    private PassengerCarService service;

    @Autowired
    private MockMvc mockMvc;

    PassengerCar passengerCar;

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
    public void testPassengerCarPost() throws Exception {
        Mockito.when(service.save(Mockito.any(PassengerCar.class))).then(passengerCar -> {
            this.passengerCar.setVehicleId((long) 1);
            return this.passengerCar;
        });

        ObjectMapper mapper = new ObjectMapper();
        String passengerCarJson = mapper.writeValueAsString(passengerCar);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/vehicles/passenger-cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(passengerCarJson))
                .andExpect(MockMvcResultMatchers.status().isCreated()
                );
    }

}
