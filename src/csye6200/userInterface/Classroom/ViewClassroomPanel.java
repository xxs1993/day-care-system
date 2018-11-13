/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.userInterface.Classroom;

import csye6200.constants.Constants;
import csye6200.entity.ClassRoom;
import csye6200.entity.Student;
import csye6200.entity.Teacher;
import csye6200.service.ClassroomService;
import csye6200.userInterface.AbstractViewPanel;
import csye6200.userInterface.DetailPanel;
import csye6200.util.RegulationUtil;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Karen
 */
public class ViewClassroomPanel extends DetailPanel implements AbstractViewPanel{

    private JPanel RightPanel;
    private ClassroomService classroomService;
    private ClassRoom classroom;
    /**
     * Creates new form ViewPanel
     */

    /**
     * Creates new form ViewClassroomPanel
     */
    private static final Map<String, Integer> MAP = new HashMap<String, Integer>() {
        {
            put("6-12", 6);
            put("13-24", 13);
            put("25-35", 25);
            put("36-47", 36);
            put("48-59", 48);
            put("60 up", 60);
        }
    };

    ViewClassroomPanel(JPanel rp, ClassroomService cs, ClassRoom c) {
        initComponents();
        classroom = c;
        RightPanel = rp;
        classroomService = cs;

        txtID.setText(c.getId());
        txtCapacity.setText(Integer.toString(c.getCapacity()));

        comboAgeRange.removeAllItems();
        String AgeRangeType[] = {"6-12", "13-24", "25-35", "36-47", "48-59", "60+"};
        comboAgeRange.addItem(AgeRangeType[0]);
        comboAgeRange.addItem(AgeRangeType[1]);
        comboAgeRange.addItem(AgeRangeType[2]);
        comboAgeRange.addItem(AgeRangeType[3]);
        comboAgeRange.addItem(AgeRangeType[4]);
        comboAgeRange.addItem(AgeRangeType[5]);
        comboAgeRange.setEnabled(false);
        
        // TODO set the ageRange box according to data
//        int ar = c.getAgeRange();
//        if(ar == 13) comboAgeRange.setSelectedIndex(1);
//        else if (ar == 25) comboAgeRange.setSelectedIndex(2);
//        else if (ar == 36) comboAgeRange.setSelectedIndex(3);
//        else if (ar == 48) comboAgeRange.setSelectedIndex(4);
//        else if (ar == 60) comboAgeRange.setSelectedIndex(5);
//        else comboAgeRange.setSelectedIndex(0);
//        jRemove1.setVisible(true);
        populateTeacherTable();
        populateStudentTable();
    }

    public void populateTeacherTable() {
        int rowCount = tblTeacher.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tblTeacher.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        Object row[] = new Object[model.getColumnCount()];
        String cid = classroom.getId();
        List<Teacher> teachers = classroomService.getTeachersInClassroom(cid);
        if (teachers == null || teachers.isEmpty()) {
            return;
        }
        for (Teacher t : teachers) {
            row[0] = t.getId();
            row[1] = t.getfName();
            row[2] = t.getlName();
            row[3] = t.getStudents()==null? 0 : t.getStudents().size();
            model.addRow(row);
        }
    }

