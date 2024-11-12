package Source;

import Source.File.UpdateFile;
import Source.User.RegularUser;
import Source.User.PowerUser;
import Source.User.AdminUser;
import Source.File.WriteFile;
import Source.File.ReadFile;
import Source.User.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws User.DuplicateEntryException {
        // Create instances of each user type
        RegularUser regularUser = new RegularUser("r", "r@gmail.com", "123");
        PowerUser powerUser = new PowerUser("p", "p@gmail.com", "123");
        AdminUser adminUser = new AdminUser("a", "a@gmail.com", "123");

        WriteFile writeFile = new WriteFile();
        ReadFile readFile = new ReadFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the option: ");
            System.out.println("r - Regular User/p - Power User/a - Admin User");
            System.out.println("Type 'exit' to quit.");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("exit")) {
                System.out.println("Exiting the system.");
                break;
            }

            switch (choice) {
                case "r":
                    regularUser.saveUserData(writeFile);  // Save Regular User data to file
                    readFile.read("user.txt");  // Read and display Regular User data from user.txt
                    break;

                case "p":
                    powerUser.saveUserData(writeFile);  // Save Power User data to power.txt
                    readFile.read("user.txt");  // Read and display Power User data from power.txt
                    break;

                case "a":
                    adminUser.saveUserData(writeFile);
                    UpdateFile updateFile = new UpdateFile();
                    updateFile.update("user.txt", 1);
                    adminUser.addUser(writeFile);// Save Admin User data to both files
                    readFile.read("user.txt");  // Read and display user data from user.txt
                    readFile.read("admin.txt");  // Read and display Admin User data from admin.txt
                    break;

                default:
                    System.out.println("Invalid choice. Please select 'r', 'p', 'a', or 'exit'.");
                    break;
            }
        }

        scanner.close();  // Close the scanner to prevent resource leak
    }
}
