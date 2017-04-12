package codejam;

import codejam.model.*;

public interface Logic<P extends CaseProblem, R extends CaseResult<P>> {
	R apply(P problem);
}
