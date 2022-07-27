package de.jplag.endToEndTesting.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import java.util.Arrays;

import javax.annotation.processing.FilerException;

public class jplagTestSuiteHelper {
	// can be exchanged for a suitable standard path if necessary
	private static final String EMPTY_STRING = "";
	private static final String TEMP_DIRECTORY_NAME = "submission";
	private static final String TEMP_SYSTEM_DIRECTORY = "java.io.tmpdir";

	private final File testFileLocation = Path.of("src", "test", "resources", "java", "SortAlgo").toFile();

	public String getFolderPath() {
		return tempFolderPath;
	}

	public String[] resourceNames() {
		return resourceNames;
	}

	private String[] resourceNames;
	private String tempFolderPath;
	private String[] classNames;

	public jplagTestSuiteHelper(String[] classNames) throws Exception {
		this.classNames = classNames;
		this.resourceNames = loadResource();
		this.tempFolderPath = getTempFolderPath();
		System.out.println(String.format("temp path at [%s]", this.tempFolderPath));

		createNewTestCaseDirectory();
	}

	/**
	 * Copies the passed filenames to a temporary path to use them in the tests
	 * 
	 * @throws Exception
	 */
	private void createNewTestCaseDirectory() throws Exception {
		// before copying files to the test path, check if all files are in the resource
		// directory
		for (String className : classNames) {
			if (!Arrays.asList(resourceNames).contains(className)) {
				throw new FileNotFoundException(
						String.format("The specified class could not be found! [%s]", className));
			}
		}
		// Copy the resources data to the temporary path
		for (int counter = 0; counter < classNames.length; counter++) {
			Path originalPath = Path.of(testFileLocation.getAbsolutePath(), classNames[counter]);
			Path copiePath = Path.of(tempFolderPath, TEMP_DIRECTORY_NAME + (counter + 1), classNames[counter]);
			try {
				File directory = new File(copiePath.toString());
				if (!directory.exists()) {
					directory.mkdirs();
				}

				System.out.println(String.format("Copy file from [%s] to [%s]", originalPath, copiePath));
				Files.copy(originalPath, copiePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				throw new FilerException(
						String.format("The specified file could not be copied! [%s] \n Exception [%s] ",
								classNames[counter], e.getMessage()));
			}
		}
	}

	/**
	 * loads the filenames in the specified resources
	 * 
	 * @return
	 */
	private String[] loadResource() {
		String[] pathnames;
		File f = new File(testFileLocation.getAbsolutePath());
		pathnames = f.list();
//		for (String pathname : pathnames) {
//			System.out.println(pathname);
//		}
		return pathnames;
	}

	/**
	 * Loads a suitable system path to temporarily store the test cases.
	 * 
	 * @return The temporary system folder, if any, or the path of the current
	 *         runtime environment
	 * @throws IOException
	 */
	private String getTempFolderPath() throws IOException {
		return !System.getProperty(TEMP_SYSTEM_DIRECTORY).isBlank()
				? Path.of(System.getProperty(TEMP_SYSTEM_DIRECTORY), TEMP_DIRECTORY_NAME).toString()
				: Path.of(new File(".").getCanonicalPath(), TEMP_DIRECTORY_NAME).toString();
	}

	/**
	 * Delete directory with including files
	 * 
	 * @param file
	 */
	private void deleteCopiedFiles(File folder) {
		File[] files = folder.listFiles();
		if (files != null) { // some JVMs return null for empty dirs
			for (File f : files) {
				if (f.isDirectory()) {
					deleteCopiedFiles(f);
				} else {
					System.out.println(String.format("Delete file in folder: [%s]", f.toString()));
					f.delete();
				}
			}
		}
		System.out.println(String.format("Delete folder: [%s]", folder.toString()));
		folder.delete();
	}

	/**
	 * The copied data should be deleted after instance closure
	 * 
	 * @throws Exception
	 */
	public void close() throws Exception {
		System.out.println("Class instance is terminated!");
		System.out.println(new File(tempFolderPath));
		deleteCopiedFiles(new File(tempFolderPath));
	}

}
