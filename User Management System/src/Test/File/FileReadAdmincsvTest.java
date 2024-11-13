package Test.File;

import Source.File.FileReadAdmincsv;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FileReadAdmincsvTest {

    @Test
    void testReadData() {
        FileReadAdmincsv fileReadAdmincsv = new FileReadAdmincsv();
        String filename = "Admin.csv";

        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("1,John,john@example.com\n");
            writer.write("2,Alice,alice@example.com\n");
            writer.close();

            fileReadAdmincsv.readData(filename);

            File file = new File(filename);
            if (file.exists()) {
                file.delete();
            }
        } catch (IOException e) {
            fail("An error occurred while writing test data: " + e.getMessage());
        }
    }
}
