package Source.User;

import Source.File.WriteFile;

public class RegularUser extends User {

    public RegularUser(String username, String email, String password) throws DuplicateEntryException {
        super(username, email, password);
        this.userType = "Regular";
    }

    @Override
    public void displayPrivileges() {
        System.out.println("Regular User Privileges: Read-only access.");
    }


    @Override
    public void saveUserData(WriteFile writer) {
        writer.write("user.txt", this);
    }
}
