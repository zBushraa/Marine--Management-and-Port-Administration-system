package model;

public abstract class Vehicle {
    protected String name;
    protected String id;
    
    public Vehicle(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public abstract void startEngine();
    public abstract void stopEngine();
    public abstract void turn(String direction);
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
    
    public void displayInfo() {
        System.out.println("Vehicle: " + name + " (ID: " + id + ")");
    }
}