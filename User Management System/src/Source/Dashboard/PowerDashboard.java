package Source.Dashboard;

import Source.File.FileRead;
import Source.File.FileReadUsercsv;
import Source.File.FileWrite;

import java.util.Scanner;

public class PowerDashboard {

    public void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Read File");
            System.out.println("2. Write File");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    read();
                    break;

                case 2:
                    writeFile(scanner);
                    break;

                case 3:
                    System.out.println("Exiting.........");
                    return;

                default:
                    System.out.println("Invalid choice!!");
                    break;
            }
        }
    }

    private void read() {
        FileRead fileReader = new FileReadUsercsv();
        String filename = "User.txt";
        fileReader.readData(filename);
    }

    private void writeFile(Scanner scanner) {
        FileWrite fileWrite = new FileWrite();
        System.out.print("Enter data to write: ");
        String data = scanner.nextLine().trim();
        String filename = "User.txt";
        fileWrite.writeData(scanner);
    }
}
