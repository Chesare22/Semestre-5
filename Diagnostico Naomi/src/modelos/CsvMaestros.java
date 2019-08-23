/*
 * Clase que genera el CSV de los maestros
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
public class CsvMaestros implements GenCSV{

    @Override
    public void generaCSV(String[][] informacion) {
        
        File archivoMaestros;
        FileWriter escritor;
        PrintWriter linea;
        
        archivoMaestros = new File("Maestros_Materias.csv");
        
        if (!archivoMaestros.exists()) {

            try {
                
                escritor = new FileWriter(archivoMaestros, true);
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
                
                escritor = new FileWriter(archivoMaestros, true);
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
