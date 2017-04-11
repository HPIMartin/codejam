package codejam;

import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class InputReaderTest {
	private TestReader tested;
	private List<TestProblem> result;

	@Before
	public void setup() {
		tested = new TestReader(1);
	}

	@Test
	public void ignoresFirstLine() {
		read("3");
		assertEquals(0, result.size());
	}

	@Test
	public void readsSingleCase() {
		read("toIgnore", "line");

		TestProblem c = result.get(0);
		assertEquals(1, c.index);
		assertEquals("line", c.content);
	}

	private void read(String... input) {
		result = tested.read(Arrays.asList(input)).collect(Collectors.toList());
	}

	private class TestReader extends InputReader<TestProblem> {
		protected TestReader(int linesToIgnore) {
			super(linesToIgnore);
		}

		@Override
		protected TestProblem parse(String line, int lineNumber) {
			return new TestProblem(lineNumber, line);
		}
	}
}
