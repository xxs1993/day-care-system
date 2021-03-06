/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.userInterface.Student;

import csye6200.constants.Constants;
import csye6200.entity.Student;
import csye6200.entity.Vaccine;
import csye6200.userInterface.DetailPanel;
import csye6200.service.RegisterService;
import csye6200.service.StudentService;
import csye6200.service.VaccineService;
import csye6200.service.impl.RegisterServiceImpl;
import csye6200.service.impl.VaccineServiceImpl;
import csye6200.util.DateUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author zehuama
 */
public class ImmuPanel extends DetailPanel {

    private JPanel RightPanel;
    private StudentService studentService;
    private Student student;
    private Vaccine vaccine;
    private RegisterService registerService;
    private VaccineService vaccineService;
    
    /**
     * Creates new form ImmuPanel
     */
    public ImmuPanel(JPanel rp,StudentService ss,Student stu) {
        initComponents();
        student = stu;
        vaccine = new Vaccine();
        RightPanel =rp;
        studentService = ss;
        fName.setText(stu.getfName());
        lName.setText(stu.getlName());
        registerService = new RegisterServiceImpl();
        vaccineService = new VaccineServiceImpl();
        populateTable();
    }

    
    
    public void populateTable() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int rowCount = jTable1.getRowCount();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }

        List<Vaccine> sort = vaccineService.getVaccineRecordByStudentId(student.getId());
        if(sort == null || sort.isEmpty()) return;
        sort.sort((x1, x2) -> {
            int cmp = x1.getType().compareTo(x2.getType());
            if(cmp != 0) return cmp;
            return x1.getVaccinationTime().isAfter(x2.getVaccinationTime())? -1:1;
        });
        for(Vaccine v : sort) {
            Object row[] = new Object[model.getColumnCount()];
            row[0] =v.getType();
            row[1] =v.getTimeDisplay();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fName = new javax.swing.JLabel();
        lName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine Type", "Injection Date"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        fName.setFont(new java.awt.Font("Lucida Grande", 0, 27)); // NOI18N
        fName.setText("jLabel1");

        lName.setFont(new java.awt.Font("Lucida Grande", 0, 27)); // NOI18N
        lName.setText("jLabel2");

        jLabel3.setText("Select vaccine type:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Polio", "MMR", "Flu"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Inject");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fName)
                    .addComponent(lName))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String selectedItem = (String)jComboBox1.getSelectedItem();
        TableModel model = jTable1.getModel();
        int row = jTable1.getRowCount();
        for(int i = 0;i<row;i++){
            String type = model.getValueAt(i,0).toString();
            String timeDisplay = model.getValueAt(i,1).toString();
            LocalDate time = DateUtil.stringToDate(timeDisplay);
            LocalDate now = LocalDate.now();
            if(time == null ||!type.equals(selectedItem)){
                if(time.getYear() < now.getYear() ){
                    break;
                }
                continue;
            }
            //match type
            //compare time
            if(time.getYear() == now.getYear() && (time.getMonthValue()/ Constants.SEMESTER_START_MONTH == now.getMonthValue()/Constants.SEMESTER_START_MONTH)){
                JOptionPane.showMessageDialog(null,String.format("%s has taken %s this semester !",student.getId(),type));
                return;
            }else
                //the newest record is not in this year
                break;

        }

        vaccine.setType(selectedItem);
        LocalDate now = LocalDate.now();
        vaccine.setVaccinationTime(now);
        vaccine.setTimeDisplay(DateUtil.dateToString(now));
        vaccine.setStudentId(student.getId());
        vaccineService.addVaccineRecord(vaccine);
        populateTable();
        JOptionPane.showMessageDialog(null,"Record Added");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.backAction(RightPanel);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lName;
    // End of variables declaration//GEN-END:variables
}
