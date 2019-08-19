package views;

public class AlumnosMaestrosView extends javax.swing.JFrame {

    private AsignaturaMaestrosView otherPanel;

    /**
     * Creates new form AlumnosMaestrosView
     */
    public AlumnosMaestrosView() {
        initComponents();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        asignaturaMaestroTable = new javax.swing.JTable();
        csvButton = new javax.swing.JButton();
        studentsTeachersButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        asignaturaMaestroTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Matrícula", "Nombres", "Apellido 1", "Apellido 2", "Licenciatura", "Materias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(asignaturaMaestroTable);
        if (asignaturaMaestroTable.getColumnModel().getColumnCount() > 0) {
            asignaturaMaestroTable.getColumnModel().getColumn(0).setResizable(false);
            asignaturaMaestroTable.getColumnModel().getColumn(1).setResizable(false);
            asignaturaMaestroTable.getColumnModel().getColumn(2).setResizable(false);
            asignaturaMaestroTable.getColumnModel().getColumn(3).setResizable(false);
            asignaturaMaestroTable.getColumnModel().getColumn(4).setResizable(false);
            asignaturaMaestroTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jScrollPane2.setViewportView(jScrollPane1);

        csvButton.setText("Generar CSV");
        csvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csvButtonActionPerformed(evt);
            }
        });

        studentsTeachersButton.setText("Ir a asignaturas-maestros");
        studentsTeachersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsTeachersButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccionar materias por alumno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(csvButton)
                .addGap(95, 95, 95)
                .addComponent(studentsTeachersButton)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentsTeachersButton)
                    .addComponent(csvButton))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void csvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csvButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_csvButtonActionPerformed

    private void studentsTeachersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsTeachersButtonActionPerformed
        this.setVisible(false);
        otherPanel.setVisible(true);
        otherPanel.loadData();
    }//GEN-LAST:event_studentsTeachersButtonActionPerformed

    public void loadData() {
        System.out.println("Cargando datos");
    }
    public void setOtherPanel(AsignaturaMaestrosView otherPanel){
        this.otherPanel = otherPanel;
    }
    
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
            java.util.logging.Logger.getLogger(AlumnosMaestrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnosMaestrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnosMaestrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnosMaestrosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnosMaestrosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable asignaturaMaestroTable;
    private javax.swing.JButton csvButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton studentsTeachersButton;
    // End of variables declaration//GEN-END:variables
}
