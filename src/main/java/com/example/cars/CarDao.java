package com.example.cars;

import java.util.List;

public interface CarDao {

    Car save(Car car);
    void delete(Car car);
    Car findOne(String registration);
    List<Car> findAll(int size, int page);
    List<Car> findAllCarsByColor(ColorType colorType, int size, int page);
}
