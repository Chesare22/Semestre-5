package myIO.input;
import java.io.FileNotFoundException;

public interface TableReader {
    public abstract String[][]
        read(String path, int fields)
            throws FileNotFoundException;
}
