package csye6200.userInterface;

import csye6200.userInterface.Classroom.ViewClassroomPanel;
import javax.swing.*;
import java.awt.*;

public class DetailPanel extends javax.swing.JPanel  {

    protected void  backAction( JPanel RightPanel) {
        RightPanel.remove(this);
        Component[] componentArray = RightPanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        JPanel manageStudentPanel = (JPanel) component;
        if(manageStudentPanel instanceof AbstractManagePanel){
            ( (AbstractManagePanel) manageStudentPanel).populateTable();

        }
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.last(RightPanel);
    }

    protected void removeExistPanel(String name,JPanel RightPanel){
        Component[] componentList = RightPanel.getComponents();
        if(componentList !=null && componentList.length>0) {
            for (Component component : componentList) {
                if (component.getClass().getName().equals(name)) {
                    RightPanel.remove(component);
                    return;
                }
            }
        }
    }
    
    protected void  backToViewAction( JPanel RightPanel) {
        RightPanel.remove(this);
        Component[] componentArray = RightPanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewClassroomPanel viewClassroomPanel = (ViewClassroomPanel) component;
        viewClassroomPanel.populateTeacherTable();
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.previous(RightPanel);
    }
    
}
