package csye6200.userInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import csye6200.entity.*;
import csye6200.service.impl.ClassroomServiceImpl;
import csye6200.service.impl.StudentServiceImpl;
import csye6200.service.impl.VaccineServiceImpl;
import csye6200.timer.RegistrationTimer;
import csye6200.userInterface.Classroom.ManageClassroomPanel;
import csye6200.userInterface.Student.ManageStudentPanel;
import csye6200.userInterface.Teacher.ManageTeacherPanel;
import csye6200.service.impl.TeacherServiceImpl;
import csye6200.userInterface.immunization.ManageImmunizationPanel;
import csye6200.userInterface.registration.ManageRegistrationPanel;
import java.awt.CardLayout;
import java.util.concurrent.*;
import javax.swing.JOptionPane;

/**
 * @author Alvin
 */
public class MainFrame extends javax.swing.JFrame {

    private TeacherServiceImpl tsi;
    private ClassroomServiceImpl crsi;
    private ClassRoom cr;
    private Teacher t;
    private ScheduledExecutorService pool;

    /**
     * Creates new form Main
     */
    public MainFrame() {
        initComponents();
        pool = Executors.newScheduledThreadPool(3);
        //TODO:delay changes to 0 when in presentation
        pool.scheduleAtFixedRate(new RegistrationTimer(), 1, 24, TimeUnit.HOURS);
        tsi = new TeacherServiceImpl();
        crsi = new ClassroomServiceImpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SplitPanel = new javax.swing.JSplitPane();
        LeftPanel = new javax.swing.JPanel();
        btnTeacher = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnClassroom = new javax.swing.JButton();
        btnImmu = new javax.swing.JButton();
        btnRegist = new javax.swing.JButton();
        RightPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTeacher.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnTeacher.setText("Teacher Service");
        btnTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherActionPerformed(evt);
            }
        });
        LeftPanel.add(btnTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 40));

        btnStudent.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnStudent.setText("Student Service");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        LeftPanel.add(btnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, 40));

        btnClassroom.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnClassroom.setText("Classroom Service");
        btnClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassroomActionPerformed(evt);
            }
        });
        LeftPanel.add(btnClassroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 40));

        btnImmu.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnImmu.setText("Immunization");
        btnImmu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImmuActionPerformed(evt);
            }
        });
        LeftPanel.add(btnImmu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, 40));

        btnRegist.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnRegist.setText("Registration");
        btnRegist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistActionPerformed(evt);
            }
        });
        LeftPanel.add(btnRegist, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 150, 40));

        SplitPanel.setLeftComponent(LeftPanel);

        RightPanel.setLayout(new java.awt.CardLayout());
        SplitPanel.setRightComponent(RightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplitPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SplitPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherActionPerformed
        ManageTeacherPanel mtp = new ManageTeacherPanel(RightPanel, tsi);
        RightPanel.add("AgencyWorkAreaPanel", mtp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.next(RightPanel);
    }//GEN-LAST:event_btnTeacherActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        ManageStudentPanel msp = new ManageStudentPanel(RightPanel,new StudentServiceImpl());
        RightPanel.add("AgencyWorkAreaPanel", msp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.next(RightPanel);
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassroomActionPerformed
        ManageClassroomPanel mcp = new ManageClassroomPanel(RightPanel, crsi);
        RightPanel.add("AgencyWorkAreaPanel", mcp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.next(RightPanel);
    }//GEN-LAST:event_btnClassroomActionPerformed

    private void btnImmuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImmuActionPerformed
        ManageImmunizationPanel mcp = new ManageImmunizationPanel(RightPanel);
        RightPanel.add("AgencyWorkAreaPanel", mcp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.next(RightPanel);
    }//GEN-LAST:event_btnImmuActionPerformed

    private void btnRegistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistActionPerformed
        // TODO add your handling code here:
        ManageRegistrationPanel mcp = new ManageRegistrationPanel(RightPanel);
        RightPanel.add("RegisterPanel", mcp);
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.next(RightPanel);
    }//GEN-LAST:event_btnRegistActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JSplitPane SplitPanel;
    private javax.swing.JButton btnClassroom;
    private javax.swing.JButton btnImmu;
    private javax.swing.JButton btnRegist;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnTeacher;
    // End of variables declaration//GEN-END:variables
}
