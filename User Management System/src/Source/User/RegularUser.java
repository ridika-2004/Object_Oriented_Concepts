package Source.User;

import Source.File.FileReadUsercsv;

public class RegularUser implements IUser {
    private FileReadUsercsv fileReader;

    public RegularUser() {
        this.fileReader = new FileReadUsercsv();
    }

    @Override
    public void read() {
        String filename = "User.txt";
            fileReader.readData(filename);
    }
}
