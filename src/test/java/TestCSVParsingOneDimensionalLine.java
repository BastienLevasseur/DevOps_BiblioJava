import org.junit.After;
import org.junit.Test;

import main.java.DataFrame;
/**
 * These tests only check if the parsing handles errors correctly, they do <b>NOT</b> check for the correctness of the DataFrame.
 * This specifically checks for one-dimensional CSV.
 */
//So we can't hit 100% code coverage with this test only.
public class TestCSVParsingOneDimensionalLine {

	private DataFrame<String, String, Object> dataFrameCSV;

	private static final String PATH_CORRECT_LINE = "src/test/resources/CSVOneDimLineCorrect.csv";

	private static final String PATH_CORRECT_COL = "src/test/resources/CSVOneDimColCorrect.csv";
	private static final String PATH_INCORRECT_VALUE = "src/test/resources/CSVOneDimColIncorrectValue.csv";

	private static final String PATH_EMPTY = "src/test/resources/CSVEmpty.csv";

	@After
	public void endTest() {
		this.dataFrameCSV = null;
	}


	/**
	 * Check if no errors are thrown while parsing a correct one-dimensional column correct CSV.
	 */
	@Test
	public void testParsingCorrectCSVOneDimCol() throws Exception {
		dataFrameCSV = new DataFrame<>(PATH_CORRECT_COL, ';');
	}


	/**
	 * Check if no errors are thrown while parsing a correct one-dimensional column correct CSV.
	 */
	@Test
	public void testParsingCorrectCSVOneDimLine() throws Exception {
		dataFrameCSV = new DataFrame<>(PATH_CORRECT_LINE, ';');
	}


	/**
	 * Check if a IllegalArgumentException is thrown while parsing a one-dimensional column CSV with inconsistent types.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testParsingIncorrectCSVOneDimColInconsistentValues() throws Exception {
		dataFrameCSV = new DataFrame<>(PATH_INCORRECT_VALUE, ';');
	}


	/**
	 * Check if a IllegalArgumentException is thrown while parsing an empty CSV.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCSVEmpty() throws Exception {
		dataFrameCSV = new DataFrame<>(PATH_EMPTY, ';');
	}
}
