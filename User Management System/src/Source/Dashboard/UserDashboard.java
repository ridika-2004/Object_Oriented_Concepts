package Source.Dashboard;

import Source.File.FileRead;
import Source.File.FileReadUsercsv;
import java.util.Scanner;

public class UserDashboard {

    public void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("User Dashboard");
            System.out.println("1. Read Data");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                read();
            } else if (choice == 2) {
                System.out.println("Exiting......");
                break;
            } else {
                System.out.println("Invalid choice!!");
            }
        }
    }

    private void read() {
        FileRead fileReader = new FileReadUsercsv();
        String filename = "User.txt";
        fileReader.readData(filename);
    }
}
