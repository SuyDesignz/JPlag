package de.jplag.endToEndTesting.helper;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class resultHelper {
	private File resultXMLFile;
	private NodeList testCaseNodes;

	public resultHelper(File resultXMLFile) throws ParserConfigurationException, SAXException, IOException {
		this.resultXMLFile = resultXMLFile;

		loadTestCaseNodes();
	}

	/**
	 * compares the passed function name with the names in the xml list to load the
	 * results
	 * 
	 * @param functionName
	 * @return test result of the scanner for a specific test case
	 * @throws ParserConfigurationException
	 */
	public String getSavedTestResult(String functionName) throws ParserConfigurationException {
		for (int temp = 0; temp < testCaseNodes.getLength(); temp++) {
			Node node = testCaseNodes.item(temp);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				if (eElement.getElementsByTagName("testName").item(0).getTextContent().equalsIgnoreCase(functionName)) {
					return eElement.getElementsByTagName("testResult").item(0).getTextContent();
				}
			}
		}
		throw new ParserConfigurationException("no valid function name could be found!");
	}

	/**
	 * Loads individual test cases from the xml file to later load the results and
	 * other important information from them
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private void loadTestCaseNodes() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		builder = factory.newDocumentBuilder();
		Document document = builder.parse(resultXMLFile);
		testCaseNodes = document.getElementsByTagName("testcase");
	}
}
