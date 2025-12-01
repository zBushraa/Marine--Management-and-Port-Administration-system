package model;

public class RiverBarge extends Vehicle implements sailer {
    
    public RiverBarge(String name, String id) {
        super(name, id);
    }
    
    public void dock() {
        System.out.println("River Barge '" + name + "' docking at River port");
    }
    
    public void cruise() {
        System.out.println("RiverBarge '" + name + "' cruising on river");
    }
    
    public void startEngine() {
        System.out.println("RiverBarge '" + name + "' starting engine");
    }
    
    public void stopEngine() {
        System.out.println("RiverBarge '" + name + "' stopping engine");
    }
    
    public void turn(String direction) {
        System.out.println("RiverBarge '" + name + "' turning " + direction);
    }
}