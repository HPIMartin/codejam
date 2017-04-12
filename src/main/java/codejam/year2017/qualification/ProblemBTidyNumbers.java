package codejam.year2017.qualification;

import java.util.function.Supplier;

import codejam.*;
import codejam.year2017.qualification.b.*;

public class ProblemBTidyNumbers extends Problem<BProblem, BResult> {
	@Override
	protected InputReader<BProblem> getReader() {
		return new BReader();
	}

	@Override
	protected Supplier<Logic<BProblem, BResult>> getLogic() {
		return NumberTidier::new;
	}
}
