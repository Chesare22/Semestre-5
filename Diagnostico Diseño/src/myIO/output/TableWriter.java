package myIO.output;

import java.nio.file.FileAlreadyExistsException;

public interface TableWriter {
    public abstract boolean write
            (String[][] info, String path, boolean replaceExisting)
                    throws FileAlreadyExistsException;
    public abstract boolean write
            (String[][] info, String path)
                    throws FileAlreadyExistsException;
}
