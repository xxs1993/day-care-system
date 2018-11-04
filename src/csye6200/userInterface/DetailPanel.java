package csye6200.userInterface;

import javax.swing.*;
import java.awt.*;

public class DetailPanel extends javax.swing.JPanel  {

    protected void  backAction( JPanel RightPanel) {
        RightPanel.remove(this);
        Component[] componentArray = RightPanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AbstractManagePanel manageStudentPanel = (AbstractManagePanel) component;
        manageStudentPanel.populateTable();
        CardLayout layout = (CardLayout) RightPanel.getLayout();
        layout.previous(RightPanel);
    }
}
