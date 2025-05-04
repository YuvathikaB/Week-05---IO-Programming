package org.example.practice;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Scanner;
class Car {
    private String brand;
    private String model;
    private int year;
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
}
public class CarJSON {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter car model: ");
        String model = sc.nextLine();
        System.out.print("Enter car year: ");
        int year = sc.nextInt();
        Car car = new Car(brand, model, year);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String carJson = objectMapper.writeValueAsString(car);
            System.out.println("Car as JSON: " + carJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

