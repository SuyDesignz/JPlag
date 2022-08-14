package de.jplag.end_to_end_testing.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import de.jplag.end_to_end_testing.model.JsonModel;
import de.jplag.end_to_end_testing.model.ResultModel;

/**
 * Helper class for serializing and creating all json dependent events.
 */
public final class JsonHelper {

    /**
     * private constructor to prevent instantiation
     */
    private JsonHelper() {
        // For Serialization
    }

    /**
     * Creates directory if it dose not exist
     * @param directory to be created
     * @throws IOException if the directory could not be created
     */
    private static void createDirectoryIfItDoseNotExist(File directory) throws IOException {
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException(createNewIOExceptionStringForFileOrFOlderCreation(directory));
        }
    }

    /**
     * Creates file if it dose not exist
     * @param file to be created
     * @throws IOException if the file could not be created
     */
    private static void createFileIfItDoseNotExist(File file) throws IOException {
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException(createNewIOExceptionStringForFileOrFOlderCreation(file));
        }
    }

    private static String createNewIOExceptionStringForFileOrFOlderCreation(File file) {
        return "The file/folder at the location [" + file.toString() + "] could not be created!";
    }

    /**
     * Parsing the old results in the json file as a list from ResultJsonModel.
     * @return list of saved results for the test cases
     * @param resultJsonPath Path to the stored test results
     * @throws IOException is thrown for all problems that may occur while parsing the json file. This includes both reading
     * and parsing problems.
     */
    public static List<JsonModel> getJsonModelListFromPath(Path resultJsonPath) throws IOException {
        if (resultJsonPath.toFile().exists() && resultJsonPath.toFile().length() > 0) {
            return Arrays.asList(new ObjectMapper().readValue(resultJsonPath.toFile(), JsonModel[].class));
        } else {
            return Collections.<JsonModel>emptyList();
        }
    }

    /**
     * Saves the passed object to the specified path
     * @param resultModel elements to be saved
     * @param temporaryResultDirectory path to the temporary storage location
     * @param functionName name of the function for which the element is to be saved
     * @param fileName the name of the file under which the object should be stored
     * @throws IOException Signals that an I/O exception of some sort has occurred. Thisclass is the general class of
     * exceptions produced by failed orinterrupted I/O operations.
     */
    public static void writeResultModelToJsonFile(ResultModel resultModel, String temporaryResultDirectory, String functionName, String fileName)
            throws IOException {
        // create an instance of DefaultPrettyPrinter
        // new DefaultPrettyPrinter()
        ObjectWriter writer = new ObjectMapper().writer();
        File temporaryDirectorie = Path.of(temporaryResultDirectory, functionName).toFile();
        File temporaryFile = Path.of(temporaryDirectorie.toString(), fileName).toFile();
        createDirectoryIfItDoseNotExist(temporaryDirectorie);
        createFileIfItDoseNotExist(temporaryFile);
        // convert book object to JSON file
        writer.writeValue(temporaryFile, resultModel);

    }

    /**
     * Saves the passed object as a json file to the given path
     * @param jsonModelList list of elements to be saved
     * @param temporaryResultDirectory path to the temporary storage location
     * @throws IOException Signals that an I/O exception of some sort has occurred. Thisclass is the general class of
     * exceptions produced by failed orinterrupted I/O operations.
     */
    public static void writeJsonModelsToJsonFile(List<JsonModel> jsonModelList, Path temporaryResultDirectory) throws IOException {
        // create an instance of DefaultPrettyPrinter
        // new DefaultPrettyPrinter()
        ObjectWriter writer = new ObjectMapper().writer();

        createDirectoryIfItDoseNotExist(temporaryResultDirectory.getParent().toFile());
        createFileIfItDoseNotExist(temporaryResultDirectory.toFile());

        // convert book object to JSON file

        writer.writeValue(temporaryResultDirectory.toFile(), jsonModelList.toArray());

    }

    /**
     * @param jsonFile json file which should be returned as object
     * @return the serialized object at the specified path
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of
     * exceptions produced by failed orinterrupted I/O operations.
     */
    public static ResultModel getResultModelFromPath(File jsonFile) throws IOException {
        return new ObjectMapper().readValue(jsonFile, ResultModel.class);
    }

}
