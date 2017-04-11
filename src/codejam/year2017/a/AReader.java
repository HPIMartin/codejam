package codejam.year2017.a;

import codejam.*;
import codejam.year2017.a.AProblem.*;

public class AReader extends InputReader<AProblem> {
	public AReader() {
		super(1);
	}

	@Override
	protected AProblem parse(String line, int lineNumber) {
		String[] elements = line.split(" ");
		Side[] row = convert(elements[0]);
		Integer flipperSize = Integer.valueOf(elements[1]);
		int index = lineNumber - 1;
		return new AProblem(row, flipperSize, index);
	}

	private Side[] convert(String unconvertedRow) {
		Side[] row = new Side[unconvertedRow.length()];
		for (int i = 0; i < unconvertedRow.length(); i++)
			if (unconvertedRow.charAt(i) == '-')
				row[i] = Side.BLANK;
			else
				row[i] = Side.HAPPY;
		return row;
	}
}
