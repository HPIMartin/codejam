package codejam.year2017.qualification;

import java.util.function.Supplier;

import codejam.*;
import codejam.year2017.qualification.c.*;

public class ProblemCBathroomStalls extends Problem<CProblem, CResult> {
	@Override
	protected InputReader<CProblem> getReader() {
		return new CReader();
	}

	@Override
	protected Supplier<Logic<CProblem, CResult>> getLogic() {
		return BathroomPlanner::new;
	}
}
