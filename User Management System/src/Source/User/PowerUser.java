package Source.User;

import Source.File.WriteFile;

public class PowerUser extends User {

    public PowerUser(String username, String email, String password) throws DuplicateEntryException {
        super(username, email, password);
        this.userType = "Power";
    }

    @Override
    public void displayPrivileges() {
        System.out.println("Power User Privileges: Read and write access.");
    }


    @Override
    public void saveUserData(WriteFile writer) {
        writer.write("user.txt", this);
    }
}
