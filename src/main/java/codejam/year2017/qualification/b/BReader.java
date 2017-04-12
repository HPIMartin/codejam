package codejam.year2017.qualification.b;

import codejam.InputReader;

public class BReader extends InputReader<BProblem> {
	public BReader() {
		super(1);
	}

	@Override
	protected BProblem parse(String line, int lineNumber) {
		Number number = Number.fromString(line);
		int index = lineNumber - 1;
		return new BProblem(number, index);
	}
}
