package codejam;

import java.util.*;
import java.util.stream.*;

import codejam.model.*;

public abstract class InputReader<P extends CaseProblem> {
	private final int headlinesToIgnore;

	protected InputReader(int headlinesToIgnore) {
		this.headlinesToIgnore = headlinesToIgnore;
	}

	public Stream<P> read(List<String> fileInput) {
		return fileInput.stream().skip(headlinesToIgnore).parallel().map(s -> parse(s, fileInput.indexOf(s)));
	}

	protected abstract P parse(String line, int lineNumber);
}
