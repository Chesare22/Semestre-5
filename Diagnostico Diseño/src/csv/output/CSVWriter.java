package csv.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVWriter implements TableWriter {

    @Override
    public boolean write(String[][] info, String path) throws FileAlreadyExistsException {
        return write(info, path, false);
    }
    @Override
    public boolean write(String[][] table, String path, boolean replaceExisting) throws FileAlreadyExistsException {
        File file = new File(path);
        if(file.exists())
            if(replaceExisting){
                file.delete();
            }else{
                throw new FileAlreadyExistsException(path);
            }
        try{
            file.createNewFile();
            FileWriter output = new FileWriter(file);
            for(String[] array : table){
                output.write(toRow(array));
            }
            output.close();
            return true;
        }catch (IOException ex) {
            Logger.getLogger(CSVWriter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private static String toRow(String[] array){
        String row = "";
        for(int i = 0; i<array.length-1; i++){
            String field = "\"".concat(array[i]).concat("\",");
            row = row.concat(field);
        }
        String field = "\"".concat(array[array.length-1]).concat("\"").concat(System.lineSeparator());
        row = row.concat(field);
        return row;
    }

    
}
