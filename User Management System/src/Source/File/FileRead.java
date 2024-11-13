package Source.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileRead implements IUserAccess {

    public abstract void readData(String filename);
}
