// Demonstrate JTable.
import java.awt.*;
import javax.swing.*;

/*
	<applet code="JTableDemo" width=400 height=200>
	</applet>
*/

public class JTableDemo extends JApplet {
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
	// Initialize column headings.
	String[] colHeads = { "Name", "Extension", "ID#" };
	// Initialize data.
	Object[][] data = {
			{ "Gail", "4567", "865" },
			{ "Ken", "7566", "555" },
			{ "Viviane", "5634", "587" },
			{ "Melanie", "7345", "922" },
			{ "Anne", "1237", "333" },
			{ "John", "5656", "314" },
			{ "Matt", "5672", "217" },
			{ "Claire", "6741", "444" },
			{ "Erwin", "9023", "519" },
			{ "Ellen", "1134", "532" },
			{ "Jennifer", "5689", "112" },
			{ "Ed", "9030", "133" },
			{ "Helen", "6751", "145" }
			};
	// Create the table.
	JTable table = new JTable(data, colHeads);
	// Add the table to a scroll pane.
	JScrollPane jsp = new JScrollPane(table);
	// Add the scroll pane to the content pane.
	add(jsp);
	}
}