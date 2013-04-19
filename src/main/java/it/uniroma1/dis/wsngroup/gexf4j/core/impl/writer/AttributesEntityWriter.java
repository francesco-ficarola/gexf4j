package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeList;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class AttributesEntityWriter extends DynamicEntityWriter<AttributeList> {
	private static final String ENTITY = "attributes";
	private static final String ATTRIB_CLASS = "class";
	private static final String ATTRIB_MODE = "mode";
	
	public AttributesEntityWriter(XMLStreamWriter writer, AttributeList entity) {
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
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(
				ATTRIB_CLASS,
				entity.getAttributeClass().toString().toLowerCase());

		writer.writeAttribute(
				ATTRIB_MODE,
				entity.getMode().toString().toLowerCase());
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		for (Attribute attrib : entity) {
			new AttributeEntityWriter(writer, attrib);
		}
	}
}