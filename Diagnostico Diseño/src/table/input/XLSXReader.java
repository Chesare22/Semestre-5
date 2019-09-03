package table.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

// Apache poi stuff
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader implements TableReader{

    @Override
    public String[][] read(String path, int fields) throws FileNotFoundException {
        File file = new File(path);
        FileInputStream fileInput = new FileInputStream(file);
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(fileInput);
        } catch (IOException ex) {
            throw new FileNotFoundException();
        }
        
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        LinkedList<String[]> data = new LinkedList<>();
        
        while(rows.hasNext()){
            String[] row = new String[fields];
            Iterator<Cell> cells = rows.next().cellIterator();
            for(int i = 0; i<fields; i++){
                try{
                    row[i] = cells.next().toString();
                }catch(Exception ex){
                    throw new FileNotFoundException();
                }
            }
            data.add(row);
        }
        
        return data.toArray(new String[data.size()][]);
    }
    
}
