package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

public class StringEntityParser extends AbstractEntityParser<String> {

	private String name = "";
	private String value = "";
	
	public StringEntityParser(XMLStreamReader reader) {
		super(reader);
		name = reader.getLocalName();
		parse();
	}

	@Override
	protected void onCharacters(XMLStreamReader reader) {
		value = reader.getText();
	}

	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	protected void onOther(XMLStreamReader reader, int eventType) {
		// do nothing
	}

	@Override
	protected void onStartElement(XMLStreamReader reader) {
		// do nothing
	}

	@Override
	protected void onAttribute(String name, String value) {
		// do nothing
	}

	@Override
	protected void onEndElement() {
		// do nothing
	}
}