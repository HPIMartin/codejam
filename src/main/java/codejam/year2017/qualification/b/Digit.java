package codejam.year2017.qualification.b;

public class Digit {
	public static Digit createFirstDigit(DigitValue value) {
		return new Digit(null, value);
	}

	private final Digit predecessor;

	public DigitValue value;

	private Digit(Digit predecessor, DigitValue value) {
		this.predecessor = predecessor;
		this.value = value;
	}

	public Digit createNextDigit(DigitValue value) {
		return new Digit(this, value);
	}

	@Override
	public String toString() {
		return value.toString();
	}

	public void minusOne() {
		value = value.getPredecessor();
		if (isNine(value))
			predecessorMinusOne();
	}

	private boolean isNine(DigitValue value) {
		return DigitValue.NINE.equals(value);
	}

	private void predecessorMinusOne() {
		predecessor.minusOne();
	}

	public boolean isGreaterThan(Digit digit) {
		return value.compareTo(digit.value) > 0;
	}
}