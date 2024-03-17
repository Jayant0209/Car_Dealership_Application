package services;

import entities.Car;

import java.util.List;

public interface CarServices {
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(long carId);
    Car getCarById(long carId);
    List<Car> getAllCars();
	List<Car> getCarsByBrand(String brand);
	List<Car> getCarsByPriceRange(double minPrice, double maxPrice);
}
