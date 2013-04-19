package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.SpellableDatum;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


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