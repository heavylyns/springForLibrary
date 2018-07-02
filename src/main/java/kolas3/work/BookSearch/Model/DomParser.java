package kolas3.work.BookSearch.Model;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DomParser {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	String xmlstring;

	public DomParser(String xmlstring) {
		this.xmlstring = xmlstring;
	}

	public Vector getValue() {
		Vector re = new Vector();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document document = dBuilder.parse(new InputSource(new StringReader(this.xmlstring.toString())));
			Element rootElement = document.getDocumentElement();
			NodeList nodeList = rootElement.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				String nodName = node.getNodeName();
				if (nodName.equals("metadata")) {
					ArrayList values = new ArrayList();
					NodeList subList = node.getChildNodes();
					for (int j = 0; j < subList.getLength(); j++) {
						Node subnode = subList.item(j);
						if (subnode.getNodeName().equals("riss.title")) {
							NodeList List = subnode.getChildNodes();
							Node lastnode = List.item(0);
							logger.debug(lastnode.getNodeValue());
							values.add(lastnode.getNodeValue());
						} else if (subnode.getNodeName().equals("riss.author")) {
							NodeList List = subnode.getChildNodes();
							Node lastnode = List.item(0);
							logger.debug(lastnode.getNodeValue());
							values.add(lastnode.getNodeValue());
						} else if (subnode.getNodeName().equals("riss.publisher")) {
							NodeList List = subnode.getChildNodes();
							Node lastnode = List.item(0);
							logger.debug(lastnode.getNodeValue());
							values.add(lastnode.getNodeValue());
						} else if (subnode.getNodeName().equals("riss.pubdate")) {
							NodeList List = subnode.getChildNodes();
							Node lastnode = List.item(0);
							logger.debug(lastnode.getNodeValue());
							values.add(lastnode.getNodeValue());
						} else if (subnode.getNodeName().equals("riss.mtype")) {
							NodeList List = subnode.getChildNodes();
							Node lastnode = List.item(0);
							logger.debug(lastnode.getNodeValue());
							values.add(lastnode.getNodeValue());
						} else if (subnode.getNodeName().equals("url")) {
							NodeList List = subnode.getChildNodes();
							Node lastnode = List.item(0);
							logger.debug(lastnode.getNodeValue());
							values.add(lastnode.getNodeValue());
						} else {
							values.add("&nbsp;");
						}
					}
					re.add(values);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			DocumentBuilder dBuilder;
			e.printStackTrace();
		} catch (IOException e) {
			DocumentBuilder dBuilder;
			e.printStackTrace();
		}
		return re;
	}

	public String getSelectValue(String setvalue, String setvalue2) {
		String re = "";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document document = dBuilder.parse(new InputSource(new StringReader(this.xmlstring.toString())));
			Element rootElement = document.getDocumentElement();
			NodeList nodeList = rootElement.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				String nodName = node.getNodeName();
				if (nodName.equals(setvalue)) {
					NodeList subList = node.getChildNodes();
					for (int j = 0; j < subList.getLength(); j++) {
						Node subnode = subList.item(j);
						if (subnode.getNodeName().equals(setvalue2)) {
							NodeList List = subnode.getChildNodes();
							Node lastnode = List.item(0);
							logger.debug(lastnode.getNodeValue());
							re = lastnode.getNodeValue();
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			DocumentBuilder dBuilder;
			e.printStackTrace();
		} catch (IOException e) {
			DocumentBuilder dBuilder;
			e.printStackTrace();
		}
		return re;
	}

	public ArrayList getSelectValues(String setvalue, String setvalue2) {
		ArrayList re = new ArrayList();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document document = dBuilder.parse(new InputSource(new StringReader(this.xmlstring.toString())));
			Element rootElement = document.getDocumentElement();
			NodeList nodeList = rootElement.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				String nodName = node.getNodeName();
				if (nodName.equals(setvalue)) {
					NodeList subList = node.getChildNodes();
					for (int j = 0; j < subList.getLength(); j++) {
						Node subnode = subList.item(j);
						if (subnode.getNodeName().equals(setvalue2)) {
							NodeList List = subnode.getChildNodes();
							Node lastnode = List.item(0);
							logger.debug("select add: " + lastnode.getNodeValue());
							re.add(lastnode.getNodeValue());
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			DocumentBuilder dBuilder;
			e.printStackTrace();
		} catch (IOException e) {
			DocumentBuilder dBuilder;
			e.printStackTrace();
		}
		return re;
	}

	public ArrayList autosearchlist(String setvalue) {
		ArrayList re = new ArrayList();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document document = dBuilder.parse(new InputSource(new StringReader(this.xmlstring.toString())));
			Element rootElement = document.getDocumentElement();
			NodeList nodeList = rootElement.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				NodeList subList = node.getChildNodes();
				if (subList.getLength() > 0) {
					Node idxnode = subList.item(0);
					if (idxnode.getNodeValue().equals(setvalue.substring(0, 1))) {
						for (int j = 1; j < subList.getLength(); j++) {
							Node subnode = subList.item(j);
							if (subnode.getNodeName().equals("data")) {
								NodeList List = subnode.getChildNodes();
								Node lastnode = List.item(0);
								if ((lastnode.getNodeValue().length() >= setvalue.length())
										&& (setvalue.equals(lastnode.getNodeValue().substring(0, setvalue.length())))) {
									re.add(lastnode.getNodeValue());
									if (re.size() >= 10) {
										return re;
									}
								}
							}
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			DocumentBuilder dBuilder;
			e.printStackTrace();
		} catch (IOException e) {
			DocumentBuilder dBuilder;
			e.printStackTrace();
		}
		return re;
	}
}
