package com.example.challenge3.Service;

import com.example.challenge3.Dtos.CarsDtoRequest;
import com.example.challenge3.Dtos.CarsDtoResponse;
import com.example.challenge3.Entity.Cars;
import com.example.challenge3.Entity.Pilot;
import com.example.challenge3.Repository.CarsRepository;
import com.example.challenge3.Repository.PilotRepository;
import com.example.challenge3.exceptions.CarNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarsServiceTest {

    @InjectMocks
    private CarsService carsService;

    @Mock
    private CarsRepository carsRepository;

    @Mock
    private PilotRepository pilotRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCars() {
        List<Cars> carsList = new ArrayList<>();
        carsList.add(new Cars("1", "Ford", "Ka", new Pilot("João Lucas", 32), new Date()));
        carsList.add(new Cars("2", "Honda", "Civic", new Pilot("Pedro Xavier", 25), new Date()));

        when(carsRepository.findAll()).thenReturn(carsList);

        List<CarsDtoResponse> result = carsService.getAllCars();

        verify(carsRepository, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetCarById() {
        Cars car = new Cars("1", "Ford", "Ka", new Pilot("João Lucas", 32), new Date());
        when(carsRepository.findById("1")).thenReturn(Optional.of(car));

        Optional<CarsDtoResponse> result = carsService.getCarById("1");

        verify(carsRepository, times(1)).findById("1");
        assertTrue(result.isPresent());
        assertEquals("Ka", result.get().getModel());
    }

    @Test
    public void testGetCarByIdNotFound() {
        when(carsRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> carsService.getCarById("1"));

        verify(carsRepository, times(1)).findById("1");
    }

    @Test
    public void testCreateCar() {
        CarsDtoRequest request = new CarsDtoRequest("Ford", "Ka", new Pilot("João Lucas", 32), new Date());
        Cars car = new Cars("1", "Ford", "Ka", new Pilot("João Lucas", 32), new Date());
        when(carsRepository.save(any())).thenReturn(car);

        CarsDtoResponse result = carsService.createCar(request);

        verify(carsRepository, times(1)).save(any());
        assertNotNull(result);
        assertEquals("Ford", result.getBrand());
    }

    @Test
    public void testUpdateCar() {
        String carId = "1";
        CarsDtoRequest request = new CarsDtoRequest("Ford", "Ka", new Pilot("João Lucas", 32), new Date());
        Cars existingCar = new Cars(carId, "Honda", "Civic", new Pilot("Pedro Xavier", 25), new Date());
        when(carsRepository.existsById(carId)).thenReturn(true);
        when(carsRepository.save(any())).thenReturn(existingCar);

        CarsDtoResponse result = carsService.updateCar(carId, request);

        verify(carsRepository, times(1)).existsById(carId);
        verify(carsRepository, times(1)).save(any());
        assertNotNull(result);
        assertEquals("Ford", result.getBrand());
    }

    @Test
    public void testUpdateCarNotFound() {
        String carId = "1";
        CarsDtoRequest request = new CarsDtoRequest("Ford", "Ka", new Pilot("João Lucas", 32), new Date());
        when(carsRepository.existsById(carId)).thenReturn(false);

        assertThrows(CarNotFoundException.class, () -> carsService.updateCar(carId, request));

        verify(carsRepository, times(1)).existsById(carId);
    }

    @Test
    public void testDeleteCar() {
        String result = carsService.deleteCar("1");

        verify(carsRepository, times(1)).deleteById("1");
        assertEquals("Car deleted!", result);
    }
}
