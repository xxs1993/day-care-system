package csye6200.userInterface;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractManagePanel extends javax.swing.JPanel {
    abstract public void populateTable();

    protected void removeExistPanel(String name, JPanel RightPanel){
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

}
