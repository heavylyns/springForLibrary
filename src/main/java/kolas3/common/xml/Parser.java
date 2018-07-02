package kolas3.common.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parser {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	String XML;
	String file;

	public Parser(String file) {
		this.file = file;
	}

	public void setValue(String value) {
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			saxParserFactory.setNamespaceAware(true);
			SAXParser saxParser = saxParserFactory.newSAXParser();
			GetXML getxml = new GetXML(value);
			saxParser.parse(this.file, getxml);
			this.XML = getxml.getValue();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}

	public String getValue() {
		return this.XML;
	}
}
