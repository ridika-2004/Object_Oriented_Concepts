package Source.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWrite implements IPowerAccess {


    public void writeData(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine().trim();

        System.out.print("Enter User Type (Regular/Power/Admin): ");
        String userType = scanner.nextLine().trim();

        String userData = userId + "," + username + "," + email + "," + password + "," + userType;


        String userFile = "User.txt";
        saveToFile(userFile, userData);

        if ("admin".equalsIgnoreCase(userType)) {
            String adminFile = "Admin.txt";
            String adminData = userId + "," + username + "," + email;
            saveToFile(adminFile, adminData);
        }
    }

    private void saveToFile(String filename, String data) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.append(data + "\n");
            System.out.println("Data written successfully to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}

