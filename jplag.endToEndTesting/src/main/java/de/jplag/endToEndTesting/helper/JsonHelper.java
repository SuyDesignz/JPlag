package de.jplag.endToEndTesting.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.RemoteStub;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import de.jplag.endToEndTesting.constants.Constant;
import model.ResultJsonModel;

public final class JsonHelper {

	private JsonHelper() {
		// private constructor to prevent instantiation
	}

	/**
	 * Parsing the old results in the json file as a list from ResultJsonModel.
	 * 
	 * @param pathToJsonFile
	 * @return list of saved results for the test cases
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public static List<ResultJsonModel> getResultModelFromPath()
			throws JsonMappingException, JsonProcessingException, Exception {
		return Arrays.asList(
				new ObjectMapper().readValue(Constant.BASE_PATH_TO_JAVA_RESULT_JSON.toFile(), ResultJsonModel[].class));
	}

	public static void writeTemporarResult(ResultJsonModel resultJsonModel)
			throws StreamWriteException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

		File resultObjectFile = Path
				.of(Constant.TEMPORARY_JSON_DIRECTORY_NAME, resultJsonModel.getFunctionName() + ".json").toFile();

		if (!resultObjectFile.getParentFile().exists()) {
			resultObjectFile.getParentFile().mkdirs();
		}

		writer.writeValue(resultObjectFile, resultJsonModel);
	}
}
