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
	public void correctIndex() {
		read("");
		assertEquals(0, result.index);
	}

	@Test
	public void readSimpleCase() {
		read("123");
		assertNumber("123");
	}

	@Test
	public void readLeadingZero() {
		read("012");
		assertNumber("12");
	}

	private void assertNumber(String expected) {
		assertEquals(expected, result.number.toString());
	}

	private void read(String line) {
		result = tested.parse(line, 1);
	}

}
