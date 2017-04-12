package codejam.year2017.qualification.a;

import codejam.model.*;

public class AProblem extends CaseProblem {
	public enum Side {
		HAPPY, BLANK;
	}

	public final Side[] row;
	public final int flipperSize;

	public AProblem(Side[] row, int size, int index) {
		super(index);
		this.row = row;
		this.flipperSize = size;
	}
}
