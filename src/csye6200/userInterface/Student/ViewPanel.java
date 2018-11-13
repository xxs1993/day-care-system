/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.userInterface.Student;

import com.google.common.base.Strings;
import csye6200.entity.Registration;
import csye6200.entity.Student;
import csye6200.service.StudentService;
import csye6200.service.RegisterService;
import csye6200.service.impl.RegisterServiceImpl;
import csye6200.userInterface.DetailPanel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author jinyimu
 */
public class ViewPanel extends DetailPanel {
    JPanel RightPanel;
    StudentService studentService;
    Student student;
    RegisterService registerService;
    /**
     * Creates new form ViewPanel
     */
    public ViewPanel(JPanel rp,StudentService ss,Student stu) {
        initComponents();
        student = stu;
        RightPanel =rp;
        studentService = ss;
        registerService = new RegisterServiceImpl();
        
        txtID.setText(stu.getId());
        txtFirstName.setText(Strings.nullToEmpty(stu.getfName()));
        txtLastName.setText(Strings.nullToEmpty(stu.getlName()));
        genderCombo.setSelectedItem(Strings.nullToEmpty(stu.getGender()));
        txtAge.setText(stu.getAge()+"");
        txtFatherName.setText(Strings.nullToEmpty(stu.getFatherName()));
        txtMotherName.setText(Strings.nullToEmpty(stu.getMotherName()));
        populateRegisterTable();
//        txtAgeRange.setText(t.getAgeRange()+"");
        //txtAge.setText(t.getAge());
        
    }
    
    

    public void populateRegisterTable() {
        
        int rowCount = registerTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) registerTable.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
        List<Registration> reg = registerService.getRegistrationRecordsByStudentId(student.getId());
        if(reg == null || reg.isEmpty()) return;
        for ( Registration r : reg) {
            Object row[] = new Object[model.getColumnCount()];
            row[0] = r.getTimeDisplay();
            model.addRow(row);
        }
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFatherName = new javax.swing.JTextField();
        txtMotherName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        genderCombo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        registerTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        jLabel2.setText("First Name:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel3.setText("First Name:");

        jLabel4.setText("Last Name:");

        jLabel5.setText("Gender:");

        jLabel7.setText("Age:");

        txtFirstName.setEditable(false);

        txtLastName.setEditable(false);

        txtAge.setEditable(false);
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        jLabel8.setText("Father name:");

        jLabel9.setText("Mother name:");

        txtFatherName.setEditable(false);
        txtFatherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFatherNameActionPerformed(evt);
            }
        });

        txtMotherName.setEditable(false);

        btnBack.setText("<<Back  ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "female", "male" }));
        genderCombo.setEnabled(false);

        registerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Registration Time"
            }
        ));
        registerTable.setEnabled(false);
        jScrollPane2.setViewportView(registerTable);

        jLabel10.setText("First Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMotherName))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(txtFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFirstName)
                                .addComponent(txtLastName)
                                .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(28, 28, 28)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        backAction(RightPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        txtFirstName.setEditable(true);
        txtLastName.setEditable(true);
        genderCombo.setEnabled(true);
//        txtAge.setEditable(true);
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(Strings.isNullOrEmpty(txtFirstName.getText())){
            JOptionPane.showMessageDialog(null,"First Name can't be blank!!","Warining",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(Strings.isNullOrEmpty(txtLastName.getText())){
            JOptionPane.showMessageDialog(null,"Last Name can't be blank!!","Warining",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(genderCombo.getSelectedIndex()<0){
            JOptionPane.showMessageDialog(null,"Gender can't be blank!!","Warining",JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            Integer.parseInt(txtAge.getText());
        }catch(NumberFormatException exc){
            JOptionPane.showMessageDialog(null,"Only Numbers Allowed as Age");
            return;
        }
        student.setfName(txtFirstName.getText());
        student.setlName(txtLastName.getText());
        student.setGender(genderCombo.getSelectedItem().toString());
        student.setAge(Integer.parseInt(txtAge.getText()));
        //need updateStudent api;
//        studentService.updateStudent(student);
        JOptionPane.showMessageDialog(null, "Update Successfully!!");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtFatherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFatherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFatherNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> genderCombo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable registerTable;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtFatherName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMotherName;
    // End of variables declaration//GEN-END:variables
}
