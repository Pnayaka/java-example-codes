// Demonstrate JTextField.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code="JTextFieldDemo" width=300 height=50>
</applet>
*/
public class JTextFieldDemo extends JApplet {
	JTextField jtf;
		public void init() {
				try {
					SwingUtilities.invokeAndWait(
					new Runnable() {
						public void run() {
							makeGUI();
						}
					});
				} catch (Exception exc) {
				System.out.println("Can't create because of " + exc);
		}
}

private void makeGUI() {
	
	// Change to flow layout.
	setLayout(new FlowLayout());
	
	// Add text field to content pane.
	jtf = new JTextField("Enter your Name",10);
	add(jtf);
	jtf.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
		
				// Show text when user presses ENTER.
				showStatus(jtf.getText());
			}
		});
	}
}