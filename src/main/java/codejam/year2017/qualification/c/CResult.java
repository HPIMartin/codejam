package codejam.year2017.qualification.c;

import codejam.model.CaseResult;

public class CResult extends CaseResult<CProblem> {
	public final long maxSpace;
	public final long minSpace;

	protected CResult(CProblem problem, long maxSpace, long minSpace) {
		super(problem);
		this.maxSpace = maxSpace;
		this.minSpace = minSpace;
	}

	@Override
	public String getCaseResult() {
		return String.format("%d %d", maxSpace, minSpace);
	}

}
