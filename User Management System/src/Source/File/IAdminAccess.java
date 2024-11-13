package Source.File;

public interface IAdminAccess extends IPowerAccess {
    void updateUserDetails(String filename, int userId, String username, String email, String password, String userType);
    void renameFile(String oldFilename, String newFilename);
}
