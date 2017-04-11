package codejam;

import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.stream.*;

import codejam.model.*;

public class OutputWriter<R extends CaseResult<?>> {
	public List<String> write(Stream<R> result) {
		return result.sorted(this::compare).map(this::create).collect(toList());
	}

	private String create(R result) {
		int caseNumber = result.problem.index + 1;
		return String.format("Case #%d: %s", caseNumber, result.getCaseResult());
	}

	private int compare(CaseResult<?> cr1, CaseResult<?> cr2) {
		return cr1.problem.index - cr2.problem.index;
	}
}
