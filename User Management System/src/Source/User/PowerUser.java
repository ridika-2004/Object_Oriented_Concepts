package Source.User;

import Source.File.FileWrite;
import Source.File.FileReadUsercsv;

import java.util.Scanner;

public class PowerUser implements IPowerUser {
    private FileWrite fileWriter;
    private FileReadUsercsv fileReader;

    public PowerUser() {
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
}
