package table.output;

import java.io.File;
import table.output.util.PDFFile;
import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;

public class PDFWriter implements TableWriter{
    private String[] header = new String[0];

    @Override
    public boolean write(String[][] info, String path, boolean replaceExisting) throws FileAlreadyExistsException {
        File file = new File(path);
        if(file.exists()){
            if(replaceExisting){
                file.delete();
            }else{
                throw new FileAlreadyExistsException(path);
            }
        }
        // Llenar el header en caso de no coincidir
        if(header.length != info[0].length){
            header = new String[info.length];
            Arrays.fill(header," - ");
        }
        
        PDFFile fileWriter = new PDFFile(path);
        // Escribir tabla.
        fileWriter.writeTable(info, header);
        // Guardar PDF.
        return fileWriter.save();
    }

    @Override
    public boolean write(String[][] info, String path) throws FileAlreadyExistsException {
        return write(info,path,false);
    }

    @Override
    public void setHeader(String[] header) {
        this.header = header;
    }
    
}
