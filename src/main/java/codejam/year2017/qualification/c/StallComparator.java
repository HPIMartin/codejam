package codejam.year2017.qualification.c;

import java.util.Comparator;

public class StallComparator implements Comparator<Stall> {
	public static final StallComparator INSTANCE = new StallComparator();

	@Override
	public int compare(Stall stall1, Stall stall2) {
		int minCompare = compareMin(stall2, stall1);
		if (isNotEqual(minCompare))
			return minCompare;

		return compareMax(stall2, stall1);
	}

	private int compareMin(Stall stall1, Stall stall2) {
		Long min1 = getMin(stall1);
		Long min2 = getMin(stall2);

		return min1.compareTo(min2);
	}

	private Long getMin(Stall stall) {
		long min = Math.min(stall.leftDistance, stall.rightDistance);
		return wrap(min);
	}

	private boolean isNotEqual(long minCompare) {
		return minCompare != 0;
	}

	private int compareMax(Stall o1, Stall o2) {
		Long max1 = getMax(o1);
		Long max2 = getMax(o2);

		return max1.compareTo(max2);
	}

	private Long getMax(Stall stall) {
		long max = Math.max(stall.leftDistance, stall.rightDistance);
		return wrap(max);
	}

	private Long wrap(long value) {
		return Long.valueOf(value);
	}

}
