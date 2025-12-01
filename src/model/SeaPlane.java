package model;

public class SeaPlane extends Vehicle implements sailer {
    
    public SeaPlane(String name, String id) {
        super(name, id);
    }
    
    public void dock() {
        System.out.println("SeaPlane '" + name + "' Landing on water");
    }
    
    public void cruise() {
        System.out.println("SeaPlane '" + name + "' Flying over harbor");
    }
    
    public void startEngine() {
        System.out.println("SeaPlane '" + name + "' Starting engine");
    }
    
    public void stopEngine() {
        System.out.println("SeaPlane '" + name + " Stopping engine");
    }
    
    public void turn(String direction) {
        System.out.println("SeaPlane '" + name + "' Turning " + direction);
    }
}