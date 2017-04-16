package codejam.year2017.qualification.a;

import static org.junit.Assert.*;

import org.junit.*;

import codejam.year2017.qualification.a.AProblem.Side;

public class FlipperTest {
	private Flipper tested;
	private AProblem problem;
	private AResult result;

	@Before
	public void setup() {
		tested = new Flipper();
	}

	@Test
	public void correctProblem() {
		arrangeProblem(2, Side.HAPPY, Side.HAPPY);
		act();
		assertEquals(problem, result.problem);
	}

	@Test
	public void nothingToFlip() {
		arrangeProblem(2, Side.HAPPY, Side.HAPPY);
		act();
		isPossible(0);
	}

	@Test
	public void simplestFlip() {
		arrangeProblem(2, Side.BLANK, Side.BLANK);
		act();
		isPossible(1);
	}

	@Test
	public void simplestTwoFlips() {
		arrangeProblem(2, Side.BLANK, Side.HAPPY, Side.BLANK);
		act();
		isPossible(2);
	}

	@Test
	public void detectsImpossibleFlips() {
		arrangeProblem(2, Side.BLANK, Side.HAPPY);
		act();
		isImpossible();
	}

	private void arrangeProblem(int flipSize, Side... row) {
		problem = new AProblem(row, flipSize, 0);
	}

	private void act() {
		result = tested.apply(problem);
	}

	private void isPossible(int flips) {
		assertEquals(problem, result.problem);
		assertEquals(String.valueOf(flips), result.getCaseResult());
	}

	private void isImpossible() {
		assertEquals(problem, result.problem);
		assertEquals("IMPOSSIBLE", result.getCaseResult());
	}
}
