package com.ojn.gexf4j.core.impl.reader;

import static com.google.common.base.Preconditions.*;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public abstract class AbstractEntityParser<T extends Object> {

	private XMLStreamReader reader = null;
	private boolean foundEnd = false;
	
	protected abstract void onStartElement(XMLStreamReader reader);
	protected abstract void onEndElement();
	protected abstract void onCharacters(XMLStreamReader reader);
	protected abstract void onOther(XMLStreamReader reader, int eventType);
	protected abstract void onAttribute(String name, String value);
	
	public AbstractEntityParser(XMLStreamReader reader) {
		checkNotNull(reader);
		this.reader = reader;
	}
	
	protected void parse() {
		try {
			if (reader.getEventType() == XMLEvent.START_ELEMENT && reader.getAttributeCount() > 0) {
				for (int i = 0; i < reader.getAttributeCount(); i++) {
					onAttribute(reader.getAttributeLocalName(i),reader.getAttributeValue(i));
				}
			}
			
			while (!foundEnd && reader.hasNext()) {
				switch (reader.next()) {
					case XMLEvent.START_ELEMENT:
						System.out.print("START_ELEMENT\t");
						System.out.print(reader.getLocalName() + "\t");
						System.out.println("AttribCount: " + reader.getAttributeCount());
						onStartElement(reader);
						break;
						
					case XMLEvent.CHARACTERS:
						System.out.print("CHARACTERS\t");
						System.out.println("CHARS: " + reader.getText());
						onCharacters(reader);
						break;
						
					case XMLEvent.END_ELEMENT:
						System.out.println("END ELEMENT\t");
						foundEnd = true;
						break;
						
					default:
						System.out.println("DEFAULTED");
						onOther(reader, reader.getEventType());
						break;
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}