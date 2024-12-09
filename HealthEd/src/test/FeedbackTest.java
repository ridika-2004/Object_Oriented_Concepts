package test;

import static org.junit.Assert.*;
import org.junit.Test;
import source.Feedback;

import java.io.File;
import java.io.IOException;

public class FeedbackTest {

    @Test
    public void testAddFeedback() throws IOException {
        // Initialize FileManager and Feedback
        IFileManager fileManager = new FileManager();
        Feedback feedback = new Feedback(fileManager);

        // Clean up the feedback file before the test to ensure a fresh start
        File file = new File("feedback.txt");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        String participantName = "Alice";
        String feedbackMessage = "Great workshop!";

        feedback.addFeedback(participantName, feedbackMessage);

        // Verify that the feedback is written to the file correctly
        String fileContent = fileManager.read("feedback.txt");
        assertNotNull("File content should not be null", fileContent);
        assertTrue("Feedback should be added to the file", fileContent.contains("Alice: Great workshop!"));
    }

    @Test
    public void testDisplayFeedback() throws IOException {
        // Initialize FileManager and Feedback
        IFileManager fileManager = new FileManager();
        Feedback feedback = new Feedback(fileManager);

        // Clean up the feedback file before the test to ensure a fresh start
        File file = new File("feedback.txt");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        // Add some feedback to the file
        feedback.addFeedback("Alice", "Great workshop!");
        feedback.addFeedback("Bob", "Informative session!");

        // Capture the output of displayFeedback method
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        // Call the method
        feedback.displayFeedback();

        // Check if the feedback is printed correctly
        String output = outputStream.toString().trim();
        //assertTrue(output.contains("Alice Great workshop!"));
        assertTrue(output.contains("Bob: Informative session!"));
    }

    @Test
    public void testDisplayFeedbackWhenNoFeedback() throws IOException {
        // Initialize FileManager and Feedback
        IFileManager fileManager = new FileManager();
        Feedback feedback = new Feedback(fileManager);

        // Ensure that no feedback is in the file
        File file = new File("feedback.txt");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        // Capture the output of displayFeedback method
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        // Call the method
        feedback.displayFeedback();

        // Check if the correct message is printed when there's no feedback
        String output = outputStream.toString().trim();
        assertEquals("No feedback available.", output);
    }
}