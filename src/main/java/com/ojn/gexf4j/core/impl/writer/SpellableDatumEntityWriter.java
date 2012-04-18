package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.SpellableDatum;

public abstract class SpellableDatumEntityWriter<T extends SpellableDatum<?>> extends SpellableEntityWriter<T> {

	public SpellableDatumEntityWriter(XMLStreamWriter writer, T entity) {
		super(writer, entity);
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		super.writeElements();
		new AttValuesEntityWriter(writer, entity.getAttributeValues());
	}	
}