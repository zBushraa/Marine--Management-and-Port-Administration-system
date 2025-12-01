import model.*;
import java.util.*;

public class Main {
    private static Auth auth = new Auth();
    private static Harbor harbor = new Harbor("Bushra International PORT");
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        showWelcome();
        
        while (true) {
            if (!auth.isLoggedIn()) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }
    
    private static void showWelcome() {
        System.out.println("    HARBOR MANAGEMENT SYSTEM");
        System.out.println("=================================");
    }
    
    private static void showLoginMenu() {
        System.out.println("\n--- LOGIN MENU ---");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. View Activity Log");
        System.out.println("4. View Users");
        System.out.println("5. Exit");
        System.out.print("Choose option: ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                handleLogin();
                break;
            case "2":
                handleRegister();
                break;
            case "3":
                auth.showActivityLog();
                break;
            case "4":
                auth.showUsers();
                break;
            case "5":
                System.out.println("Thank you for using Harbor System!");
                System.exit(0);
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    
    private static void handleLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        auth.login(username, password);
    }
    
    private static void handleRegister() {
        System.out.print("Choose Username: ");
        String username = scanner.nextLine();
        System.out.print("Choose Password: ");
        String password = scanner.nextLine();
        auth.register(username, password);
    }
    
    private static void showMainMenu() {
        System.out.println("\nMAIN MENU");
        System.out.println("Welcome, " + auth.getCurrentUser() + "!");
        System.out.println("1. Dock River Barge");
        System.out.println("2. Dock Sea Plane");
        System.out.println("3. Test River Barge");
        System.out.println("4. Test Sea Plane");
        System.out.println("5. Test Helicopter");
        System.out.println("6. Harbor Status");
        System.out.println("7. Activity Log");
        System.out.println("8. User List");
        System.out.println("9. Logout");
        System.out.print("Choose option: ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                dockRiverBarge();
                break;
            case "2":
                dockSeaPlane();
                break;
            case "3":
                testRiverBarge();
                break;
            case "4":
                testSeaPlane();
                break;
            case "5":
                testHelicopter();
                break;
            case "6":
                harbor.showHarborStatus();
                break;
            case "7":
                auth.showActivityLog();
                break;
            case "8":
                auth.showUsers();
                break;
            case "9":
                auth.logout();
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    
    private static void dockRiverBarge() {
        RiverBarge barge = new RiverBarge("Cargo Master", "RB001");
        harbor.givePermissionToDock(barge);
    }
    
    private static void dockSeaPlane() {
        SeaPlane seaPlane = new SeaPlane("Sky Cruiser", "SP001");
        harbor.givePermissionToDock(seaPlane);
    }
    
    private static void testRiverBarge() {
        RiverBarge barge = new RiverBarge("Test Barge", "RB002");
        harbor.testVehicle(barge);
    }
    
    private static void testSeaPlane() {
        SeaPlane seaPlane = new SeaPlane("Test Plane", "SP002");
        harbor.testVehicle(seaPlane);
    }
    
    private static void testHelicopter() {
        Helicopter helicopter = new Helicopter("Rescue One", "HC001");
        harbor.testVehicle(helicopter);
    }
}