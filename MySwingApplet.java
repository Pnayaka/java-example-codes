// A simple Swing-based applet
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
This HTML can be used to launch the applet:
<object code="MySwingApplet" width=220 height=90>
</object>
*/
public class MySwingApplet extends JApplet {
JButton jbtnAlpha;
JButton jbtnBeta;
JLabel jlab;
// Initialize the applet.
public void init() {
try {
SwingUtilities.invokeAndWait(new Runnable () {
public void run() {
makeGUI(); // initialize the GUI
}
});
} catch(Exception exc) {
System.out.println("Can't create because of "+ exc);
}
}
// This applet does not need to override start(), stop(),
// or destroy().
// Set up and initialize the GUI.
private void makeGUI() {
// Set the applet to use flow layout.
setLayout(new FlowLayout());
// Make two buttons.
jbtnAlpha = new JButton("Kichha");
jbtnBeta = new JButton("Pari");
// Add action listener for Alpha.
jbtnAlpha.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent le) {
jlab.setText("Kichha was pressed.");
}
});
// Add action listener for Beta.
jbtnBeta.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent le) {
jlab.setText("Pari was pressed.");
}
});
// Add the buttons to the content pane.
add(jbtnAlpha);
add(jbtnBeta);
// Create a text-based label.
jlab = new JLabel("Press a button.");
// Add the label to the content pane.
add(jlab);
}
}