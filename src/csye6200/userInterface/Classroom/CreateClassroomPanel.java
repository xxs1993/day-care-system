/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.userInterface.Classroom;

import com.google.common.base.Strings;
import csye6200.service.ClassroomService;
import csye6200.entity.ClassRoom;
import csye6200.userInterface.DetailPanel;
import csye6200.userInterface.Teacher.ManageTeacherPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Alvin
 */
public class CreateClassroomPanel extends DetailPanel {
    private JPanel RightPanel;
    private ClassroomService classroomService;
    private ClassRoom classroom;
    
    private static final Map<String,Integer> MAP= new HashMap<String,Integer>(){{
     put("6-12",6);
     put("13-24",13);
     put("25-35",25);
     put("36-47",36);
     put("48-59",48);
     put("60 up",60);
    }};
    /**
     * Creates new form CreateClassroomPanel
     */
    public CreateClassroomPanel(JPanel RightPanel, ClassroomService classroomService) {
        initComponents();
        this.RightPanel=RightPanel;
        this.classroomService=classroomService;
        
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

        jLabel1 = new javax.swing.JLabel();
        jCapacity = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboAgeRange = new javax.swing.JComboBox<String>();
        btnBack = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(592, 553));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Classroom Information");

        jCapacity.setText("Capacity");

        jLabel7.setText("Age Range:");

        comboAgeRange.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboAgeRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAgeRangeActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back  ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(jCapacity)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboAgeRange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(137, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreate)
                        .addGap(109, 109, 109))))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCapacity)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboAgeRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(306, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboAgeRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAgeRangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAgeRangeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        backAction(RightPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        ClassRoom classroom=new ClassRoom();
        try{
            Integer.parseInt(txtCapacity.getText());
        }catch(NumberFormatException exc){
            JOptionPane.showMessageDialog(null,"Only Numbers Allowed as Capacity");
            return;
        }
        if(comboAgeRange.getSelectedItem()==null){
            JOptionPane.showMessageDialog(null,"Please Select Age Range","Warining",JOptionPane.WARNING_MESSAGE);
            return;
        }
        classroom.setCapacity(Integer.parseInt(txtCapacity.getText()));
        classroom.setAgeRange(MAP.get(comboAgeRange.getSelectedItem()));
        classroomService.addClassroom(classroom);
        JOptionPane.showMessageDialog(null,"New classroom created!!");

    }//GEN-LAST:event_btnCreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<String> comboAgeRange;
    private javax.swing.JLabel jCapacity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCapacity;
    // End of variables declaration//GEN-END:variables
}
