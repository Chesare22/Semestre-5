/*
 * Clase que genera el CSV de los alumnos
 */
package modelos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Naomi
 */
public class CsvAlumnos implements GenCSV{

    @Override
    public void generaCSV(String[][] informacion) {
        
        File archivoAlumnos;
        FileWriter escritor;
        PrintWriter linea;
        
        archivoAlumnos = new File("Alumnos_Inscritos.csv");
        
        if (!archivoAlumnos.exists()) {

            try {
                
                escritor = new FileWriter(archivoAlumnos, true);
                linea = new PrintWriter(escritor);
                
                for (int a = 0; a < informacion.length; a++) {
                    for (int b = 0; b < informacion[a].length; b++) {
                        linea.print(informacion[a][b]);
                    }
                    linea.println();
                }

                linea.close();
                escritor.close();
                
            } catch (IOException ex) {
                Logger.getLogger(CsvAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            
            try {
                
                escritor = new FileWriter(archivoAlumnos, true);
                linea = new PrintWriter(escritor);
                
                for (int a = 0; a < informacion.length; a++) {
                    for (int b = 0; b < informacion[a].length; b++) {
                        linea.print(informacion[a][b]);
                    }
                    linea.println();
                }

                linea.close();
                escritor.close();
                
            } catch (IOException ex) {
                Logger.getLogger(CsvAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
