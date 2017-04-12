package codejam.year2017.qualification.a;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import codejam.year2017.qualification.a.AProblem;
import codejam.year2017.qualification.a.AResult;
import codejam.year2017.qualification.a.Flipper;
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
	public void nothingToFlip() {
		createProblem(2, Side.HAPPY, Side.HAPPY);
		act();
		isPossible(0);
	}

	@Test
	public void simplestFlip() {
		createProblem(2, Side.BLANK, Side.BLANK);
		act();
		isPossible(1);
	}

	@Test
	public void simplestTwoFlips() {
		createProblem(2, Side.BLANK, Side.HAPPY, Side.BLANK);
		act();
		isPossible(2);
	}

	@Test
	public void detectsImpossibleFlips() {
		createProblem(2, Side.BLANK, Side.HAPPY);
		act();
		isImpossible();
	}

	private void createProblem(int flipSize, Side... row) {
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
