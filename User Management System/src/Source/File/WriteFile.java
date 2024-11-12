package Source.File;

import Source.User.User;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private int regularUserIdCounter = 1;
    private int powerUserIdCounter = 1;
    private int adminUserIdCounter = 1;

    public void write(String filename, User user) {
        int userId = 0;

        // Assign a unique user ID based on user type
        if (user.getUserType().equals("Regular")) {
            userId = regularUserIdCounter++;
        } else if (user.getUserType().equals("Power")) {
            userId = powerUserIdCounter++;
        } else if (user.getUserType().equals("Admin")) {
            userId = adminUserIdCounter++;
        }

        try (FileWriter writer = new FileWriter(filename, true)) {
            // If writing to Admin.txt, exclude the password
            if (filename.equals("admin.txt")) {
                writer.write(userId + "," + user.getUsername() + "," + user.getEmail() + "\n");
            } else {
                // Otherwise, write to user.txt with password
                writer.write(userId + "," + user.getUsername() + "," + user.getEmail() + "," + user.getPassword() + "," + user.getUserType() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
