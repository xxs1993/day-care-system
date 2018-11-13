/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.userInterface.Teacher;

import com.google.common.base.Strings;
import csye6200.entity.Student;
import csye6200.entity.Teacher;
import java.awt.CardLayout;
import javax.swing.JPanel;
import csye6200.service.TeacherService;
import csye6200.userInterface.AbstractManagePanel;
import csye6200.userInterface.DetailPanel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Alvin
 */
public class ManageTeacherPanel extends AbstractManagePanel {
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

            populateTable("");

                }

    public void populateTable(String selectedItem){
        int rowCount = tblTeacher.getRowCount();
        DefaultTableModel model = (DefaultTableModel)tblTeacher.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
         List<Teacher> teacherList = teacherService.getTeacher();

        if(teacherList == null || teacherList.isEmpty()) return;
        if(selectedItem == null || selectedItem.equals("ID")){
            sortById(teacherList);
        }
        if(selectedItem.equals("Last Name")){
            sortByLastName(teacherList);
        }
        if(selectedItem.equals("Age Range")){
            sortByAgeRange(teacherList);
        }
        if(selectedItem.equals("Search By ID")){
            String id = keyword.getText();
            teacher = teacherService.getTeacherById(id);
            teacherList.clear();
            teacherList.add(teacher);
        }
        if(selectedItem.equals("Search By Name")){
            String name = keyword.getText();
            teacherList.clear();
            teacherList = teacherService.getTeachersByFirstName(name);
        }
        for(Teacher t : teacherList) {
            Object row[] = new Object[model.getColumnCount()];
            row[0] =t.getId();
            row[1] =Strings.nullToEmpty(t.getfName());
            row[2] =Strings.nullToEmpty(t.getlName());
            row[3] =MAP.get(t.getAgeRange());
            model.addRow(row);
            }
                System.out.println(Arrays.toString(teacherService.getTeacher().toArray()));

        }
        private void sortById(List<Teacher> teacherList){
        teacherList.sort(Teacher::compareById);
        }
        private void sortByLastName(List<Teacher> teacherList){
        teacherList.sort(Teacher::compareByLastName);
        }
        private void sortByAgeRange(List<Teacher> teacherList){
        teacherList.sort(Teacher::compareByAgeRange);
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
        jLabel2 = new javax.swing.JLabel();
        comboSearch = new javax.swing.JComboBox<>();
        keyword = new javax.swing.JTextField();
        btnGo = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

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

        jLabel2.setText("Sort by:");

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search By ID", "Search By Name"}));
        comboSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSearchActionPerformed(evt);
            }
        });

        keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordActionPerformed(evt);
            }
        });

        btnGo.setText("Go");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Last Name", "Age Range" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEnroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGo)
                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnroll)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrollActionPerformed
        DetailPanel ctp = new CreateTeacherPanel(RightPanel,teacherService);
        RightPanel.remove(this);
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
        List<Student> getS=teacherService.getStudentByTeacherId(ts);
        if(getS==null || getS.isEmpty()){
        teacherService.deleteTeacher(ts);
        }else{
            JOptionPane.showMessageDialog(null,"This teacher have assigned student(s)","Warning",JOptionPane.WARNING_MESSAGE);
        }
        populateTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int row = tblTeacher.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String ts = (String) tblTeacher.getValueAt(row, 0);
        Teacher t = teacherService.getTeacherById(ts);
        DetailPanel vp = new ViewPanel(RightPanel, teacherService, t);
        RightPanel.add("TeacherManagePanel", vp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.last(RightPanel);
//        layout.next(RightPanel);
        
    }//GEN-LAST:event_btnViewActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        tblTeacher.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void comboSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSearchActionPerformed

    }//GEN-LAST:event_comboSearchActionPerformed

    private void keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keywordActionPerformed

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
        //Format Validation
        String search=keyword.getText();
        Pattern p=Pattern.compile("[T]+[0-9]");
        Matcher m=p.matcher(search);
        boolean b=m.find();
        if(comboSearch.getSelectedItem().equals("Search By ID")){
            if(b == false||Strings.isNullOrEmpty(search)){
            JOptionPane.showMessageDialog(null,"The Format Should be T + Number 0-9","Warining",JOptionPane.WARNING_MESSAGE);
            return ;
            }
        }
        if(comboSearch.getSelectedItem().equals("Search By Name")){
            if(Strings.isNullOrEmpty(search)){
              JOptionPane.showMessageDialog(null,"Search TextField can't be blank!!","Warining",JOptionPane.WARNING_MESSAGE);
              return;
            }
        }
        String selectedItem = (String)comboSearch.getSelectedItem();
        populateTable(selectedItem);

    }//GEN-LAST:event_btnGoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedItem = (String)jComboBox1.getSelectedItem();
        populateTable(selectedItem);
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEnroll;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keyword;
    private javax.swing.JTable tblTeacher;
    // End of variables declaration//GEN-END:variables


}
