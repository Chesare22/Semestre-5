package modelos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Naomi
 */
public class readCsv {
    
    private String filePath;

    public readCsv(String fileName) {
        this.filePath = fileName;
    }

    public String getFilePath() {
        return filePath;
    }
    
    public String[][] leeCsv() throws FileNotFoundException, IOException {

        String[][] info;//arreglo para almacenar la información

        int fields;

        Scanner inputFirstPass = new Scanner(Paths.get(filePath));
        Scanner inputSecondPass = new Scanner(Paths.get(filePath));
        
        fields = 0;//instanciamos la variable just antes de usarla para no ocupar espacio de memoria
        while (inputFirstPass.hasNext()) {
            ++fields;
            inputFirstPass.nextLine();
        }

        info = new String[fields][];
        for (int i = 0; i < fields; i++) {
            info[i] = inputSecondPass.nextLine().split(",");
        }
        
//        for(int a=0;a<info.length;a++){
//            System.out.println(" " + info[a][0]);
////            for(int b=0;b<info[a].length;b++){
////                System.out.println("  " + info[a][b]);
////            }
//        }

        return info;
    }
//    
//    public static void main(String[] args) throws IOException{
//        
//        readCsv lee = new readCsv("C:\\Users\\Naomi\\OneDrive\\Documents\\Arqui Software\\U1\\Diagnostico\\Alumnos.csv");
//        
//        lee.leeCsv();
//        
//    }
    
}
