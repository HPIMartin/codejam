package codejam;

import java.io.IOException;
import java.util.function.Supplier;

import codejam.model.*;

public abstract class Problem<P extends CaseProblem, R extends CaseResult<P>> {
	protected void solve(String[] args) {
		try {
			Application<P, R> application = new Application<>(getReader(), getLogic(), getWriter());
			application.run(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	protected abstract InputReader<P> getReader();

	protected abstract Supplier<Logic<P, R>> getLogic();

	protected OutputWriter getWriter() {
		return new OutputWriter();
	};
}
