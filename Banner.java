import java.awt.*;
import java.applet.*;

/*
<applet code="Banner" width=300 height=100>
</applet>
*/

public class Banner extends Applet implements Runnable{
 	String msg=" A Simple Moving Banner. ";
	Thread t=null;
	int state;
	boolean stopflag;

public void init(){
	setBackground(Color.magenta);
	setForeground(Color.black);
}

public void start(){
	t=new Thread(this);
	stopflag=false;
	t.start();
}

public void run(){
	char ch;
	
	for(;;){
		try{
			repaint();
			Thread.sleep(10);
			ch=msg.charAt(0);
			msg=msg.substring(1,msg.length());
			msg+=ch;
			if(stopflag)
				break;
		}catch(InterruptedException e){}
	}
}
public void stop(){
	stopflag=true;
	t=null;
}

public void destroy(){
}

public void paint(Graphics g){
	g.drawString(msg,100,50);
}
}
