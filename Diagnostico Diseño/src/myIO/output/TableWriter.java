package myIO.output;

public interface TableWriter {
    public abstract boolean write
            (String[][] info, String path, boolean replaceExisting)
                    throws ExistingFileException;
    public abstract boolean write
            (String[][] info, String path)
                    throws ExistingFileException;
}
