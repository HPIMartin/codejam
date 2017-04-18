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

	private void recurseNextStall2(int index, long emptyStallSpace) {
		/* TODO tidy up algorithm */

		while (true) {
			/* get next stall */
			long right = math.half(emptyStallSpace);
			long left = emptyStallSpace - right - 1L;
			Stall newStall = new Stall(left, right);

			/* check */
			if (requiredTreePosition.row == index) {
				lastStallRow.add(newStall);

			} else {
				index++;

				/* recurse further if row not yet matched */
				if (hasRoomToSide(newStall.leftDistance))
					recurseNextStall(index, newStall.leftDistance);

				if (hasRoomToSide(newStall.rightDistance))
					recurseNextStall(index, newStall.rightDistance);
			}

			break;
		}
	}

	private void recurseNextStall(int index, long emptyStallSpace) {
		/* TODO tidy up algorithm */

		/* get next stall */
		long right = math.half(emptyStallSpace);
		long left = emptyStallSpace - right - 1L;
		Stall newStall = new Stall(left, right);

		/* check */
		if (requiredTreePosition.row == index) {
			lastStallRow.add(newStall);
			return;
		}

		/* recurse further if row not yet matched */
		int nextIndex = index + 1;
		recurseNextStallRow(newStall, nextIndex);
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
