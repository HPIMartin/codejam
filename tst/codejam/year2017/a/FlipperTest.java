package codejam.year2017.a;

import static org.junit.Assert.*;

import org.junit.*;

import codejam.year2017.a.AProblem.*;

public class FlipperTest {
	private Flipper tested;
	private AProblem problem;
	private AResult solution;

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
		solution = tested.apply(problem);
	}

	private void isPossible(int flips) {
		assertEquals(problem, solution.problem);
		assertEquals(String.valueOf(flips), solution.getCaseResult());
	}

	private void isImpossible() {
		assertEquals(problem, solution.problem);
		assertEquals("IMPOSSIBLE", solution.getCaseResult());
	}
}
