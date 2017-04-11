package codejam;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import codejam.model.*;

public class Application<P extends CaseProblem, R extends CaseResult<P>> {
	private final InputReader<P> reader;
	private final Supplier<Logic<P, R>> logic;
	private final OutputWriter<R> writer;

	public Application(InputReader<P> reader, Supplier<Logic<P, R>> logic, OutputWriter<R> writer) {
		this.reader = reader;
		this.logic = logic;
		this.writer = writer;
	}

	public void run(String filePath) throws IOException {
		List<String> result = analyse(Files.readAllLines(Paths.get(filePath)));
		Files.write(Paths.get(filePath + ".result"), result, Charset.defaultCharset());
	}

	public List<String> analyse(List<String> fileInput) {
		Stream<P> cases = reader.read(fileInput);
		Stream<R> result = cases.map(x -> logic.get().apply(x));
		return writer.write(result);
	}
}
