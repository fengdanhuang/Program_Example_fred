/*
 * File: TicTacToeBoard.java
 * -------------------------
 * This program draws a Tic-Tac-Toe board as an illustration
 * of the GLine class.  The version uses explicit coordinate
 * values which makes the program difficult to extend or
 * maintain.  In Chapter 3, you will learn how to constants
 * and expressions to calculate these coordinate values.
 */

import acm.graphics.*;
import acm.program.*;

public class TicTacToeBoard extends GraphicsProgram {

	public void run() {
		add(new GLine(130, 60, 220, 60));
		add(new GLine(130, 90, 220, 90));
		add(new GLine(160, 30, 160, 120));
		add(new GLine(190, 30, 190, 120));
	}

}
