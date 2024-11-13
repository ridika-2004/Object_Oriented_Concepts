package Source.User;

import Source.File.FileReadUsercsv;
import Source.File.FileUpdate;
import Source.File.FileWrite;

import java.util.Scanner;

public class AdminUser implements IAdminUser {
    private FileUpdate fileUpdater;
    private FileWrite fileWriter;
    private FileReadUsercsv fileReader;

    public AdminUser() {
        this.fileUpdater = new FileUpdate();
        this.fileWriter = new FileWrite();
        this.fileReader = new FileReadUsercsv();
    }

    @Override
    public void read() {
        String filename = "User.txt";

            fileReader.readData(filename);
    }

    @Override
    public void write(Scanner scanner) {
        fileWriter.writeData(scanner);
    }

    @Override
    public void updateUserDetails(String filename, int userId, String username, String email, String password, String userType) {
        fileUpdater.updateUserDetails(filename, userId,username, email, password, userType);
    }

    @Override
    public void renameFile(String oldFilename, String newFilename) {
        fileUpdater.renameFile(oldFilename, newFilename);
    }
}
