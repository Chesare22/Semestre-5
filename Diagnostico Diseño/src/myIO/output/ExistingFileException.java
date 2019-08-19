package myIO.output;

import java.nio.file.FileSystemException;

public class ExistingFileException extends FileSystemException{
    public ExistingFileException(String file){
        super(file);
    }
}
