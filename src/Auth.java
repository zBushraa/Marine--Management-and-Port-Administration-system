import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Auth {
    private String currentUser;
    private static final String USER_FILE = "data/users.txt";
    private static final String LOG_FILE = "data/activity.log";
    private Map<String, String> users;
    
    public Auth() {
        this.currentUser = null;
        this.users = new HashMap<>();
        initializeSystem();
    }
    
    private void initializeSystem() {
        createDataDirectory();
        loadUsers();
        logActivity("SYSTEM", "Application started");
    }
    
    private void createDataDirectory() {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
            System.out.println("Created data directory");
        }
    }
    
    private void loadUsers() {
        try {
            File userFile = new File(USER_FILE);
            if (!userFile.exists()) {
                createDefaultUsers();
                return;
            }
            
            Scanner fileScanner = new Scanner(userFile);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        users.put(parts[0], parts[1]);
                    }
                }
            }
            fileScanner.close();
            System.out.println("Loaded " + users.size() + " users from file");
            
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
            createDefaultUsers();
        }
    }
    
    private void createDefaultUsers() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE));
            writer.println("admin,admin123");
            writer.println("captain,captain123");
            writer.println("user,user123");
            writer.println("operator,operator123");
            writer.close();
            
            users.put("admin", "admin123");
            users.put("captain", "captain123");
            users.put("user", "user123");
            users.put("operator", "operator123");
            
            logActivity("SYSTEM", "Default users created");
            System.out.println("Created default users file");
            
        } catch (IOException e) {
            System.out.println("Error creating default users: " + e.getMessage());
        }
    }
    
    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            logActivity(username, "LOGIN_SUCCESS");
            System.out.println("Login successful! Welcome, " + username);
            return true;
        }
        logActivity(username, "LOGIN_FAILED");
        System.out.println("Login failed! Invalid username or password.");
        return false;
    }
    
    public void logout() {
        if (currentUser != null) {
            logActivity(currentUser, "LOGOUT");
            System.out.println("Goodbye, " + currentUser + "!");
            currentUser = null;
        }
    }
    
    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }
        
        if (username.length() < 3) {
            System.out.println("Username must be at least 3 characters!");
            return;
        }
        
        if (password.length() < 4) {
            System.out.println("Password must be at least 4 characters!");
            return;
        }
        
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE, true));
            writer.println(username + "," + password);
            writer.close();
            
            users.put(username, password);
            logActivity("SYSTEM", "USER_REGISTERED: " + username);
            System.out.println("Registration successful! Welcome, " + username);
            
        } catch (IOException e) {
            System.out.println("Error registering user: " + e.getMessage());
        }
    }
    
    private void logActivity(String user, String action) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true));
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.println(timestamp + " | " + user + " | " + action);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error logging activity: " + e.getMessage());
        }
    }
    
    public void showActivityLog() {
        try {
            File logFile = new File(LOG_FILE);
            if (!logFile.exists()) {
                System.out.println("No activity log found.");
                return;
            }
            
            System.out.println("\n=== ACTIVITY LOG ===");
            Scanner fileScanner = new Scanner(logFile);
            int count = 0;
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
                count++;
            }
            fileScanner.close();
            System.out.println("Total entries: " + count);
            System.out.println("===================");
            
        } catch (IOException e) {
            System.out.println("Error reading activity log: " + e.getMessage());
        }
    }
    
    public void showUsers() {
        System.out.println("\n=== REGISTERED USERS ===");
        for (String username : users.keySet()) {
            System.out.println("• " + username);
        }
        System.out.println("Total users: " + users.size());
        System.out.println("=======================");
    }
    
    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    public String getCurrentUser() {
        return currentUser;
    }
}