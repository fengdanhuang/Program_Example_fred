/*
 * File: GRectExample.java
 * -----------------------
 * This program creates a new GRect object, sets it to be filled,
 * colors it red, and then displays it on the screen.  The GRect
 * is 125 pixels wide by 60 pixels high, with its upper left
 * corner at the point (100, 50).
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class GRectExample extends GraphicsProgram {

	public void run() {
		GRect rect = new GRect(100, 50, 125, 60);
		rect.setFilled(true);
		rect.setColor(Color.RED);
		add(rect);
	}

}
