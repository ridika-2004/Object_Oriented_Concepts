package source;

//import java.util.List;

public interface IWorkshop {
    // Attributes for the workshop
    String getTitle();
    String getTopic();
    String getDate();
    String getSpeaker();
    
    // Methods for managing attendees and educational resources
    void addParticipants(String participantName);
    void displayParticipants();
    void removeParticipants(String participantName);
    void addEducationalResources(String resource);
    void displayEducationalResources();
    void saveToFile();
    void loadFromFile();
}
