/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class Car {

    private String carId;
    private String make;
    private String model;
    private boolean isAvailable;

    public Car(String carId, String make, String model) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car ID: " + carId + ", Make: " + make + ", Model: " + model + ", Available: " + isAvailable;
    }




    static class Customer {
    private String customerId;
    private String name;
    private String email;

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Email: " + email;
    }
}

static class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;
    private Car[] carArray;
    private int carCount;
            

  void RentalAgency() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        carArray = new Car[100];
        carCount = 0;
    }

    public void addCar(Car car) {
        cars.add(car);
        addCarToArray(car);
    }
     private void addCarToArray(Car car) {
        if (carCount < carArray.length) {
            carArray[carCount++] = car;
            System.out.println("Car added to array at position " + (carCount - 1));
        } else {
            System.out.println("Car array is full. Cannot add more cars.");
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(String carId, String customerId) {
        Car car = findCarById(carId);
        Customer customer = findCustomerById(customerId);
        if (car != null && customer != null) {
            if (car.isAvailable()) {
                car.setAvailable(false);
                System.out.println("Car " + carId + " rented to " + customerId);
            } else {
                System.out.println("Car is already rented.");
            }
        } else {
            System.out.println("Invalid car or customer ID.");
        }
    }

    private Car findCarById(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equalsIgnoreCase(carId)) {
                return car;
            }
        }
        return null;
    }

    private Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equalsIgnoreCase(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void displayCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RentalAgency agency = new RentalAgency();
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Car Rental System ===");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Car");
            System.out.println("4. View Cars");
            System.out.println("5. View Customers");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Car ID: ");
                    String carId = input.nextLine();
                    System.out.print("Enter Make: ");
                    String make = input.nextLine();
                    System.out.print("Enter Model: ");
                    String model = input.nextLine();
                    agency.addCar(new Car(carId, make, model));
                    break;
                case 2:
                    System.out.print("Enter Customer ID: ");
                    String custId = input.nextLine();
                    System.out.print("Enter Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Email: ");
                    String email = input.nextLine();
                    agency.addCustomer(new Customer(custId, name, email));
                    break;
                case 3:
                    System.out.print("Enter Car ID to Rent: ");
                    String carToRent = input.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String customerId = input.nextLine();
                    agency.rentCar(carToRent, customerId);
                    break;
                case 4:
                    agency.displayCars();
                    break;
                case 5:
                    agency.displayCustomers();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        input.close();
    }
}
    
    


