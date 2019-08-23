package vistas;

import java.awt.Point;
import modelos.CsvMaestros;
import modelos.GenCSV;
import tablas.MaestroftMateria;

/**
 *
 * @author Naomi
 */
public class JFrmUnirMaestros extends javax.swing.JFrame {

    private MaestroftMateria datos;
    private static int indice;
    
    public static int getIndice(){
        return indice;
    }
    
    /**
     * Creates new form JFrmProfesConAsig
     */
    public JFrmUnirMaestros() {
        initComponents();
        setLocationRelativeTo(null);
        this.incializarTabla();
    }
    
    private void incializarTabla(){
        datos = new MaestroftMateria();
        datos.tablaMaestroMateria(tableVerOpciones);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableVerOpciones = new javax.swing.JTable();
        jButtonTerminar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableVerOpciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableVerOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableVerOpcionesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableVerOpciones);

        jButtonTerminar.setText("Terminar");
        jButtonTerminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonTerminarMouseClicked(evt);
            }
        });

        label1.setText("Haga doble clic sobre los espacios sin nombre para asignarle maestro a una de las materias:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonTerminar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(label1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonTerminar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableVerOpcionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVerOpcionesMousePressed
        
        if (evt.getClickCount() == 2) {
            Point point = evt.getPoint();
            int row = tableVerOpciones.rowAtPoint(point);//fila y posisición en el Array
            int column = tableVerOpciones.columnAtPoint(point);//columna
            indice = row;
            this.dispose();
            JFrmMaestYMater.setTipoVentana(0);
            new JFrmMaestYMater().setVisible(true);
        }
        
    }//GEN-LAST:event_tableVerOpcionesMousePressed

    private void jButtonTerminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTerminarMouseClicked
        GenCSV csvProfes = new CsvMaestros();
        
        String[][] info;
        
        info = new String[JFrmStart.getListMaterias().size()][1];
        
        for(int a=0;a<JFrmStart.getListMaterias().size();a++){
            info[a][0] = JFrmStart.getListMaterias().get(a).getEducador().getName() + " da la materia: "
                    + JFrmStart.getListMaterias().get(a).getNombreAsignatura();
        }
        
        csvProfes.generaCSV(info);
        
        this.dispose();
        new JFrmUnirAlumnos().setVisible(true);
    }//GEN-LAST:event_jButtonTerminarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrmUnirMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmUnirMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmUnirMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmUnirMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmUnirMaestros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonTerminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JTable tableVerOpciones;
    // End of variables declaration//GEN-END:variables
}
