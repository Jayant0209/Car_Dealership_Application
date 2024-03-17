package alloperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import entities.Car;
import entities.Customer;
import serviceimpl.CarServiceImpl;
import services.CarServices;

public class CustomerOperations {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	CarServices cs = new CarServiceImpl();
	
	public void getAllCars() {
        List<Car> cars = cs.getAllCars();
        if (!cars.isEmpty()) {
            System.out.println("List of Cars:");
            for (Car car : cars) {
                System.out.println(car);
            }
        } else {
            System.out.println("No cars found!");
        }
    }
	public void getCarsByBrand() throws IOException {
    	System.out.print("Enter the brand of the cars: ");
        String brand = reader.readLine();

        // Retrieve the list of cars by brand from the database using the carService
        List<Car> cars = cs.getCarsByBrand(brand);

        if (!cars.isEmpty()) {
            // Display the list of cars
            System.out.println("Cars with brand '" + brand + "':");
            for (Car car : cars) {
                System.out.println("ID: " + car.getId() +
                                   ", Brand: " + car.getBrand() +
                                   ", Model: " + car.getModel() +
                                   ", Year: " + car.getYear() +
                                   ", Price: " + car.getPrice());
                // If you have more attributes, you can display them here
            }
        } else {
            System.out.println("No cars found with brand '" + brand + "'.");
        }
    }
	public void getCarsByPriceRange() throws IOException {
	    System.out.print("Enter the minimum price: ");
	    double minPrice = Double.parseDouble(reader.readLine());

	    System.out.print("Enter the maximum price: ");
	    double maxPrice = Double.parseDouble(reader.readLine());

	    // Retrieve the list of cars by price range from the database using the carService
	    List<Car> cars = cs.getCarsByPriceRange(minPrice, maxPrice);

	    if (!cars.isEmpty()) {
	        // Display the list of cars
	        System.out.println("Cars within price range " + minPrice + " to " + maxPrice + ":");
	        for (Car car : cars) {
	            System.out.println("ID: " + car.getId() +
	                               ", Brand: " + car.getBrand() +
	                               ", Model: " + car.getModel() +
	                               ", Year: " + car.getYear() +
	                               ", Price: " + car.getPrice());
	            // If you have more attributes, you can display them here
	        }
	    } else {
	        System.out.println("No cars found within the specified price range.");
	    }
	}
	public void buyCar(Customer customer) throws IOException {
	    System.out.println("Enter the ID of the car you want to buy: ");
	    Long carId = Long.parseLong(reader.readLine());

	    // Retrieve the car from the database based on the provided ID
	    Car car = cs.getCarById(carId);

	    if (car != null) {
	        // Check if the car is available for sale
	        if (car.getCustomer() == null) {
	            // Update the car's status to indicate it has been sold
	            car.setCustomer(customer);

	            // Save the changes to the database
	            cs.updateCar(car);

	            System.out.println("Congratulations! You have successfully bought the car.");
	        } else {
	            System.out.println("Sorry, the car is already sold.");
	        }
	    } else {
	        System.out.println("Car with ID " + carId + " not found.");
	    }
	}


}
