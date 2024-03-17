package alloperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import entities.Car;
import entities.Salesperson;
import serviceimpl.CarServiceImpl;
import serviceimpl.SalespersonServiceImpl;
import services.CarServices;
import services.SalespersonService;

public class SalespersonOperations {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	CarServices cs = new CarServiceImpl();
	SalespersonService sps = new SalespersonServiceImpl();
	/*---------------- Customer Want to add cars---------------------------*/
	public void addCar() throws IOException {
	    System.out.println("Enter car details:");
	    System.out.print("Brand: ");
	    String brand = reader.readLine();
	    System.out.print("Model: ");
	    String model = reader.readLine();
	    System.out.print("Year: ");
	    int year = Integer.parseInt(reader.readLine());
	    System.out.print("Price: ");
	    double price = Double.parseDouble(reader.readLine());
	    System.out.print("Salesperson ID: ");
	    int salespersonId = Integer.parseInt(reader.readLine());

	    Car car = new Car(brand, model, year, price);

	    // Retrieve the salesperson from the database using the provided ID
	    Salesperson salesperson = sps.getSalespersonById(salespersonId);
	    if (salesperson != null) {
	        car.setSalesperson(salesperson); // Set the salesperson for the car
	        cs.addCar(car); // Add the car to the database
	        System.out.println("Car added successfully!");
	    } else {
	        System.out.println("Invalid Salesperson ID! Car not added.");
	    }
	}

	
	public void updateCar() throws IOException {
		System.out.print("Enter car ID : ");
        long carId = Long.parseLong(reader.readLine());
        Car car = cs.getCarById(carId);
        if (car != null) {
            System.out.println("Enter new car details:");
            System.out.print("Brand: ");
            String brand = reader.readLine();
            System.out.print("Model: ");
            String model = reader.readLine();
            System.out.print("Year: ");
            int year = Integer.parseInt(reader.readLine());
            System.out.print("Price: ");
            double price = Double.parseDouble(reader.readLine());

            car.setBrand(brand);
            car.setModel(model);
            car.setYear(year);
            car.setPrice(price);

            cs.updateCar(car);
            System.out.println("Car updated successfully!");
        } else {
            System.out.println("Car not found!");
        }
    }
    
    public void deleteCar() throws IOException {
    	System.out.print("Enter car ID : ");
        long carId = Long.parseLong(reader.readLine());
        Car car = cs.getCarById(carId);
        if (car != null) {
            cs.deleteCar(carId);
            System.out.println("Car deleted successfully!");
        } else {
            System.out.println("Car not found!");
        }
    }
    public void displayAllCars() {
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
}
