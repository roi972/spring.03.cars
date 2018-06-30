package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public void create(Car car) {
        carDao.save(car);
    }

    @Override
    @Transactional
    public void deleteCar(String registration) {
        Car carToDelete = getCarByRegistration(registration);
        if (carToDelete != null)
            carDao.delete(carToDelete);
    }

    @Override
    @Transactional(readOnly = true)
    public Car getCarByRegistration(String registration) {
        return carDao.findOne(registration);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> getAllCars(int size, int page) {
        return carDao.findAll(size,page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> getAllCarsByColor(ColorType colorType, int size, int page) {
        return carDao.findAllCarsByColor(colorType, size, page);
    }
}
