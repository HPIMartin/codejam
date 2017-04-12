package codejam.year2017.qualification.b;

public class Number {
	private static final String LEADING_ZEROES_PATTERN = "^0+";

	public static Number fromString(String numberString) {
		numberString = removeLeadingZeroes(numberString);
		Digit[] digits = new Digit[numberString.length()];

		fillDigits(numberString, digits);

		return new Number(digits);
	}

	private static void fillDigits(String numberString, Digit[] digits) {
		for (int index = 0; index < numberString.length(); index++) {
			String stringRepresentation = numberString.substring(index, index + 1);
			digits[index] = getDigit(digits, index, stringRepresentation);
		}
	}

	private static Digit getDigit(Digit[] digits, int index, String stringRepresentation) {
		if (index == 0)
			return getFirstDigit(stringRepresentation);
		Digit formerDigit = digits[index - 1];
		return getFollowingDigit(formerDigit, index, stringRepresentation);
	}

	private static Digit getFirstDigit(String stringRepresentation) {
		DigitValue digitValue = DigitValue.fromString(stringRepresentation);
		return Digit.createFirstDigit(digitValue);
	}

	private static Digit getFollowingDigit(Digit formerDigit, int index, String stringRepresentation) {
		DigitValue digitValue = DigitValue.fromString(stringRepresentation);
		return formerDigit.createNextDigit(digitValue);
	}

	private static String removeLeadingZeroes(String line) {
		return line.replaceAll(LEADING_ZEROES_PATTERN, "");
	}

	public final Digit[] digits;

	private Number(Digit[] digits) {
		this.digits = digits;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < digits.length; i++)
			buffer.append(digits[i].toString());
		String string = buffer.toString();
		return removeLeadingZeroes(string);
	}
}