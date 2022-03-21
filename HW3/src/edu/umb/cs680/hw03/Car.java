package edu.umb.cs680.hw03;

public class Car {
    
    private String make;
    private String model;
    private int mileage;
    private int year;
    private float price;
    
    public Car(String make, String model, int year, int mileage, float price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }
    
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getMileage() {
        return mileage;
    }
    public int getYear() {
        return year;
    }
    public float getPrice() {
        return price;
    } 
    
    public static void main(String[] args) {
        Car car = new Car("Audi","RS",2021,10,70000);
        System.out.println("Make :" +car.getMake());
        System.out.println("Model :" +car.getModel());
        System.out.println("Year :" +car.getYear());
        System.out.println("Mileage :" +car.getMileage());
        System.out.println("Price :" +car.getPrice());
        System.out.println("Car class has been implemented successfully");
    }
}
