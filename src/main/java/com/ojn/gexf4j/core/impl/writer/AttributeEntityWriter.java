package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.google.common.base.Joiner;
import com.ojn.gexf4j.core.data.Attribute;

public class AttributeEntityWriter extends AbstractEntityWriter<Attribute> {
	private static final String ENTITY = "attribute";
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_TITLE = "title";
	private static final String ATTRIB_TYPE = "type";
	private static final String ENTITY_DEFAULT = "default";
	private static final String ENTITY_OPTIONS = "options";
	
	public AttributeEntityWriter(XMLStreamWriter writer, Attribute entity) {
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
				ATTRIB_ID,
				entity.getId());
		
		writer.writeAttribute(
				ATTRIB_TITLE,
				entity.getTitle());
		
		writer.writeAttribute(
				ATTRIB_TYPE,
				entity.getAttributeType().toString().toLowerCase());
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		if (entity.hasDefaultValue()) {
			new StringEntityWriter(writer, ENTITY_DEFAULT, entity.getDefaultValue());
		}
		
		if (!entity.getOptions().isEmpty()) {
			String options = Joiner.on(',').skipNulls().join(entity.getOptions());
			new StringEntityWriter(writer, ENTITY_OPTIONS, options);
		}
	}
}