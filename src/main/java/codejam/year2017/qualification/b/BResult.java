package codejam.year2017.qualification.b;

import codejam.model.CaseResult;

public class BResult extends CaseResult<BProblem> {
	private final Number tidyNumber;

	public BResult(BProblem problem, Number tidyNumber) {
		super(problem);
		this.tidyNumber = tidyNumber;
	}

	@Override
	public String getCaseResult() {
		return tidyNumber.toString();
	}

}
