package codejam.year2017.qualification.a;

import static org.junit.Assert.*;

import org.junit.*;

import codejam.year2017.qualification.a.AProblem.Side;

public class AReaderTest {
	private AReader tested;
	private AProblem result;

	@Before
	public void setup() {
		tested = new AReader();
	}

	@Test
	public void readsSingleCase() {
		read("+- 1", 1);

		assertArrayEquals(new Side[] { Side.HAPPY, Side.BLANK }, result.row);
		assertEquals(1, result.flipperSize);
		assertEquals(0, result.index);
	}

	private void read(String input, int lineNumber) {
		result = tested.parse(input, lineNumber);
	}
}
