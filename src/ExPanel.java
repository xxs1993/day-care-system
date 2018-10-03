import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ExPanel extends JPanel{
	
	public ExPanel() {
		intComponents();
	}
	
	private void intComponents() {
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.add(btnNewButton);
	}

}
