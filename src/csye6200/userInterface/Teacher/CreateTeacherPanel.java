/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.userInterface.Teacher;


import com.google.common.base.Strings;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

import csye6200.constants.PanelConstants;
import csye6200.entity.Teacher;
import csye6200.service.TeacherService;
import csye6200.userInterface.AbstractManagePanel;
import csye6200.userInterface.DetailPanel;
import csye6200.userInterface.Teacher.ViewPanel;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * @author Alvin
 */
public class CreateTeacherPanel extends DetailPanel {
    JPanel RightPanel;
    TeacherService teacherService;
    Teacher teacher;
    /**
     * Creates new form CreateTeacherPanel
     */
    private static final Map<String,Integer> MAP= new HashMap<String,Integer>(){{
     put("6-12",6);
     put("13-24",13);
     put("25-35",25);
     put("36-47",36);
     put("48-59",48);
     put("60 up",60);
    }};

    CreateTeacherPanel(JPanel RightPanel, TeacherService teacherService) {
        initComponents();
        this.RightPanel=RightPanel;
        this.teacherService=teacherService;
        
        comboAgeRange.removeAllItems();
        String AgeRangeType[]={"6-12","13-24","25-35","36-47", "48-59","60 up"};
        comboAgeRange.addItem(AgeRangeType[0]);
        comboAgeRange.addItem(AgeRangeType[1]);
        comboAgeRange.addItem(AgeRangeType[2]);
        comboAgeRange.addItem(AgeRangeType[3]);
        comboAgeRange.addItem(AgeRangeType[4]);
        comboAgeRange.addItem(AgeRangeType[5]);
    
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnEnroll = new javax.swing.JButton();
        comboAgeRange = new javax.swing.JComboBox<>();
        genderCombo = new javax.swing.JComboBox<>();

        jLabel2.setText("First Name:");

        jLabel3.setText("Last Name:");

        jLabel4.setText("Gender:");

        jLabel5.setText("Age:");

        jLabel7.setText("Age Range:");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Teacher Information");

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back  ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnEnroll.setText("Enroll");
        btnEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrollActionPerformed(evt);
            }
        });

        comboAgeRange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboAgeRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAgeRangeActionPerformed(evt);
            }
        });

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "female", "male" }));
        genderCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(comboAgeRange, 0, 200, Short.MAX_VALUE)
                            .addComponent(genderCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                        .addComponent(btnEnroll)
                        .addGap(114, 114, 114))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboAgeRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnroll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(155, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents



    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        backAction(RightPanel);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrollActionPerformed
        Teacher teacher=new Teacher();
        if(Strings.isNullOrEmpty(txtFirstName.getText())){
            JOptionPane.showMessageDialog(null,"First Name can't be blank!!","Warining",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(Strings.isNullOrEmpty(txtLastName.getText())){
            JOptionPane.showMessageDialog(null,"Last Name can't be blank!!","Warining",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(genderCombo.getSelectedIndex() <0){
            JOptionPane.showMessageDialog(null,"Gender can't be blank!!","Warining",JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            Integer.parseInt(txtAge.getText());
        }catch(NumberFormatException exc){
            JOptionPane.showMessageDialog(null,"Only Numbers Allowed as Age");
            return;
            }
        if(comboAgeRange.getSelectedItem()==null){
            JOptionPane.showMessageDialog(null,"Please Select Age Range","Warining",JOptionPane.WARNING_MESSAGE);
            return;
        }
        teacher.setfName(txtFirstName.getText());
        teacher.setlName(txtLastName.getText());
        teacher.setGender(genderCombo.getSelectedItem().toString());
        teacher.setAge(Integer.parseInt(txtAge.getText()));
        teacher.setAgeRange(MAP.get(comboAgeRange.getSelectedItem()));
        teacher  = teacherService.addTeacher(teacher);
        JOptionPane.showMessageDialog(null,"Teacher Enrolled!!");
        DetailPanel teacherDetailPanel = new ViewPanel(RightPanel,teacherService,teacher);
        removeExistPanel(teacherDetailPanel.getClass().getName(),RightPanel);
        RightPanel.remove(this);
        RightPanel.add(PanelConstants.VIEW_TEACHER_PANEL,teacherDetailPanel);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.last(RightPanel);

    }//GEN-LAST:event_btnEnrollActionPerformed

    private void comboAgeRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAgeRangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAgeRangeActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void genderComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEnroll;
    private javax.swing.JComboBox<String> comboAgeRange;
    private javax.swing.JComboBox<String> genderCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}
