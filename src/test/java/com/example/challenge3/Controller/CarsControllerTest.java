package com.example.challenge3.Controller;

import com.example.challenge3.Dtos.CarsDtoRequest;
import com.example.challenge3.Dtos.CarsDtoResponse;
import com.example.challenge3.Entity.Pilot;
import com.example.challenge3.Service.CarsService;
import com.example.challenge3.exceptions.CarNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CarsControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CarsController carsController;

    @Mock
    private CarsService carsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carsController).build();
    }

    @Test
    public void testCreateCar() throws Exception {
        CarsDtoRequest request = new CarsDtoRequest("Ford", "Ka", new Pilot("João Lucas", 32), new Date());
        CarsDtoResponse response = new CarsDtoResponse("1", "Ford", "Ka", new Pilot("João Lucas", 32), new Date());

        when(carsService.createCar(request)).thenReturn(response);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/ms-cars/")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        verify(carsService, times(1)).createCar(request);
    }

    @Test
    public void testGetAllCars() throws Exception {
        List<CarsDtoResponse> carsList = new ArrayList<>();
        carsList.add(new CarsDtoResponse("1", "Ford", "Ka", new Pilot("João Lucas", 32), new Date()));
        carsList.add(new CarsDtoResponse("2", "Honda", "Civic", new Pilot("Pedro Xavier", 25), new Date()));

        when(carsService.getAllCars()).thenReturn(carsList);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/ms-cars/")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        verify(carsService, times(1)).getAllCars();
    }

    @Test
    public void testGetCarById() throws Exception {
        String carId = "1";
        CarsDtoResponse response = new CarsDtoResponse(carId, "Ford", "Ka", new Pilot("João Lucas", 32), new Date());

        when(carsService.getCarById(carId)).thenReturn(Optional.of(response));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/ms-cars/{id}", carId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        verify(carsService, times(1)).getCarById(carId);
    }

    @Test
    public void testGetCarByIdNotFound() throws Exception {
        String carId = "999";

        when(carsService.getCarById(carId)).thenReturn(Optional.empty());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/ms-cars/{id}", carId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);

        verify(carsService, times(1)).getCarById(carId);
    }

    @Test
    public void testUpdateCar() throws Exception {
        String carId = "1";
        CarsDtoRequest request = new CarsDtoRequest("Ford", "Ka", new Pilot("João Lucas", 32), new Date());
        CarsDtoResponse response = new CarsDtoResponse(carId, "Ford", "Ka", new Pilot("João Lucas", 32), new Date());

        when(carsService.updateCar(carId, request)).thenReturn(response);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/ms-cars/{id}", carId)
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        verify(carsService, times(1)).updateCar(carId, request);
    }

    @Test
    public void testUpdateCarNotFound() throws Exception {
        String carId = "999";
        CarsDtoRequest request = new CarsDtoRequest("Ford", "Ka", new Pilot("João Lucas", 32), new Date());

        when(carsService.updateCar(carId, request)).thenThrow(new CarNotFoundException("Car not found"));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/ms-cars/{id}", carId)
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);

        verify(carsService, times(1)).updateCar(carId, request);
    }

    @Test
    public void testDeleteCar() throws Exception {
        String carId = "1";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/ms-cars/{id}", carId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        verify(carsService, times(1)).deleteCar(carId);
    }
}
