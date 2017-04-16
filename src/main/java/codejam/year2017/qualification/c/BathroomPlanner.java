package codejam.year2017.qualification.c;

import codejam.Logic;

public class BathroomPlanner implements Logic<CProblem, CResult> {
	private long numberOfAllStalls;
	private long numberOfAllPeople;

	@Override
	public CResult apply(CProblem problem) {
		this.numberOfAllStalls = problem.numberOfStalls;
		this.numberOfAllPeople = problem.numberOfPeople;

		return toResult(problem, getLastStall());
	}

	private Stall getLastStall() {
		if (isBathroomFull())
			return new Stall(0L, 0L);
		return distributePeopleToStalls();
	}

	private boolean isBathroomFull() {
		return numberOfAllStalls == numberOfAllPeople;
	}

	private Stall distributePeopleToStalls() {
		long lastPos = 0L;
		for (long position = 1L; position <= numberOfAllPeople; position++) {

			lastPos = numberOfAllPeople / position;

		}
		return nextStall;
	}

	private Stall getStall(long length) {

	}

	// private Stall distributePeopleToStalls() {
	// Stall nextStall = null;
	// long staticPosition = 1L;
	// for (long position = 1L; position <= numberOfAllPeople; position++) {
	// long offset = 0L;
	// if (position == staticPosition * 2L)
	// staticPosition = position;
	// else if (isEven(numberOfAllStalls))
	// offset = 1;
	//
	// nextStall = calculateNextStall(staticPosition, offset);
	// }
	// return nextStall;
	// }

	private Stall calculateNextStall(long currentStallNumber, long offset) {
		if (currentStallNumber == 1)
			return calculateStallForPosition(numberOfAllStalls);

		long stallsInScope = calculateStallsInScope(numberOfAllStalls, currentStallNumber);
		return calculateStallForPosition(stallsInScope - offset);
	}

	private long calculateStallsInScope(long totalStallNumber, long currentStallNumber) {
		long stallsInScope = 0L;
		stallsInScope = totalStallNumber / currentStallNumber;
		return stallsInScope;
	}

	private boolean isEven(long number) {
		return mod2(number) == 0;
	}

	private boolean isOdd(long number) {
		return mod2(number) != 0;
	}

	private long mod2(long number) {
		return number % 2;
	}

	private Stall calculateStallForPosition(long numberOfStalls) {
		long right = getHalf(numberOfStalls);
		long left = getRestExcludingOccupiedStall(numberOfStalls, right);
		return new Stall(left, right);
	}

	private long getHalf(long numberOfStalls) {
		return numberOfStalls / 2;
	}

	private long getRestExcludingOccupiedStall(long numberOfStalls, long right) {
		return numberOfStalls - 1 - right;
	}

	private CResult toResult(CProblem problem, Stall stall) {
		long maxSpace = Math.max(stall.distanceLeft, stall.distanceRight);
		long minSpace = Math.min(stall.distanceLeft, stall.distanceRight);
		return new CResult(problem, maxSpace, minSpace);
	}
}
