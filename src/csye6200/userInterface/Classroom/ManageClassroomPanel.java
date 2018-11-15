/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csye6200.userInterface.Classroom;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import csye6200.constants.PanelConstants;
import csye6200.entity.ClassRoom;
import csye6200.service.ClassroomService;
import csye6200.userInterface.AbstractManagePanel;

import java.awt.CardLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * @author Alvin
 */
public class ManageClassroomPanel extends AbstractManagePanel {

    private JPanel RightPanel;
    private ClassroomService classroomService;
    private ClassRoom classRoom;
    private List<ClassRoom> classroomList;

    private static final Map<Integer, String> MAP = new HashMap<Integer, String>() {
        {
            put(6, "6-12");
            put(13, "13-24");
            put(25, "25-35");
            put(36, "36-47");
            put(48, "48-59");
            put(60, "60 up");
        }
    };

    /**
     * Creates new form StudentWorkPanel
     */

    public ManageClassroomPanel(JPanel rp, ClassroomService cs) {
        initComponents();
        RightPanel = rp;
        classroomService = cs;
        populateTable();
    }
    
    public void populateTable() {
        populateTable("","");
    }

    private void sortBy(String sortBy){
        int rowCount = tblClassroom.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tblClassroom.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        if(classroomList == null || classroomList.isEmpty())
            return;
        if(Strings.isNullOrEmpty(sortBy) || sortBy.equals("ID")){
            sortById(classroomList);
        }
        if(sortBy.equals("Capacity")){
            sortByLastName(classroomList);
        }
        if(sortBy.equals("Age Range")){
            sortByAgeRange(classroomList);
        }
        flushTable(model);
    }

    private void flushTable(DefaultTableModel model){
        if(classroomList == null || classroomList.isEmpty())
            return;
        for (ClassRoom c : classroomList) {
            Object row[] = new Object[model.getColumnCount()];
            row[0] = c.getId();
            row[1] = c.getCapacity();
            row[2] = MAP.get(c.getAgeRange());
            row[3] = c.getTeachers()==null? 0 : c.getTeachers().size();
            row[4] = classroomService.getCurrentStudentNumber(c.getId());
            model.addRow(row);
        }
    }

    public void populateTable(String selectedItem,String sortBy) {
        classroomList = Lists.newArrayList();
        if(Strings.isNullOrEmpty(selectedItem)){
            classroomList = classroomService.getClassrooms();
        } else if(selectedItem.equals("Search By ID")){
            String id = keyword.getText();
            classRoom = classroomService.getClassroomById(id);
            if(classRoom !=null)
            classroomList.add(classRoom);
        } else if(selectedItem.equals("Search By Capacity")){
            String capacity = keyword.getText();
            classroomList = classroomService.getClassroomsByCapacity(Integer.parseInt(capacity));
        }
        sortBy(sortBy);
    }
    
    private void sortById(List<ClassRoom> classroomList){
        classroomList.sort(ClassRoom::compareById);
        }
        private void sortByLastName(List<ClassRoom> classroomList){
        classroomList.sort(ClassRoom::compareByCapacity);
        }
        private void sortByAgeRange(List<ClassRoom> classroomList){
        classroomList.sort(ClassRoom::compareByAgeRange);
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
        btnCreate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        sortByBox = new javax.swing.JComboBox();
        comboSearch = new javax.swing.JComboBox();
        keyword = new javax.swing.JTextField();
        btnGo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClassroom = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Manage Classroom ");

        btnCreate.setText("Create Classroom");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnView.setText("View Detail");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jLabel2.setText("Sort by");

        sortByBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Capacity", "Age Range" }));
        sortByBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByBoxActionPerformed(evt);
            }
        });

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search By ID", "Search By Capacity" }));
        comboSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSearchActionPerformed(evt);
            }
        });

        btnGo.setText("Go");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });

        tblClassroom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Classroom ID", "Capacity", "Age Range", "Teachers", "Students"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblClassroom);
        if (tblClassroom.getColumnModel().getColumnCount() > 0) {
            tblClassroom.getColumnModel().getColumn(0).setResizable(false);
            tblClassroom.getColumnModel().getColumn(1).setResizable(false);
            tblClassroom.getColumnModel().getColumn(2).setResizable(false);
            tblClassroom.getColumnModel().getColumn(3).setResizable(false);
            tblClassroom.getColumnModel().getColumn(4).setResizable(false);
        }

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnReset)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(sortByBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnGo))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sortByBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView)
                .addContainerGap(143, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        tblClassroom.clearSelection();
    }  
    
    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int row = tblClassroom.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String cs = (String) tblClassroom.getValueAt(row, 0);
        ClassRoom c = classroomService.getClassroomById(cs);
        ViewClassroomPanel vp = new ViewClassroomPanel(RightPanel, classroomService, c);
        removeExistPanel(vp.getClass().getName(),RightPanel);
        RightPanel.add(PanelConstants.VIEW_CLASSROOM_PANEL, vp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.last(RightPanel);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateClassroomPanel ctp = new CreateClassroomPanel(RightPanel, classroomService);
        removeExistPanel(ctp.getClass().getName(),RightPanel);
        RightPanel.add(PanelConstants.CREATE_CLASSROOM_PANEL, ctp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.last(RightPanel);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void sortByBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByBoxActionPerformed
        String sortBy = (String)sortByBox.getSelectedItem();
        sortBy(sortBy);
    }//GEN-LAST:event_sortByBoxActionPerformed

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
        String search=keyword.getText();
        Pattern p=Pattern.compile("[R]+[0-9]");
        Matcher m=p.matcher(search);
        boolean b=m.find();
        if(comboSearch.getSelectedItem().equals("Search By ID")){
            if(b == false||Strings.isNullOrEmpty(search)){
            JOptionPane.showMessageDialog(null,"The Format Should be R + Number 0-9","Warining",JOptionPane.WARNING_MESSAGE);
            return ;
            }
        }
        if(comboSearch.getSelectedItem().equals("Search By Capacity")){
            if(Strings.isNullOrEmpty(search)){
              JOptionPane.showMessageDialog(null,"Search TextField can't be blank!!","Warining",JOptionPane.WARNING_MESSAGE);
              return;
            }
           for(int i =0;i<search.length();i++){
               if(!Character.isDigit(search.charAt(i))){
                   JOptionPane.showMessageDialog(null,"Wrong format!!","Warining",JOptionPane.WARNING_MESSAGE);
                   return;

               }

           }
        }
        String selectedItem = (String)comboSearch.getSelectedItem();
        String sortBy = (String)sortByBox.getSelectedItem();
        populateTable(selectedItem,sortBy);
    }//GEN-LAST:event_btnGoActionPerformed

    private void comboSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        populateTable();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox comboSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keyword;
    private javax.swing.JComboBox sortByBox;
    private javax.swing.JTable tblClassroom;
    // End of variables declaration//GEN-END:variables
}
