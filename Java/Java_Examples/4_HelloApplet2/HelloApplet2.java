
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Event;

public class HelloApplet2 extends Applet{
	MyLog log;
	
	public HelloApplet2(){
		super();
		log = new MyLog();
		displayQuietly("constructing... ");
	}
	
	public void init(){
		displayQuietly("initializing... ");
	}
	
	public void start(){
		displayQuietly("starting... ");
	}
	
	public void stop(){
		display("stopping... ");
	}
	
	public void destroy(){
		display("destroy... ");
	}
	
	public void update(Graphics g){
		displayQuietly("updating...  ");
		super.update(g);
	}
	
	public void paint(Graphics g){
		displayQuietly("painting...	");
		g.drawString(log.toString (), 5, 15);
	}
	
	public boolean MouseDown(Event evt, int x, int y){
		display("down..  ");
		return true;
	}
	
	public boolean MouseUp(Event evt, int x, int y){
		display ("up..	");
		return true;
	}
	
	public boolean MouseDrag(Event evt, int x, int y){
		display ("dragging...	");
		repaint ();
		return true;
	}
	
	void display(String s){
		log.writeLine (s);
		repaint();
	}
	
	void displayQuietly(String s){
		log.writeLine (s);
	}
}


class MyLog{
	StringBuffer sbContents;

	MyLog(){
		sbContents = new StringBuffer();
	}

	void writeLine(String s){
		sbContents.append(s);
		System.out.println(s);
	}

	public String toString(){
		return sbContents.toString();
	}
}
