package Source.File;

import java.io.*;
import java.util.*;

public class UpdateFile {

    // Method to update a specific user's details based on userId
    public void update(String fileName, int userId) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Open the file to read its content
            File inputFile = new File(fileName);
            File tempFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean userFound = false;

            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(","); // Assuming CSV format (UserId,Username,Email,Password,UserType)

                // If the current line corresponds to the given userId
                if (Integer.parseInt(userData[0]) == userId) {
                    userFound = true;
                    System.out.println("User found! Current details: ");
                    System.out.println("Username: " + userData[1]);
                    System.out.println("Email: " + userData[2]);
                    System.out.println("Password: " + userData[3]);
                    System.out.println("UserType: " + userData[4]);

                    System.out.println("\nEnter the detail you want to update:");
                    System.out.println("1. Username");
                    System.out.println("2. Email");
                    System.out.println("3. Password");
                    System.out.println("4. User Type");
                    System.out.print("Choose an option (1-4): ");
                    int option = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (option) {
                        case 1:
                            System.out.print("Enter new username: ");
                            userData[1] = scanner.nextLine();
                            break;
                        case 2:
                            System.out.print("Enter new email: ");
                            userData[2] = scanner.nextLine();
                            break;
                        case 3:
                            System.out.print("Enter new password: ");
                            userData[3] = scanner.nextLine();
                            break;
                        case 4:
                            System.out.print("Enter new user type (Regular/Power/Admin): ");
                            userData[4] = scanner.nextLine();
                            break;
                        default:
                            System.out.println("Invalid option.");
                            return; // Exit method if invalid option
                    }

                    // Write the updated user data to the temp file
                    writer.write(String.join(",", userData));
                    writer.newLine();
                } else {
                    // If not the correct userId, write the line as is
                    writer.write(line);
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();

            if (!userFound) {
                System.out.println("User with ID " + userId + " not found.");
            } else {
                // Replace the original file with the updated content
                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                    System.out.println("User details updated successfully!");
                } else {
                    System.out.println("Failed to delete the original file.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
