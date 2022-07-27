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
	
	
	public resultHelper(File resultXMLFile) 
	{
		this.resultXMLFile = resultXMLFile;
		load();
	}
	
	private void load()
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				Document document = builder.parse(resultXMLFile);
				NodeList tagNameList = document.getElementsByTagName("testcase");
				//ELEMENT_NODE ist testName und testResult
				for(int counter = 0; counter < tagNameList.getLength(); counter++)
				{
					Node p = tagNameList.item(counter);
					if(p.getNodeType() == Node.ELEMENT_NODE)
					{
						Element result = (Element)p;
						NodeList elementList = result.getChildNodes();
						for(int i = 0; i < elementList.getLength(); i++)
						{
							Node element = elementList.item(i);
							if(element.getNodeType()==Node.ELEMENT_NODE)
							{
								Element name = (Element) element;
								System.out.println(name.getTextContent());
							}
						}
						//var elementId = result.getAttribute("id");
						
					}
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
