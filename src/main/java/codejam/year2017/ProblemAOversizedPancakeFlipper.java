package codejam.year2017;

import java.util.function.Supplier;

import codejam.InputReader;
import codejam.Logic;
import codejam.OutputWriter;
import codejam.Problem;
import codejam.year2017.qualification.a.AProblem;
import codejam.year2017.qualification.a.AReader;
import codejam.year2017.qualification.a.AResult;
import codejam.year2017.qualification.a.AWriter;
import codejam.year2017.qualification.a.Flipper;

public class ProblemAOversizedPancakeFlipper extends Problem<AProblem, AResult> {
	public static void main(String[] args) {
		new ProblemAOversizedPancakeFlipper().solve(args);
	}

	@Override
	protected InputReader<AProblem> getReader() {
		return new AReader();
	}

	@Override
	protected Supplier<Logic<AProblem, AResult>> getLogic() {
		return Flipper::new;
	}

	@Override
	protected OutputWriter<AResult> getWriter() {
		return new AWriter();
	}
}
