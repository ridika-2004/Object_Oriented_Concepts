package Test.File;

import Source.File.FileUpdate;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FileUpdateTest {

    @Test
    void testUpdateUserDetailsSuccess() throws IOException {
        FileUpdate fileUpdate = new FileUpdate();
        String filename = "UserTest.txt";
        File file = new File(filename);
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("1,oldUser,oldEmail,oldPassword,Regular");
        writer.newLine();
        writer.close();

        fileUpdate.updateUserDetails(filename, 1, "newUser", "newEmail", "newPassword", "Regular");

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        assertTrue(line.contains("newUser"));
        reader.close();
    }
}
