package codejam.year2017.qualification;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import codejam.*;
import codejam.year2017.qualification.c.*;

public class ProblemCAcceptanceTest {
	private Application<CProblem, CResult> tested;
	private List<String> input;
	private List<String> result;

	@Before
	public void setup() {
		tested = new Application<>(new CReader(), BathroomPlanner::new, new OutputWriter());
	}

	@Test
	public void sample() {
		arrangeInput("5", "4 2", "5 2", "6 2", "1000 1000", "1000 1");
		act();
		assertResult("Case #1: 1 0", "Case #2: 1 0", "Case #3: 1 1", "Case #4: 0 0", "Case #5: 500 499");
	}

	// @Test
	// public void smallPractice() {
	//
	// }
	//
	// @Test
	// public void largePractice() {
	//
	// }

	private void assertResult(String... expected) {
		assertEquals(Arrays.asList(expected), result);
	}

	private void arrangeInput(String... content) {
		input = Arrays.asList(content);
	}

	private void act() {
		result = tested.analyse(input);
	}
}
