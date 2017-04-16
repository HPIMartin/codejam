package codejam.year2017.qualification.c;

import codejam.InputReader;

public class CReader extends InputReader<CProblem> {
	public CReader() {
		super(1);
	}

	@Override
	protected CProblem parse(String line, int lineNumber) {
		int index = lineNumber - 1;

		String[] splitLine = line.split(" ");
		long numberOfStalls = parseLong(splitLine[0]);
		long numberOfPeople = parseLong(splitLine[1]);

		return new CProblem(index, numberOfStalls, numberOfPeople);
	}

	private long parseLong(String string) {
		return Long.parseLong(string);
	}
}
