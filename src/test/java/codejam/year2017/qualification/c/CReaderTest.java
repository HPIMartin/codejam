package codejam.year2017.qualification.c;

import static org.junit.Assert.*;

import org.junit.*;

public class CReaderTest {
	private CReader tested;
	private CProblem result;

	@Before
	public void setUp() {
		tested = new CReader();
	}

	@Test
	public void correctIndex() {
		read("123 456");
		assertEquals(0, result.index);
	}

	@Test
	public void correctAmountOfStalls() {
		read("123 456");
		assertEquals(123, result.numberOfStalls);
	}

	@Test
	public void correctAmountOfPeople() {
		read("123 456");
		assertEquals(456, result.numberOfPeople);
	}

	private void read(String line) {
		result = tested.parse(line, 1);
	}

}
