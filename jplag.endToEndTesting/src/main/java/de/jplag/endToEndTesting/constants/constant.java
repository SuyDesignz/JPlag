package de.jplag.endToEndTesting.constants;

import java.nio.file.Path;

public final class constant {

	private constant() {
	    // No need to instantiate the class, we can hide its constructor
	  }
	
	public static final Path BASE_PATH_TO_JAVA_RESOURCES_SORTALGO = Path.of("src", "test", "resources", "java", "sortAlgo");
	public static final Path BASE_PATH_TO_JAVA_RESULT_XML = Path.of("src", "test", "resources", "results", "javaResult.xml");
	
	public static final String XML_ROOT_FUNCTION_NODE_NAME = "testcase";
}
