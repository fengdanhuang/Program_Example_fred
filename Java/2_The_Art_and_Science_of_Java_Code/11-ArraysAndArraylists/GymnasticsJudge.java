/*
 * File: GymnasticsJudge.java
 * --------------------------
 * This file reads in an array of scores and computes the
 * average.
 */

import acm.program.*;

public class GymnasticsJudge extends ConsoleProgram {

	public void run() {
		int nJudges = readInt("Enter number of judges: ");
		double[] scores = new double[nJudges];
		for (int i = 0; i < nJudges; i++) {
			scores[i] = readDouble("Score for judge " + i + ": ");
		}
		double total = 0;
		for (int i = 0; i < nJudges; i++) {
			total += scores[i];
		}
		double averageScore = total / nJudges;
		println("The average score is " + averageScore);
	}

}
