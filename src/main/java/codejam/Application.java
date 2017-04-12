package codejam;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import codejam.model.*;

public class Application<P extends CaseProblem, R extends CaseResult<P>> {
	private static final String INPUT_EXTENSION_PATTERN = "(\\.in)$";
	private static final String OUTPUT_EXTENSION = ".out";

	private final InputReader<P> reader;
	private final Supplier<Logic<P, R>> logic;
	private final OutputWriter writer;

	public Application(InputReader<P> reader, Supplier<Logic<P, R>> logic, OutputWriter writer) {
		this.reader = reader;
		this.logic = logic;
		this.writer = writer;
	}

	public void run(String filePath) throws IOException {
		List<String> result = analyse(Files.readAllLines(Paths.get(filePath)));
		Path outFilePath = Paths.get(filePath.replaceAll(INPUT_EXTENSION_PATTERN, OUTPUT_EXTENSION));
		Files.write(outFilePath, result, Charset.defaultCharset());
	}

	public List<String> analyse(List<String> fileInput) {
		Stream<P> cases = reader.read(fileInput);
		Stream<CaseResult<?>> result = cases.map(x -> logic.get().apply(x));
		return writer.write(result);
	}
}
