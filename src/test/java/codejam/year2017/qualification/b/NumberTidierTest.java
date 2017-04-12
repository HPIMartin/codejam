package codejam.year2017.qualification.b;

import static org.junit.Assert.*;

import org.junit.*;

public class NumberTidierTest {
	private NumberTidier tested;
	private BProblem problem;
	private BResult result;

	@Before
	public void setUp() {
		tested = new NumberTidier();
	}

	@Test
	public void nothingToDo() {
		arrangeProblem("1");
		act();
		assertResult("1");
	}

	@Test
	public void oneStepTwoDigits() {
		arrangeProblem("20");
		act();
		assertResult("19");
	}

	@Test
	public void moreStepsTwoDigits() {
		arrangeProblem("21");
		act();
		assertResult("19");
	}

	@Test
	public void moreStepsTreeDigits() {
		arrangeProblem("321");
		act();
		assertResult("299");
	}

	@Test
	public void fromwoToOneDigit() {
		arrangeProblem("10");
		act();
		assertResult("9");
	}

	@Test
	public void fromThreeToTwoDigits() {
		arrangeProblem("110");
		act();
		assertResult("99");
	}

	@Test
	public void bugNo1() {
		arrangeProblem("441");
		act();
		assertResult("399");
	}

	@Test
	public void bugNo2() {
		arrangeProblem("391458953027532635");
		act();
		assertResult("389999999999999999");
	}

	private void arrangeProblem(String number) {
		problem = new BProblem(Number.fromString(number), 0);
	}

	private void act() {
		result = tested.apply(problem);
	}

	private void assertResult(String tidyNumber) {
		assertEquals(tidyNumber, result.getCaseResult());
	}
}
