import java.awt.*;
import java.applet.*;

/*
<applet code="StatusWindow" width=300 height=50>
</applet>
*/

public class StatusWindow extends Applet{
	public void init(){
		setBackground(Color.cyan);
	}
	
	public void paint(Graphics g){
		g.drawString("A Simple Applet", 20, 20);
		showStatus("This is shown in the status window.");
	}
}