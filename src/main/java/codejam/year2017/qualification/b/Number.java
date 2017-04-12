package codejam.year2017.qualification.b;

public class Number {
	private static final String LEADING_ZEROES_PATTERN = "^0+";

	public static Number fromString(String numberString) {
		numberString = removeLeadingZeroes(numberString);
		Digit[] digits = new Digit[numberString.length()];
		for (int i = 0; i < numberString.length(); i++) {
			String digit = numberString.substring(i, i + 1);
			if (i == 0)
				digits[i] = Digit.createFirstDigit(DigitValue.fromString(digit));
			else
				digits[i] = digits[i - 1].createNextDigit(DigitValue.fromString(digit));
		}

		return new Number(digits);
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