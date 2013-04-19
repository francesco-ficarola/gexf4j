package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class ValueEntityWriter<T extends Object> extends AbstractEntityWriter<T> {
	private static final String ATTRIB_VALUE = "value";
	
	private String name = "";
	
	public ValueEntityWriter(XMLStreamWriter writer, String name, T value) {
		super(writer, value);
		this.name = name;
		write();
	}

	@Override
	protected String getElementName() {
		return name;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(
				ATTRIB_VALUE,
				entity.toString());
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}