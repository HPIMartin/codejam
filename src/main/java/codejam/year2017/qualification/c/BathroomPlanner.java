package codejam.year2017.qualification.c;

import java.util.*;

import codejam.Logic;

public class BathroomPlanner implements Logic<CProblem, CResult> {
	private static final int RECURSION_DEPTH_TO_START = 1;

	private CProblem problem;
	private StallTreePosition requiredTreePosition;
	private List<Stall> lastStallRow;

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
		requiredTreePosition = calculateStallTreePosition();
		lastStallRow = new ArrayList<>();
		addNewStallToTree(RECURSION_DEPTH_TO_START, problem.numberOfStalls);
		return extractLastStallFromRow();
	}

	private StallTreePosition calculateStallTreePosition() {
		int largestPowerOfTwo = 2;
		while (largestPowerOfTwo <= problem.numberOfPeople)
			largestPowerOfTwo *= 2;
		largestPowerOfTwo = largestPowerOfTwo / 2;

		int row = (int) (Math.log(largestPowerOfTwo) / Math.log(2)) + 1;
		int column = (int) problem.numberOfPeople - largestPowerOfTwo;

		StallTreePosition position = new StallTreePosition(row, column);
		return position;
	}

	private void addNewStallToTree(int depth, long distanceToFill) {
		Stall newStall = calculateNextStallFor(distanceToFill);
		if (requiredTreePosition.row == depth) {
			lastStallRow.add(newStall);
			return;
		}

		int nextRowsDepth = depth + 1;
		addNextRowOfStallsToTree(newStall, nextRowsDepth);
	}

	private Stall calculateNextStallFor(long numberOfStalls) {
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

	private void addNextRowOfStallsToTree(Stall currentNode, int depth) {
		if (hasRoom(currentNode.leftDistance))
			addNewStallToTree(depth, currentNode.leftDistance);
		if (hasRoom(currentNode.rightDistance))
			addNewStallToTree(depth, currentNode.rightDistance);
	}

	private boolean hasRoom(long distance) {
		return distance != 0;
	}

	private CResult toResult(Stall stall) {
		long maxSpace = Math.max(stall.leftDistance, stall.rightDistance);
		long minSpace = Math.min(stall.leftDistance, stall.rightDistance);
		return new CResult(problem, maxSpace, minSpace);
	}

	private Stall extractLastStallFromRow() {
		lastStallRow.sort(StallComparator.INSTANCE);
		Stall lastStall = lastStallRow.get(requiredTreePosition.column);
		return lastStall;
	}
}
