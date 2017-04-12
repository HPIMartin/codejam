package codejam.year2017.qualification;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import codejam.Application;
import codejam.OutputWriter;
import codejam.year2017.qualification.b.BProblem;
import codejam.year2017.qualification.b.BReader;
import codejam.year2017.qualification.b.BResult;
import codejam.year2017.qualification.b.NumberTidier;

@Ignore
public class ProblemBAcceptanceTest {
	private Application<BProblem, BResult> tested;

	@Before
	public void setup() {
		tested = new Application<>(new BReader(), NumberTidier::new, new OutputWriter<BResult>());
	}

	@Test
	public void givenExample() {
		List<String> result = tested.analyse(Arrays.asList("4", "132", "1000", "7", "111111111111111110"));
		assertEquals(Arrays.asList("Case #1: 129", "Case #2: 999", "Case #3: 7", "Case #4: 99999999999999999"), result);
	}

}
