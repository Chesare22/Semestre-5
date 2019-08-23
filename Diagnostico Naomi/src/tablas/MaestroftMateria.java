package tablas;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vistas.JFrmStart;
import vistas.JFrmMaestYMater;

/**
 *
 * @author Naomi
 */
public class MaestroftMateria {
    
    public void tablaMaestroMateria(JTable tabla){
        
        Vector<String> columnas = new Vector<>();
        Vector<Vector <Object> > datos = new Vector < >();
        
        columnas.add("Profesor");
        columnas.add("Asignatura");
        
        for(int a=0;a<JFrmStart.getListMaterias().size();a++){
            Vector<Object> row = new Vector<Object>();
            
            if(JFrmStart.getListMaterias().get(a).isHaveTeacher()){
//                row.add(JFrmStart.getListMaterias().get(JFrmMaestYMater.getNoMAestro()).getEducador().getName() 
//                + " " + JFrmStart.getListMaterias().get(JFrmMaestYMater.getNoMAestro()).getEducador().getApellidoP());
                row.add(JFrmStart.getListMaestros().get(JFrmMaestYMater.getNoMAestro()).getName() 
                        + " " + JFrmStart.getListMaestros().get(JFrmMaestYMater.getNoMAestro()).getApellidoP());
            }else{
                row.add("No tiene maestr@ asignada");
            }
            
            row.add(JFrmStart.getListMaterias().get(a).getNombreAsignatura());
            
            datos.add(row);
        }
        
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(datos, columnas);
        tabla.setModel(modelo);
        JFrmMaestYMater.setNoMaestro(0);

    }
}
//C:\Users\Naomi\OneDrive\Documents\Arqui Software\U1\Diagnostico