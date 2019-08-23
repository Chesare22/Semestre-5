package tablas;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Asignatura;
import vistas.JFrmStart;

/**
 *
 * @author Naomi
 */
public class AlumnoftMateria {
    
    public void tablaMaestroMateria(JTable tabla){
        
        Vector<String> columnas = new Vector<>();
        Vector<Vector <Object> > datos = new Vector < >();
        
        columnas.add("Alumno");
        columnas.add("Materia(s)");
        
        for(int a=0;a<JFrmStart.getListAlumnos().size();a++){
            Vector<Object> row = new Vector<Object>();
            
            row.add(JFrmStart.getListAlumnos().get(a).getName() + " "
                    + JFrmStart.getListAlumnos().get(a).getApellidoP());
            
            if(JFrmStart.getListAlumnos().get(a).getListaMaterias() == null){
                row.add("Sin carga academica");
            }else{
                
                Asignatura[] materias = JFrmStart.getListAlumnos().get(a).getListaMaterias();
                String lista = "";
                
                for(int c=0;c<materias.length;c++){
                    lista += materias[c];
                }
                row.add(lista);
                
            }
            
            datos.add(row);
        }
        
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(datos, columnas);
        tabla.setModel(modelo);
    }
}
