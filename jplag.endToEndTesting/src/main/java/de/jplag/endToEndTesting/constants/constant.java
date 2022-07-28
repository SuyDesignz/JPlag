package de.jplag.endToEndTesting.constants;

import java.nio.file.Path;

public final class constant {

	private constant() {
		// No need to instantiate the class, we can hide its constructor
	}

	// can be exchanged for a suitable standard path if necessary
	private static final String EMPTY_STRING = "";
	private static final String TEMP_DIRECTORY_NAME = "submission";
	private static final String TEMP_SYSTEM_DIRECTORY = "java.io.tmpdir";

	//constant final project strings
	public static final Path BASE_PATH_TO_JAVA_RESOURCES_SORTALGO = Path.of("src", "test", "resources", "java",
			"sortAlgo");
	public static final Path BASE_PATH_TO_JAVA_RESULT_XML = Path.of("src", "test", "resources", "results",
			"javaResult.xml");

	//xml-file constants
	public static final String XML_ROOT_FUNCTION_NODE_NAME = "testcase";
	public static final String XML_TEST_NAME_NODE= "testName";
	public static final String XML_TEST_RESULT_NODE_NAME = "testResult";
}
