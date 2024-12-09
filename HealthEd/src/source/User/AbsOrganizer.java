package source.User;

public abstract class AbsOrganizer extends User {
    
    // Constructor to initialize AbsOrganizer
    public AbsOrganizer(String name, String email) {
        super(name, email);
    }

    // Abstract methods for managing workshops
    public abstract void createWorkshop(String title, String topic, String date, String speaker);
    public abstract void editWorkshop(Workshop workshop, String title, String topic, String date, String speaker);
    public abstract void deleteWorkshop(Workshop workshop);
}
