package codejam.year2017.qualification.b;

import static org.junit.Assert.*;

import org.junit.*;

public class BReaderTest {
	private BReader tested;
	private BProblem result;

	@Before
	public void setUp() {
		tested = new BReader();
	}

	@Test
	public void readsSingleCase() {
		read(tested);

		assertEquals("123", result.number);
		assertEquals(0, result.index);
	}

	private void read(BReader tested) {
		result = tested.parse("123", 1);
	}

}
