package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.data.AttributeValue;

public class AttValueEntityWriter extends DynamicEntityWriter<AttributeValue>{
	private static final String ENTITY = "attvalue";
	private static final String ATTRIB_FOR = "for";
	private static final String ATTRIB_VALUE = "value";
	
	public AttValueEntityWriter(XMLStreamWriter writer, AttributeValue entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		writer.writeAttribute(
				ATTRIB_FOR,
				entity.getAttribute().getId());
		
		writer.writeAttribute(
				ATTRIB_VALUE,
				entity.getValue());
		
		super.writeAttributes();
	}
}