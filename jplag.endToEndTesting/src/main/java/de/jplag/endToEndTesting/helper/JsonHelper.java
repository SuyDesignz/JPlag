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

public class JsonHelper {

	public static List<ResultJsonModel> getResultModelFromPath(String pathToJsonFile)
			throws JsonMappingException, JsonProcessingException, Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		return Arrays.asList(objectMapper.readValue(Paths.get(pathToJsonFile).toFile(), ResultJsonModel[].class));
	}

	public static void writeTemporarResult(ResultJsonModel resultJsonModel)
			throws StreamWriteException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

		File resultObjectFile = Path.of(System.getProperty(Constant.TEMPORARY_SYSTEM_DIRECTORY),
				Constant.TEMPORARY_DIRECTORY_NAME_JSON, resultJsonModel.getFunctionName() + ".json").toFile();

		if (!resultObjectFile.getParentFile().exists()) {
			resultObjectFile.getParentFile().mkdirs();
		}

		writer.writeValue(resultObjectFile, resultJsonModel);
	}
}
