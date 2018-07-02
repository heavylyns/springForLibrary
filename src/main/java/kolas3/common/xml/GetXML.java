package kolas3.common.xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GetXML extends DefaultHandler {
	String setvalue;
	String XML;

	public GetXML(String setvalue) {
		this.setvalue = setvalue;
	}

	public void startElement(String uri, String localName, String qName, Attributes atts) {
		if (qName == this.setvalue) {
			for (int i = 0; i < atts.getLength(); i++) {
				this.XML = atts.getValue(i);
			}
		}
	}

	public String getValue() {
		return this.XML;
	}
}
