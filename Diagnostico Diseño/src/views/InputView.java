package views;

import dataModels.Student;
import dataModels.Subject;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import csv.input.Input;
import store.Store;

public class InputView extends javax.swing.JFrame {
    private Store store = Store.getStore();
    private Input reader = new Input();

    public InputView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        studentsField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacherTableModel = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        teachersField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        StudentTableModel1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        subjectsField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        subjectTableModel = new javax.swing.JTable();
        okButton = new javax.swing.JButton();
        okButton.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Estudiantes:");

        studentsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("La tabla debe tener los siguientes campos en este orden:");

        teacherTableModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cve_Empleado", "Apellido1", "Apellido2", "Nombres"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(teacherTableModel);
        if (teacherTableModel.getColumnModel().getColumnCount() > 0) {
            teacherTableModel.getColumnModel().getColumn(0).setResizable(false);
            teacherTableModel.getColumnModel().getColumn(1).setResizable(false);
            teacherTableModel.getColumnModel().getColumn(2).setResizable(false);
            teacherTableModel.getColumnModel().getColumn(2).setHeaderValue("Apellido2");
            teacherTableModel.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel3.setText("Maestros");

        teachersField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teachersFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("La tabla debe tener los siguientes campos en este orden:");

        StudentTableModel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Matrícula", "Apellido1", "Apellido2", "Nombres", "Licenciatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(StudentTableModel1);
        if (StudentTableModel1.getColumnModel().getColumnCount() > 0) {
            StudentTableModel1.getColumnModel().getColumn(0).setResizable(false);
            StudentTableModel1.getColumnModel().getColumn(1).setResizable(false);
            StudentTableModel1.getColumnModel().getColumn(2).setResizable(false);
            StudentTableModel1.getColumnModel().getColumn(2).setHeaderValue("Apellido2");
            StudentTableModel1.getColumnModel().getColumn(3).setResizable(false);
            StudentTableModel1.getColumnModel().getColumn(4).setResizable(false);
            StudentTableModel1.getColumnModel().getColumn(4).setHeaderValue("Licenciatura");
        }

        jLabel5.setText("Asignaturas");

        subjectsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectsFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("La tabla debe tener los siguientes campos en este orden:");

        subjectTableModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cve_Asignatura", "Nombre", "Licenciatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(subjectTableModel);
        if (subjectTableModel.getColumnModel().getColumnCount() > 0) {
            subjectTableModel.getColumnModel().getColumn(0).setResizable(false);
            subjectTableModel.getColumnModel().getColumn(1).setResizable(false);
            subjectTableModel.getColumnModel().getColumn(2).setResizable(false);
        }

        okButton.setText("Listo");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(studentsField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(subjectsField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel3)
                        .addGap(39, 39, 39)
                        .addComponent(teachersField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(studentsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(teachersField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(subjectsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okButton)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showOkButtonIfReady() {
        if(store.inputDataIsReady())
            okButton.setVisible(true);
    }
    
    private void studentsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsFieldActionPerformed
        try {
            Student[] students = reader.students(studentsField.getText());
            store.setStudents(students);
            JOptionPane.showMessageDialog(this, "Estudiantes leídos correctamente");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Archivo no encontrado o formato incorrecto");
        }
        showOkButtonIfReady();
    }//GEN-LAST:event_studentsFieldActionPerformed

    private void teachersFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teachersFieldActionPerformed
        try {
            store.setTeachers(reader.teachers(teachersField.getText()));
            JOptionPane.showMessageDialog(this, "Maestros leídos correctamente");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Archivo no encontrado o formato incorrecto");
        }
        showOkButtonIfReady();
    }//GEN-LAST:event_teachersFieldActionPerformed

    private void subjectsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectsFieldActionPerformed
        try {
            // Alternative method for reading data
            Class<Subject> cls = (Class<Subject>) new Subject().getClass();
            Subject[] subjects = reader.tableToModel(subjectsField.getText(), cls);
            store.setSubjects(subjects);
            JOptionPane.showMessageDialog(this, "Asignaturas leídas correctamente");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Archivo no encontrado o formato incorrecto");
        }
        showOkButtonIfReady();
    }//GEN-LAST:event_subjectsFieldActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.setVisible(false);
        AsignaturaMaestrosView asignaturaMaestro = new AsignaturaMaestrosView();
        asignaturaMaestro.setVisible(true);
    }//GEN-LAST:event_okButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InputView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StudentTableModel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField studentsField;
    private javax.swing.JTable subjectTableModel;
    private javax.swing.JTextField subjectsField;
    private javax.swing.JTable teacherTableModel;
    private javax.swing.JTextField teachersField;
    // End of variables declaration//GEN-END:variables

}
