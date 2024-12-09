package source.User;

public class Organizer extends AbsOrganizer {
    
    // Constructor to initialize Organizer
    public Organizer(String name, String email) {
        super(name, email);
    }

    // Implementing abstract methods from AbsOrganizer

    @Override
    public void createWorkshop(String title, String topic, String date, String speaker) {
        Workshop newWorkshop = new Workshop(title, topic, date, speaker, new FileManager());
        newWorkshop.saveToFile();
        System.out.println("Workshop created: " + title);
    }

    @Override
    public void editWorkshop(Workshop workshop, String title, String topic, String date, String speaker) {
        workshop.setTitle(title);
        workshop.setTopic(topic);
        workshop.setDate(date);
        workshop.setSpeaker(speaker);
        workshop.saveToFile();
        System.out.println("Workshop edited: " + title);
    }

    @Override
    public void deleteWorkshop(Workshop workshop) {
        // Deleting the workshop by removing its content from the file
        FileManager fileManager = new FileManager();
        fileManager.delete("workshop.txt");  // Here you can modify to delete specific data or implement a different method for deletion
        System.out.println("Workshop deleted: " + workshop.getTitle());
    }

    // Implementing abstract methods from User class

    @Override
    public void viewUpcomingWorkshops() {
        System.out.println("Viewing upcoming workshops...");
        // Code to display upcoming workshops
    }

    @Override
    public void displayProfile() {
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }

    @Override
    public void displayPastWorkshopEducationalResources() {
        System.out.println("Displaying past workshop educational resources...");
        // Code to display past workshop resources
    }

    @Override
    public void registerForWorkshop(Workshop workshop) {
        System.out.println("Registering for workshop: " + workshop.getTitle());
        // Code to register for a workshop
    }
}
