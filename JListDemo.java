// Demonstrate JList.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/*
	<applet code="JListDemo" width=200 height=120>
	</applet>
*/

public class JListDemo extends JApplet {
	JList jlst;
	JLabel jlab;
	JScrollPane jscrlp;

	// Create an array of cities.
	String Cities[] = { "New York", "Chicago", "Houston",
			"Denver", "Los Angeles", "Seattle",
			"London", "Paris", "New Delhi",	
			"Hong Kong", "Tokyo", "Sydney" };
	public void init() {
		try {
			SwingUtilities.invokeAndWait(
				new Runnable() {
					public void run() {
						makeGUI();
					}
				}
			);
		} catch (Exception exc) {
			System.out.println("Can't create because of " + exc);
		}
	}
	
	private void makeGUI() {
	// Change to flow layout.
	setLayout(new FlowLayout());
	// Create a JList.
	jlst = new JList(Cities);
	// Set the list selection mode to single selection.
	jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	// Add the list to a scroll pane.
	jscrlp = new JScrollPane(jlst);
	// Set the preferred size of the scroll pane.
	jscrlp.setPreferredSize(new Dimension(120, 90));
	// Make a label that displays the selection.
	jlab = new JLabel("Choose a City");
	// Add selection listener for the list.
	
	jlst.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent le) {
			// Get the index of the changed item.
			int idx = jlst.getSelectedIndex();
			// Display selection, if item was selected.
			if(idx != -1)
				jlab.setText("Current selection: " + Cities[idx]);
			else // Otherwise, reprompt.
				jlab.setText("Choose a City");
			}
		});
	// Add the list and label to the content pane.
	add(jscrlp);
	add(jlab);
	}
}