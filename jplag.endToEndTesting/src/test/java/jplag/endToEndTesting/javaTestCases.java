package jplag.endToEndTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.jplag.JPlag;
import de.jplag.JPlagResult;
import de.jplag.endToEndTesting.constants.constant;
import de.jplag.endToEndTesting.helper.jplagTestSuiteHelper;
import de.jplag.endToEndTesting.helper.resultHelper;
import de.jplag.options.JPlagOptions;
import de.jplag.options.LanguageOption;

class javaTestCases {
	// private final Logger logger = LoggerFactory.getLogger("JPlag-Test");

	private resultHelper resultHelper;

	@BeforeEach
	public void setUp() {
		assertTrue(constant.BASE_PATH_TO_JAVA_RESOURCES_SORTALGO.toFile().exists(), "Could not find base directory!");
		try {
			System.out.println(constant.BASE_PATH_TO_JAVA_RESULT_XML.toAbsolutePath());
			assertTrue(constant.BASE_PATH_TO_JAVA_RESULT_XML.toFile().exists(), "Could not find java result xml!");
			resultHelper = new resultHelper(constant.BASE_PATH_TO_JAVA_RESULT_XML.toFile());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(false, e.getMessage());
		}
		
	}

	/**
	 * Inserting comments or empty lines (normalization level)
	 */
	@Test
	void normalizationLevelTest_one() {
		String[] testClassNames = new String[] { "SortAlgo.java", "SortAlgo1.java" };

		try {
			jplagTestSuiteHelper testSuiteHelper = new jplagTestSuiteHelper(testClassNames);
			List<String> tempList = new ArrayList<String>();
			tempList.add(testSuiteHelper.getFolderPath());

			JPlagOptions options = new JPlagOptions(tempList, new ArrayList<String>(), LanguageOption.JAVA);

			JPlag jplag = new JPlag(options);
			JPlagResult result = jplag.run();
			// after close the created directories are deleted
			testSuiteHelper.close();

		} catch (Exception e) {
			assertTrue(false, e.getMessage());
		}
	}

	/**
	 * Changing variable names or function names (normalization level)
	 */
	@Test
	void normalizationLevelTest_two() {
		String[] testClassNames = new String[] { "SortAlgo.java", "SortAlgo2.java" };

		try {
			jplagTestSuiteHelper testSuiteHelper = new jplagTestSuiteHelper(testClassNames);
			List<String> tempList = new ArrayList<String>();
			tempList.add(testSuiteHelper.getFolderPath());

			JPlagOptions options = new JPlagOptions(tempList, new ArrayList<String>(), LanguageOption.JAVA);

			JPlag jplag = new JPlag(options);
			JPlagResult result = jplag.run();
			// after close the created directories are deleted
			testSuiteHelper.close();

		} catch (Exception e) {
			assertTrue(false, e.getMessage());
		}
	}

	/**
	 * Inserting comments or empty lines (normalization level)
	 */
	@Test
	void normalizationLevelTest_three() {
		String[] testClassNames = new String[] { "SortAlgo1.java", "SortAlgo2.java" };

		try {
			jplagTestSuiteHelper testSuiteHelper = new jplagTestSuiteHelper(testClassNames);
			List<String> tempList = new ArrayList<String>();
			tempList.add(testSuiteHelper.getFolderPath());

			JPlagOptions options = new JPlagOptions(tempList, new ArrayList<String>(), LanguageOption.JAVA);

			JPlag jplag = new JPlag(options);
			JPlagResult result = jplag.run();
			// after close the created directories are deleted
			testSuiteHelper.close();

		} catch (Exception e) {
			assertTrue(false, e.getMessage());
		}
	}
}
