package codejam.year2017.qualification.c;

import java.util.*;

import codejam.Logic;

public class BathroomPlanner implements Logic<CProblem, CResult> {
	private static final int RECURE_STALL_HIERARCHIE_START_INDEX = 0;

	private final CMath math;

	private CProblem problem;
	private StallCoordinates requiredTreePosition;
	private List<Stall> lastStallRow;

	public BathroomPlanner() {
		math = new CMath();
	}

	@Override
	public CResult apply(CProblem problem) {
		this.problem = problem;
		return toResult(getLastStall());
	}

	private Stall getLastStall() {
		if (isBathroomFull())
			return new Stall(0L, 0L);
		return distributePeopleToStalls();
	}

	private boolean isBathroomFull() {
		return problem.numberOfStalls == problem.numberOfPeople;
	}

	private Stall distributePeopleToStalls() {
		requiredTreePosition = getLastStallCoordinates();
		lastStallRow = new ArrayList<>();

		recurseNextStall(RECURE_STALL_HIERARCHIE_START_INDEX, problem.numberOfStalls);

		return extractLastStallFromRow();
	}

	private StallCoordinates getLastStallCoordinates() {
		long largestPowerOfTwo = math.largestPowerOfTwoIn(problem.numberOfPeople);
		double exponent = math.log2(largestPowerOfTwo);
		long rest = problem.numberOfPeople - largestPowerOfTwo;

		int row = (int) exponent;
		int column = (int) rest;

		return new StallCoordinates(row, column);
	}

	private void recurseNextStall(int depth, long distanceToFill) {
		/* TODO tidy up algorithm */
		Stall newStall = calculateNextStallFor(distanceToFill);
		if (requiredTreePosition.row == depth) {
			lastStallRow.add(newStall);
			return;
		}

		int nextRowsDepth = depth + 1;
		recurseNextStallRow(newStall, nextRowsDepth);
	}

	private Stall calculateNextStallFor(long numberOfStalls) {
		long right = math.half(numberOfStalls);
		long left = getDifferenceExcludingOccupiedStall(numberOfStalls, right);
		return new Stall(left, right);
	}

	private long getDifferenceExcludingOccupiedStall(long numberOfStalls, long right) {
		return numberOfStalls - right - 1L;
	}

	private void recurseNextStallRow(Stall currentNode, int depth) {
		if (hasRoomToSide(currentNode.leftDistance))
			recurseNextStall(depth, currentNode.leftDistance);

		if (hasRoomToSide(currentNode.rightDistance))
			recurseNextStall(depth, currentNode.rightDistance);
	}

	private boolean hasRoomToSide(long distance) {
		return distance != 0;
	}

	private CResult toResult(Stall stall) {
		long maxSpace = math.max(stall.leftDistance, stall.rightDistance);
		long minSpace = math.min(stall.leftDistance, stall.rightDistance);
		return new CResult(problem, maxSpace, minSpace);
	}

	private Stall extractLastStallFromRow() {
		lastStallRow.sort(StallComparator.INSTANCE);
		Stall lastStall = lastStallRow.get(requiredTreePosition.column);
		return lastStall;
	}
}
