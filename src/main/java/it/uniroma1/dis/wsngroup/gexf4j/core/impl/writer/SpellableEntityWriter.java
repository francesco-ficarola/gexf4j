package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Spellable;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


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