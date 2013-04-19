package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeValue;

import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class AttValuesEntityWriter extends AbstractEntityWriter<List<AttributeValue>>{
	private static final String ENTITY = "attvalues";
	
	public AttValuesEntityWriter(XMLStreamWriter writer,
			List<AttributeValue> entity) {
		super(writer, entity);
		
		if (!entity.isEmpty()) {
			write();
		}
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		for (AttributeValue attval : entity) {
			new AttValueEntityWriter(writer, attval);
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
	}
}