package codejam.year2017.qualification.c;

import static org.junit.Assert.*;

import org.junit.*;

public class BathroomPlannerTest {
	private BathroomPlanner tested;
	private CProblem problem;
	private CResult result;

	@Before
	public void setUp() {
		tested = new BathroomPlanner();
	}

	@Test
	public void correctProblem() {
		arrangeProblemForStallsAndPeople(1L, 1L);
		act();
		assertEquals(problem, result.problem);
	}

	@Test
	public void oneStallOnePerson() {
		arrangeProblemForStallsAndPeople(1L, 1L);
		act();
		assertMaxMin("0 0");
	}

	@Test
	public void twoStallsTwoPeople() {
		arrangeProblemForStallsAndPeople(2L, 2L);
		act();
		assertMaxMin("0 0");
	}

	@Test
	public void twoStallsOnePerson() {
		arrangeProblemForStallsAndPeople(2L, 1L);
		act();
		assertMaxMin("1 0");
	}

	@Test
	public void threeStallsOnePerson() {
		arrangeProblemForStallsAndPeople(3L, 1L);
		act();
		assertMaxMin("1 1");
	}

	@Test
	public void threeStallsTwoPeople() {
		arrangeProblemForStallsAndPeople(3L, 2L);
		act();
		assertMaxMin("0 0");
	}

	@Test
	public void nineStallsThreePeople() {
		arrangeProblemForStallsAndPeople(9L, 3L);
		act();
		assertMaxMin("2 1");
	}

	@Test
	public void eightStallsThreePeople() {
		arrangeProblemForStallsAndPeople(8L, 3L);
		act();
		assertMaxMin("1 1");
	}

	@Test
	public void elveenStallsFivePeople() {
		arrangeProblemForStallsAndPeople(10L, 1L);
		act();
		assertMaxMin("2 2");
	}

	private void arrangeProblemForStallsAndPeople(long numberOfStalls, long numberOfPeople) {
		problem = new CProblem(0, numberOfStalls, numberOfPeople);
	}

	private void act() {
		result = tested.apply(problem);
	}

	private void assertMaxMin(String expectedMaxMin) {
		assertEquals(expectedMaxMin, result.getCaseResult());
	}
}
