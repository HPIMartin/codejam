package codejam;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import codejam.model.*;

public class OutputWriterTest {
	private OutputWriter<TestResult> tested;
	private List<TestResult> input;
	private List<String> result;

	@Before
	public void setUp() {
		tested = new OutputWriter<>();
		input = new ArrayList<>();
	}

	@Test
	public void writesOutput() {
		createOutput(0);
		write();
		is("Case #1: 0");
	}

	@Test
	public void sortsOutput() {
		createOutput(1);
		createOutput(0);
		write();
		is("Case #1: 0", "Case #2: 1");
	}

	private void createOutput(int index) {
		input.add(new TestResult(index));
	}

	private void write() {
		result = tested.write(input.stream());
	}

	private void is(String... expected) {
		assertArrayEquals(expected, result.toArray(new String[result.size()]));
	}

	private class TestResult extends CaseResult<TestProblem> {
		private TestResult(int index) {
			super(new TestProblem(index, ""));
		}

		@Override
		public String getCaseResult() {
			return String.valueOf(problem.index);
		}

	}
}
