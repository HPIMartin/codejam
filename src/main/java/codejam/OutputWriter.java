package codejam;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;

import codejam.model.CaseResult;

public class OutputWriter {
	public List<String> write(Stream<CaseResult<?>> result) {
		return result.sorted(this::compare).map(this::create).collect(toList());
	}

	private String create(CaseResult<?> result) {
		int caseNumber = result.problem.index + 1;
		return String.format("Case #%d: %s", caseNumber, result.getCaseResult());
	}

	private int compare(CaseResult<?> cr1, CaseResult<?> cr2) {
		return cr1.problem.index - cr2.problem.index;
	}
}