    private void populateStudentTable() {
        int rowCount = tblStudent.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        Object row[] = new Object[model.getColumnCount()];
        List<Student> students = new ArrayList();
        List<Teacher> teachers = classroom.getTeachers();
        if (teachers == null || teachers.isEmpty()) {
            return;
        }
        for (Teacher t : teachers) {
            List<Student> temp = t.getStudents();
            if (temp == null || temp.isEmpty()) {
                return;
            } else {
                for (Student s : temp) {
                    students.add(s);
                }
            }

        }
        if (students == null || students.isEmpty()) {
            return;
        } else {
            for (Student s : students) {
                row[0] = s.getId();
                row[1] = s.getfName();
                row[2] = s.getlName();
                model.addRow(row);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTeacher = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboAgeRange = new javax.swing.JComboBox<String>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jRemove1 = new javax.swing.JButton();
        AddTeacherButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Classroom Information");

        jLabel2.setText("Capacity");

        txtCapacity.setEditable(false);

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

        tblTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher ID", "Last Name", "First Name", "Students"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTeacher);
        if (tblTeacher.getColumnModel().getColumnCount() > 0) {
            tblTeacher.getColumnModel().getColumn(0).setResizable(false);
            tblTeacher.getColumnModel().getColumn(1).setResizable(false);
            tblTeacher.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Classroom ID:");

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel8.setText("Age Range:");

        comboAgeRange.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboAgeRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAgeRangeActionPerformed(evt);
            }
        });

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Last Name", "First Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblStudent);
        if (tblStudent.getColumnModel().getColumnCount() > 0) {
            tblStudent.getColumnModel().getColumn(0).setResizable(false);
            tblStudent.getColumnModel().getColumn(1).setResizable(false);
            tblStudent.getColumnModel().getColumn(2).setResizable(false);
        }

        jRemove1.setText("Remove Teacher");
        jRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemove1ActionPerformed(evt);
            }
        });

        AddTeacherButton.setText("Add Teacher");
        AddTeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTeacherButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel8))
                            .addGap(64, 64, 64)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboAgeRange, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(jLabel1)
                            .addGap(79, 79, 79)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnBack)
                                    .addGap(201, 201, 201)
                                    .addComponent(btnUpdate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSave)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(AddTeacherButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRemove1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboAgeRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRemove1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddTeacherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        backAction(RightPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO: cannot change capacity
        List<Teacher> getS = classroom.getTeachers();
        if (getS == null || getS.isEmpty()) {
            classroom.setCapacity(Integer.parseInt(txtCapacity.getText()));
            classroom.setAgeRange(MAP.get(comboAgeRange.getSelectedItem()));
        } else {
            JOptionPane.showMessageDialog(null, "This classroom have been assigned teacher(s), age range cannot be changed!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        // TODO
        classroomService.updateClassroom(classroom);
        JOptionPane.showMessageDialog(null, "Update Successfully!!");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        List<Teacher> getS = classroom.getTeachers();
        if (getS == null || getS.isEmpty()) {
            txtCapacity.setEditable(true);
            comboAgeRange.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "This classroom have been assigned teacher(s), age range cannot be changed!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void comboAgeRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAgeRangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAgeRangeActionPerformed

    private void jRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemove1ActionPerformed
        // TODO add your handling code here:
        int row = tblTeacher.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int studentNum = (Integer) tblTeacher.getValueAt(row, 3);
        if (studentNum == 0) {
            String tid = (String)tblTeacher.getValueAt(row, 0);
            classroomService.removeTeacher(tid, classroom.getId());
            populateTeacherTable();
        } else {
            JOptionPane.showMessageDialog(null, "Teacher who has been assigned students cannot be removed!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jRemove1ActionPerformed

    private void AddTeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTeacherButtonActionPerformed
        int age = RegulationUtil.getAgeRangeType(this.classroom.getAgeRange());
        int maxTNum = RegulationUtil.getRegulationMap(age).get(Constants.MAX_GROUP_AMOUNT);
        if (this.classroom.getTeachers() != null && !this.classroom.getTeachers().isEmpty() && this.classroom.getTeachers().size() == maxTNum) {
            JOptionPane.showMessageDialog(null, "Maxium teacher number reached. Cannot add teacher to this classroom.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            AddTeachersToClassroomPanel atcp = new AddTeachersToClassroomPanel(RightPanel,this.classroom);
        removeExistPanel(atcp.getClass().getName(),RightPanel);
        RightPanel.add("AddTeachersToClassroomPanel", atcp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.last(RightPanel);
        }
        
    }//GEN-LAST:event_AddTeacherButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTeacherButton;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboAgeRange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jRemove1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTable tblTeacher;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
