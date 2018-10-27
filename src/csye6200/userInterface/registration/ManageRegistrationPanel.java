/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.userInterface.registration;

import com.google.common.collect.Lists;
import csye6200.entity.Registration;
import csye6200.service.RegisterService;
import csye6200.service.impl.RegisterServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ManageRegistrationPanel extends javax.swing.JPanel {

    private JPanel rightPanel;
    /**
     * Creates new form ManageRegistrationPanel
     */
    public ManageRegistrationPanel(JPanel rightPanel) {
        initComponents();
        this.rightPanel = rightPanel;
        populateTable(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPanel = new javax.swing.JScrollPane();
        registrationTable = new javax.swing.JTable();
        registrationTypeCombo = new javax.swing.JComboBox<>();

        setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Manage Registration");

        registrationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Student ID", "Registration Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPanel.setViewportView(registrationTable);

        registrationTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registered Students", "Unregistered Students" }));
        registrationTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrationTypeComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(registrationTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(registrationTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    /**
     * combo select
     * @param evt
     */
    private void registrationTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrationTypeComboActionPerformed
        // TODO add your handling code here:
        int i = registrationTypeCombo.getSelectedIndex();
        populateTable(i);
    }//GEN-LAST:event_registrationTypeComboActionPerformed

    public void populateTable(int type){

        int rowCount = registrationTable.getRowCount();

        DefaultTableModel model = (DefaultTableModel)registrationTable.getModel();

        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
        RegisterService reService = new RegisterServiceImpl();
        List<Registration> list;
        if(type == 0){
            list = reService.getAllRegistration();
        }else{
            List<String> unregisteredStudentsId = reService.getUnregisteredStudentsId();
            list = Lists.transform(unregisteredStudentsId,(x)->{
                Registration re = new Registration();
                re.setStudentId(x);
                re.setTimeDisplay("");
                return re;
            });
        }
        if(list == null || list.isEmpty()){
            return;
        }
        for(Registration f : list) {
            Object row[] = new Object[model.getColumnCount()];
            row[0] = f.getStudentId();
            row[1] = f.getTimeDisplay();
            model.addRow(row);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JTable registrationTable;
    private javax.swing.JComboBox<String> registrationTypeCombo;
    // End of variables declaration//GEN-END:variables
}
