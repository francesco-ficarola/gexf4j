package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import static com.google.common.base.Preconditions.checkArgument;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class StringEntityWriter extends AbstractEntityWriter<String> {

	private String characters = null;
	public StringEntityWriter(XMLStreamWriter writer, String entity, String characters) {
		super(writer, entity);
		checkArgument(characters != null, "Characters cannot be null.");
		
		this.characters = characters;
		write();
	}

	@Override
	protected String getElementName() {
		return entity;
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		writer.writeCharacters(characters);
	}
	
	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
	}
}