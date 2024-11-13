package Test.File;

import Source.File.FileWrite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.Scanner;

class FileWriteTest {

    @Test
    void testWriteDataAdminUser() {
        FileWrite fileWrite = new FileWrite();
        Scanner scanner = new Scanner("2\nAdmin User\nadmin@example.com\npassword\nadmin\n");
        fileWrite.writeData(scanner);

        File userFile = new File("User.txt");
        assertTrue(userFile.exists() && userFile.length() > 0);

        File adminFile = new File("Admin.txt");
        assertTrue(adminFile.exists() && adminFile.length() > 0);
    }
}
