package test;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileManagerTest {

    // Test for write method
    @Test
    public void testWrite() {
        IFileManager fileManager = new FileManager();
        String filename = "test.txt";
        String data = "Hello, World!";

        // Write to file
        fileManager.write(filename, data);

        // Verify that the file exists and content matches
        try {
            File file = new File(filename);
            assertTrue(file.exists());
            assertEquals(data, new String(java.nio.file.Files.readAllBytes(file.toPath())));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Write test failed due to exception");
        }
    }

    // Test for append method
    @Test
    public void testAppend() {
        IFileManager fileManager = new FileManager();
        String filename = "test.txt";
        String data = "Hello, World!";
        String appendedData = " Goodbye!";

        // Write initial data and append new data
        fileManager.write(filename, data);
        fileManager.append(filename, appendedData);

        // Verify the content is appended correctly
        try {
            String content = new String(java.nio.file.Files.readAllBytes(new File(filename).toPath()));
            assertTrue(content.contains(data) && content.contains(appendedData));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Append test failed due to exception");
        }
    }

    // Test for read method
    @Test
    public void testRead() {
        IFileManager fileManager = new FileManager();
        String filename = "test.txt";
        String data = "Hello, World!";

        // Write to file
        fileManager.write(filename, data);

        // Read the file and check its content
        String fileContent = fileManager.read(filename);
        assertEquals(data, fileContent);
    }

    // Test for delete method
    @Test
    public void testDelete() {
        IFileManager fileManager = new FileManager();
        String filename = "test.txt";
        String data = "Hello, World!";

        // Write data to file and then delete part of it
        fileManager.write(filename, data);
        fileManager.delete(filename, "World");

        // Verify the content is deleted
        try {
            String content = new String(java.nio.file.Files.readAllBytes(new File(filename).toPath()));
            assertFalse(content.contains("World"));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Delete test failed due to exception");
        }
    }

    // Test for search method
    @Test
    public void testSearch() {
        IFileManager fileManager = new FileManager();
        String filename = "test.txt";
        String data = "Hello, World!";

        // Write data to file
        fileManager.write(filename, data);

        // Search for "World" in the file
        String result = fileManager.search(filename, "World");
        assertNotNull(result);
        assertTrue(result.contains("World"));
    }
}