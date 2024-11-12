package Source.File;

import java.io.*;

public class ReadFile {

    public void read(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split each line by comma to get individual CSV fields
                String[] data = line.split(",");

                // Print each field (you can adjust how you print depending on your needs)
                System.out.println("UserID: " + data[0]);
                System.out.println("Username: " + data[1]);
                System.out.println("Email: " + data[2]);
                System.out.println("UserType: " + data[3]);
                System.out.println("-----------------------------");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public boolean isDuplicate(String fileName, String username, String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String existingUsername = data[1].trim();
                String existingEmail = data[2].trim();

                if (existingUsername.equals(username) || existingEmail.equals(email)) {
                    return true;  // Username or email already exists
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;  // No duplicate found
    }
}
