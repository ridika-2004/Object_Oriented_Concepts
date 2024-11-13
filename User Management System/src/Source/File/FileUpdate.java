package Source.File;

import java.io.*;
import java.util.*;

public class FileUpdate implements IAdminAccess {


    @Override
    public void updateUserDetails(String filename, int userId, String username, String email, String password, String userType) {
        File inputFile = new File(filename);
        File tempFile = new File("temp.txt");


        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean userUpdated = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[0]) == userId) {
                    line = userId + "," + username + "," + email + "," + password + "," + userType;
                    userUpdated = true;
                }
                writer.write(line);
                writer.newLine();
            }

            if (userUpdated) {
                inputFile.delete();
                tempFile.renameTo(inputFile);

            }
            else {
                System.out.println("User ID not found.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while updating user details: " + e.getMessage());
        }

        if ("admin".equalsIgnoreCase(userType)) {
            updateAdminFile(userId, username, email);
        }
    }

    private void updateAdminFile(int userId, String username, String email) {
        File adminFile = new File("Admin.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(adminFile, true))) {
            writer.write(userId + "," + username + "," + email);
            writer.newLine();
            System.out.println("Admin details updated in Admin.txt.");
        } catch (IOException e) {
            System.out.println("Error writing to Admin.txt: " + e.getMessage());
        }
    }



    @Override
    public void renameFile(String oldFilename, String newFilename) {
        File oldFile = new File(oldFilename);
        File newFile = new File(newFilename);

        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed to " + newFilename);
        } else {
            System.out.println("Failed to rename file.");
        }
    }
}
