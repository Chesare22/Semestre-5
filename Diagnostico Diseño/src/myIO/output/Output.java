package myIO.output;

import dataModels.DataModel;

public class Output {
    private final TableWriter writer = WriterFactory.getWriter();
    
    public boolean saveInTable(String path, DataModel[] data) throws ExistingFileException{
        String[][] info = new String[data.length][];
        for(int i=0; i<data.length; i++){
            info[i] = data[i].toArray();
        }
        return writer.write(info, path);
    }
}
