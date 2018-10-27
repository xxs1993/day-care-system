/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.userInterface.Teacher;

import csye6200.entity.Student;
import csye6200.entity.Teacher;
import java.awt.CardLayout;
import javax.swing.JPanel;
import csye6200.service.TeacherService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Alvin
 */
public class ManageTeacherPanel extends javax.swing.JPanel {
    JPanel RightPanel;
    TeacherService teacherService;
    Teacher teacher;

    /**
     * Creates new form StudentWorkPanel
     */
private static final Map<Integer,String> MAP= new HashMap<Integer,String>(){{
     put(6,"6-12");
     put(13,"13-24");
     put(25,"25-35");
     put(36,"36-47");
     put(48,"48-59");
     put(60,"60 up");
    }};

    public ManageTeacherPanel(JPanel rp,TeacherService ts) {
        initComponents();
        RightPanel = rp;
        teacherService=ts;
        populateTable();
    }
    public void populateTable(){
        int rowCount = tblTeacher.getRowCount();
        DefaultTableModel model = (DefaultTableModel)tblTeacher.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
        
        for(Teacher t : teacherService.getTeacher()) {
            Object row[] = new Object[model.getColumnCount()];
            row[0] =t.getId();
            row[1] =t.getfName();
            row[2] =t.getlName();
            row[3] =MAP.get(t.getAgeRange());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTeacher = new javax.swing.JTable();
        btnEnroll = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Manage Teacher ");

        tblTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher ID", "First Name", "Last Name", "Age Range"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            tblTeacher.getColumnModel().getColumn(3).setResizable(false);
        }

        btnEnroll.setText("Enroll Teacher");
        btnEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrollActionPerformed(evt);
            }
        });

        btnView.setText("View Detail");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEnroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEnroll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrollActionPerformed
        CreateTeacherPanel ctp = new CreateTeacherPanel(RightPanel,teacherService);
        RightPanel.add("CreateTeacherPanel", ctp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.next(RightPanel);
    }//GEN-LAST:event_btnEnrollActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    int row = tblTeacher.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String ts = (String)tblTeacher.getValueAt(row, 0);
        List<Student> getS=teacherService.getStudent(ts);
        if(getS==null || getS.isEmpty()){
        teacherService.deleteTeacher(ts);
        }else{
            JOptionPane.showMessageDialog(null,"This teacher have assigned student(s)","Warning",JOptionPane.WARNING_MESSAGE);
        }
        populateTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int row = tblTeacher.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String ts=(String)tblTeacher.getValueAt(row, 0);
        Teacher t=teacherService.getTeacherById(ts);
        ViewPanel vp = new ViewPanel(RightPanel,teacherService,t);
        RightPanel.add("ViewPanel", vp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.next(RightPanel);
        
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEnroll;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTeacher;
    // End of variables declaration//GEN-END:variables


}
