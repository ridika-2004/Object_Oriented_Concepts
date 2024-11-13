package Source;

import Source.Dashboard.UserDashboard;
import Source.Dashboard.PowerDashboard;
import Source.Dashboard.AdminDashboard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your user type (r - Regular, p - Power, a - Admin) or 'exit' to quit: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("exit")) {
                System.out.println("Exiting the system.");
                break;
            }

            switch (choice) {
                case "r":
                    UserDashboard userDashboard = new UserDashboard();
                    userDashboard.display();
                    break;

                case "p":
                    PowerDashboard powerDashboard = new PowerDashboard();
                    powerDashboard.display();
                    break;

                case "a":
                    AdminDashboard adminDashboard = new AdminDashboard();
                    adminDashboard.display();
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 'r', 'p', 'a' or 'exit'.");
                    break;
            }
        }

        scanner.close();
    }
}
