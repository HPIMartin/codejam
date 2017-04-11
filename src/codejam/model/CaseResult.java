package codejam.model;

public abstract class CaseResult<T extends CaseProblem> {
	public final T problem;

	protected CaseResult(T problem) {
		this.problem = problem;
	}

	public abstract String getCaseResult();
}
