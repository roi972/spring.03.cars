package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CarsApplication implements CommandLineRunner {

	private CarService carService;

	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		carService.create(new Car("12-345-67", "Audi", ColorType.Black));
		carService.create(new Car("89-101-12", "Ferrari", ColorType.Red));
		carService.create(new Car("34-567-89", "Mercedes", ColorType.White));
		carService.create(new Car("10-112-13", "Porche", ColorType.Blue));
		carService.create(new Car("14-156-17", "Ford", ColorType.Black));

		Car car = carService.getCarByRegistration("89-101-12");
		System.err.println("Ferrari? " + car);

		List<Car> allCars = carService.getAllCars(2, 0);
		System.err.println("2 cars? - " + allCars.size() + "; " + allCars);

		List<Car> blackCars = carService.getAllCarsByColor(ColorType.Black, 2, 0);
		System.err.println("Black cars? - " + blackCars.size() + "; " +  blackCars);

		carService.deleteCar("14-156-17");

		List<Car> allCars2 = carService.getAllCars(10,0);
		System.err.println("4 cars? " + allCars2.size());

	}
}
