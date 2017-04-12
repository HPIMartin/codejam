package codejam.year2017.qualification;

import java.util.function.Supplier;

import codejam.*;
import codejam.year2017.qualification.a.*;

public class ProblemAOversizedPancakeFlipper extends Problem<AProblem, AResult> {
	@Override
	protected InputReader<AProblem> getReader() {
		return new AReader();
	}

	@Override
	protected Supplier<Logic<AProblem, AResult>> getLogic() {
		return Flipper::new;
	}

}
