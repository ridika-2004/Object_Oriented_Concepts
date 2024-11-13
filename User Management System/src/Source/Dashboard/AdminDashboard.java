package Source.Dashboard;

import Source.File.FileRead;
import Source.File.FileReadUsercsv;
import Source.File.FileWrite;
import Source.File.FileUpdate;
import Source.File.IAdminAccess;

import java.util.Scanner;

public class AdminDashboard {

    private IAdminAccess adminAccess;

    public void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Dashboard");
            System.out.println("1. Read File");
            System.out.println("2. Write File");
            System.out.println("3. Add User");
            System.out.println("4. Update User");
            System.out.println("5. Modify File");
            System.out.println("6. Exit");
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
                    addUser(scanner);
                    break;

                case 4:
                    updateUser(scanner);
                    break;

                case 5:
                    modifyFile(scanner);
                    break;

                case 6:
                    System.out.println("Exiting Admin Dashboard.");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
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

    private void addUser(Scanner scanner) {
        writeFile(scanner);
    }

    private void updateUser(Scanner scanner) {
        FileUpdate fileUpdate = new FileUpdate();

        System.out.print("Enter User ID to update: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter new password: ");
        String password = scanner.nextLine().trim();

        System.out.print("Enter new user type (e.g., 'admin', 'regular'): ");
        String userType = scanner.nextLine().trim();

        String filename = "User.txt";
        fileUpdate.updateUserDetails(filename, userId, username, email, password, userType);
    }

    private void modifyFile(Scanner scanner)
    {
        FileUpdate fileUpdate = new FileUpdate();
        System.out.println("Which file to update? ");
        String oldfile = scanner.nextLine().trim();
        System.out.println("Enter new name of file: ");
        String newfile = scanner.nextLine().trim();
        fileUpdate.renameFile(oldfile, newfile);
    }

}
