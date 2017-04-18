package codejam.year2017.qualification.c;

public class CMath {
	public long half(long number) {
		return number / 2L;
	}

	public long max(long number1, long number2) {
		return Math.max(number1, number2);
	}

	public long min(long number1, long number2) {
		return Math.min(number1, number2);
	}

	public double log2(long number) {
		return log(number) / log(2L);
	}

	public long largestPowerOfTwoIn(long number) {
		long largestPowerOfTwo = 2L;
		while (largestPowerOfTwo <= number)
			largestPowerOfTwo *= 2L;
		largestPowerOfTwo = largestPowerOfTwo / 2L;

		return largestPowerOfTwo;
	}

	private double log(long number) {
		return Math.log(number);
	}
}
