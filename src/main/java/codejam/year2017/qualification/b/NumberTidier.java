package codejam.year2017.qualification.b;

import codejam.Logic;

public class NumberTidier implements Logic<BProblem, BResult> {

	private Number number;

	@Override
	public BResult apply(BProblem problem) {
		number = problem.number;
		tidyNumber();
		return new BResult(problem, number);
	}

	private void tidyNumber() {
		tidyForwards();
		tidyBackwards();
	}

	private void tidyForwards() {
		int lastIndex = number.digits.length - 1;
		for (int index = 0; index < lastIndex; index++)
			tidyAt(index);
	}

	private void tidyAt(int index) {
		if (isDigitGreaterThanNextDigitAt(index)) {
			minusOne(index);
			setRemainingDigitsToNine(index);
			adaptGreaterDigitsBefore(index);
		}
	}

	private boolean isDigitGreaterThanNextDigitAt(int position) {
		Digit digit = number.digits[position];
		Digit nextDigit = number.digits[position + 1];
		return digit.isGreaterThan(nextDigit);
	}

	private void minusOne(int position) {
		number.digits[position].minusOne();
	}

	private void setRemainingDigitsToNine(int currentPosition) {
		int startPosition = currentPosition + 1;
		for (int position = startPosition; position < number.digits.length; position++)
			number.digits[position].value = DigitValue.NINE;
	}

	private void adaptGreaterDigitsBefore(int position) {
		for (int j = position; j > 0; j--) {
			int nextIndex = j - 1;
			if (isDigitGreaterThanNextDigitAt(nextIndex))
				minusOne(j);
		}
	}

	private void tidyBackwards() {
		int secondLastIndex = number.digits.length - 2;
		for (int index = secondLastIndex; index >= 0; index--)
			tidyAt(index);
	}
}
