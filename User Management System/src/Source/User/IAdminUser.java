package Source.User;

import Source.File.FileUpdate;

import java.util.Scanner;

public interface IAdminUser extends IPowerUser {

    void write(Scanner scanner);

    void updateUserDetails(String filename, int userId, String username, String email, String password, String userType);

    void renameFile(String oldFilename, String newFilename);
}
