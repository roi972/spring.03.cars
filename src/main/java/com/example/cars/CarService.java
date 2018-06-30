package com.example.cars;

import java.util.List;


public interface CarService {
    void create(Car car);
    void deleteCar(String registration);
    Car getCarByRegistration(String registration);
    List<Car> getAllCars(int size, int page);
    List<Car> getAllCarsByColor(ColorType colorType, int size, int page);

}
