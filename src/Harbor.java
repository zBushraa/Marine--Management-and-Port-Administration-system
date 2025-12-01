import model.sailer;
import model.*;

public class Harbor {
    private String name;
    private int totalOperations;
    
    public Harbor(String name) {
        this.name = name;
        this.totalOperations = 0;
    }
    
    public void givePermissionToDock(sailer s) {
        totalOperations++;
        System.out.println("\n" + name + " Harbor - DOCKING PERMISSION #" + totalOperations);
        s.dock();
        System.out.println("Docking operation completed successfully!");
    }
    
    public void startCruise(sailer s) {
        totalOperations++;
        System.out.println("\n" + name + " Harbor - CRUISE PERMISSION #" + totalOperations);
        s.cruise();
        System.out.println("Cruise operation in progress...");
    }
    
    public void testVehicle(Vehicle vehicle) {
        totalOperations++;
        System.out.println("\n=== VEHICLE TEST #" + totalOperations + " ===");
        System.out.println("Testing: " + vehicle.getName() + " (" + vehicle.getId() + ")");
        
        vehicle.startEngine();
        
        if (vehicle instanceof sailer) {
            sailer sailer = (sailer) vehicle;
            startCruise(sailer);
            givePermissionToDock(sailer);
        } else {
            System.out.println("Performing Maneuver tests...");
            vehicle.turn("left");
            vehicle.turn("right");
            vehicle.turn("left");
        }
        
        vehicle.stopEngine();
        System.out.println("Vehicle test completed successfully!");
        System.out.println("=================================");
    }
    
    public void showHarborStatus() {
        System.out.println("\n=== HARBOR STATUS ===");
        System.out.println("Name: " + name);
        System.out.println("Total operations today: " + totalOperations);
        System.out.println("Status: OPERATIONAL");
        System.out.println("====================");
    }
}