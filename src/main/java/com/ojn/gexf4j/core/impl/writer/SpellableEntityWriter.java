package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.dynamic.Spellable;

public abstract class SpellableEntityWriter<T extends Spellable<?>> extends DynamicEntityWriter<T> {

	public SpellableEntityWriter(XMLStreamWriter writer, T entity) {
		super(writer, entity);
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
		super.writeAttributes();
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		if (!entity.getSpells().isEmpty()) {
			new SpellsEntityWriter(writer, entity.getSpells());
		}
		super.writeElements();
	}	
}