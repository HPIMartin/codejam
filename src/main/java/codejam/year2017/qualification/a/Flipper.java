package codejam.year2017.qualification.a;

import java.util.*;

import codejam.*;
import codejam.year2017.qualification.a.AProblem.*;

public class Flipper implements Logic<AProblem, AResult> {
	private Side[] row;
	private int flipCounter = 0;

	@Override
	public AResult apply(AProblem problem) {
		row = Arrays.copyOf(problem.row, problem.row.length);
		perfomFlips(problem.flipperSize);
		return createFlippingResult(problem);
	}

	private void perfomFlips(int flipperSize) {
		int lastFlipPosition = row.length - flipperSize;
		for (int position = 0; position <= lastFlipPosition; position++) {
			if (row[position] == Side.BLANK) {
				row = flip(row, position, flipperSize);
				flipCounter++;
			}
		}
	}

	private Side[] flip(Side[] row, int position, int flipperSize) {
		for (int i = position; i < position + flipperSize; i++)
			row[i] = row[i] == Side.BLANK ? Side.HAPPY : Side.BLANK;
		return row;
	}

	private AResult createFlippingResult(AProblem problem) {
		boolean wasImpossible = Arrays.stream(row).anyMatch(Side.BLANK::equals);
		if (wasImpossible)
			return new AImpossibleResult(problem);
		return new APossibleResult(problem, flipCounter);
	}

}
