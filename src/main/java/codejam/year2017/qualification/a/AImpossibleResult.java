package codejam.year2017.qualification.a;

public class AImpossibleResult extends AResult {
	public AImpossibleResult(AProblem problem) {
		super(problem);
	}

	@Override
	public String getCaseResult() {
		return "IMPOSSIBLE";
	}
}