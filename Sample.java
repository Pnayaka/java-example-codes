import java.awt.*;
import java.applet.*;

/*
<applet code="Sample" width=300 height=100>
</applet>
*/

public class Sample extends Applet{
 	String msg;
public void init(){
	setBackground(Color.magenta);
	setForeground(Color.black);
	msg="Inside INIT( ) - -";
}

public void start(){
	msg +="Inside Start( ) - -";
}

public void stop(){
}

public void destroy(){
}

public void paint(Graphics g){
	msg+="Inside paint( ) - -";
	g.drawString(msg,10,30);
}
}
