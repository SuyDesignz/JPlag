package de.jplag.end_to_end_testing.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import de.jplag.end_to_end_testing.constants.Constant;
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
     * Parsing the old results in the json file as a list from ResultJsonModel.
     * @return list of saved results for the test cases
     * @throws IOException is thrown for all problems that may occur while parsing the json file. This includes both reading
     * and parsing problems.
     */
    public static List<JsonModel> getResultModelFromPath() throws IOException {
        return Arrays.asList(new ObjectMapper().readValue(Constant.BASE_PATH_TO_JAVA_RESULT_JSON.toFile(), JsonModel[].class));
    }

	public static void writeTemporarResultModel(ResultModel resultModel)
			throws StreamWriteException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

		File resultObjectFile = Path
				.of(Constant.TEMPORARY_JSON_DIRECTORY_NAME, resultModel.getTestIdentifier() + ".json").toFile();

		if (!resultObjectFile.getParentFile().exists()) {
			resultObjectFile.getParentFile().mkdirs();
		}

		writer.writeValue(resultObjectFile, resultModel);
	}

}

