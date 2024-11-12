package Source.User;

import Source.File.WriteFile;
import java.util.Scanner;

public class AdminUser extends User {

    public AdminUser(String username, String email, String password) throws DuplicateEntryException {
        super(username, email, password);
        this.userType = "Admin";
    }

    @Override
    public void displayPrivileges() {
        System.out.println("Admin User Privileges: Read and write access, modify system settings.");
    }


    @Override
    public void saveUserData(WriteFile writer) {
        writer.write("user.txt", this);
        writer.write("admin.txt", this);
    }


    public void addUser(WriteFile writer) throws DuplicateEntryException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of user to add (Regular, Power, Admin): ");
        String userType = scanner.nextLine().trim();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User newUser;

        if (userType.equalsIgnoreCase("Regular")) {
            newUser = new RegularUser(username, email, password);
        } else if (userType.equalsIgnoreCase("Power")) {
            newUser = new PowerUser(username, email, password);
        } else if (userType.equalsIgnoreCase("Admin")) {
            newUser = new AdminUser(username, email, password);
        } else {
            System.out.println("Invalid user type.");
            return;
        }

        writer.write(userType.equalsIgnoreCase("Admin") ? "admin.txt" : "user.txt", newUser);
        System.out.println(userType + " user added successfully!");
    }
}
