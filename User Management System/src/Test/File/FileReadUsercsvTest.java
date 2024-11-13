package Test.File;

import Source.File.FileReadUsercsv;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FileReadUsercsvTest {

    @Test
    void testReadData() {
        FileReadUsercsv fileReadUsercsv = new FileReadUsercsv();
        String filename = "User.csv";

        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("1,John,john@example.com,password,regular\n");
            writer.write("2,Alice,alice@example.com,password,admin\n");
            writer.close();

            fileReadUsercsv.readData(filename);

            File file = new File(filename);
            if (file.exists()) {
                file.delete();
            }
        } catch (IOException e) {
            fail("An error occurred while writing test data: " + e.getMessage());
        }
    }
}
