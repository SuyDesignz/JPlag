package de.jplag.endToEndTesting.constants;

import java.nio.file.Path;

/**
 * All constant values that are needed in the test cases or helper classes.
 *
 */
public final class Constant {

	private Constant() {
		// private constructor to prevent instantiation
	}

	/**
	 * Empty string to be able to query possible empty return values.
	 */
	public static final String EMPTY_STRING = "";
	/**
	 * Name for the folder to copy the submissions to in order to test them with
	 * JPlag
	 */
	public static final String TEMPORARY_DIRECTORY_NAME_SUBMISSION = "submission";
	public static final String TEMPORARY_DIRECTORY_NAME_JSON = "JPlagJsonResults";
	/**
	 * Identifier to find the system specific temporary directory.
	 */
	private static final String TEMPORARY_SYSTEM_DIRECTORY = "java.io.tmpdir";
	/**
	 * Create the complete path to the submission files. Here the temporary system
	 * path is extended with the "TEMPORARY_DIRECTORY_NAME", which is predefined in
	 * this class.
	 */

	public static final String TEMPORARY_SUBMISSION_DIRECTORY_NAME = Path
			.of(System.getProperty(TEMPORARY_SYSTEM_DIRECTORY), TEMPORARY_DIRECTORY_NAME_SUBMISSION).toString();

	public static final String TEMPORARY_JSON_DIRECTORY_NAME = Path
			.of(System.getProperty(TEMPORARY_SYSTEM_DIRECTORY), TEMPORARY_DIRECTORY_NAME_JSON).toString();
	/**
	 * Base path to the created plagiarism and the main file located in the project
	 * resources.
	 */
	public static final Path BASE_PATH_TO_JAVA_RESOURCES_SORTALGO = Path.of("src", "test", "resources", "java",
			"sortAlgo");
	/**
	 * Base path to the saved results of the previous tests in a *.json file
	 */
	public static final Path BASE_PATH_TO_JAVA_RESULT_JSON = Path.of("src", "test", "resources", "results",
			"javaResult.json");
}
