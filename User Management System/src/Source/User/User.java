package Source.User;

import Source.File.WriteFile;
import java.util.HashSet;
import java.util.Set;

public abstract class User {

    protected String username;
    protected String email;
    protected String password;
    protected String userType;
    protected int userId;

    private static int userIdCounter = 1;


    private static Set<String> existingUsernames = new HashSet<>();
    private static Set<String> existingEmails = new HashSet<>();


    public static class DuplicateEntryException extends Exception {
        public DuplicateEntryException(String message) {
            super(message);
        }
    }

    public User(String username, String email, String password) throws DuplicateEntryException {
        if (existingUsernames.contains(username)) {
            throw new DuplicateEntryException("Username '" + username + "' is already taken. Please choose a different username.");
        }
        if (existingEmails.contains(email)) {
            throw new DuplicateEntryException("Email '" + email + "' is already registered. Please use a different email.");
        }


        this.userId = userIdCounter++;
        this.username = username;
        this.email = email;
        this.password = password;


        existingUsernames.add(username);
        existingEmails.add(email);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public int getUserId() {
        return userId;
    }


    public abstract void displayPrivileges();


    public abstract void saveUserData(WriteFile writer);
}
