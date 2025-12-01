package model;

public class Helicopter extends Vehicle {
    
    public Helicopter(String name, String id) {
        super(name, id);
    }
    
    public void startEngine() {
        System.out.println("Helicopter '" + name + "' starting engine");
    }
    
    public void stopEngine() {
        System.out.println("Helicopter '" + name + "' stopping engine");
    }
    
    public void turn(String direction) {
        System.out.println("Helicopter '" + name + "' turning " + direction);
    }
}