package codejam.year2017.qualification.c;

import codejam.model.CaseProblem;

public class CProblem extends CaseProblem {
	public final long numberOfStalls;
	public final long numberOfPeople;

	public CProblem(int index, long numberOfStalls, long numberOfPeople) {
		super(index);
		this.numberOfStalls = numberOfStalls;
		this.numberOfPeople = numberOfPeople;
	}
}
