package codejam.year2017.a;

public class APossibleResult extends AResult {
	public final int numberOfFlips;

	public APossibleResult(AProblem problem, int numberOfFlips) {
		super(problem);
		this.numberOfFlips = numberOfFlips;
	}

	@Override
	public String getCaseResult() {
		return String.valueOf(numberOfFlips);
	}
}
