package codejam.year2017.qualification.b;

public enum DigitValue {
	ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9");

	private final String representation;

	private DigitValue(String representation) {
		this.representation = representation;
	}

	@Override
	public String toString() {
		return representation;
	}

	public static DigitValue fromString(String representation) {
		switch (representation) {
		case "0":
			return ZERO;
		case "1":
			return ONE;
		case "2":
			return TWO;
		case "3":
			return THREE;
		case "4":
			return FOUR;
		case "5":
			return FIVE;
		case "6":
			return SIX;
		case "7":
			return SEVEN;
		case "8":
			return EIGHT;
		case "9":
			return NINE;
		default:
			throw new IllegalArgumentException(String.format("Undefined digit: %s", representation));
		}
	}

	public DigitValue getPredecessor() {
		int position = ordinal();
		if (position == 0)
			return NINE;
		return values()[position - 1];
	}
}