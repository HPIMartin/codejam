package codejam.year2017;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import codejam.*;
import codejam.year2017.a.*;

public class ProblemAAcceptanceTest {
	private Application<AProblem, AResult> tested;

	@Before
	public void setup() {
		tested = new Application<>(new AReader(), Flipper::new, new OutputWriter<AResult>());
	}

	@Test
	public void givenExample() {
		List<String> result = tested.analyse(Arrays.asList("3", "---+-++- 3", "+++++ 4", "-+-+- 4"));
		assertEquals(Arrays.asList("Case #1: 3", "Case #2: 0", "Case #3: IMPOSSIBLE"), result);
	}
}
