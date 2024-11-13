package Source.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadUsercsv extends FileRead {

    @Override
    public void readData(String filename) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    String userId = data[0];
                    String username = data[1];
                    String email = data[2];
                    String userType = data[4];

                    System.out.println("UserID: " + userId);
                    System.out.println("Username: " + username);
                    System.out.println("Email: " + email);
                    System.out.println("UserType: " + userType);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Empty file: " + filename);
        }
    }
}
