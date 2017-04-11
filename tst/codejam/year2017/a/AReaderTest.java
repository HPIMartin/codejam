package codejam.year2017.a;

import static org.junit.Assert.*;

import org.junit.*;

import codejam.year2017.a.*;
import codejam.year2017.a.AProblem.*;

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
