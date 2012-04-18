package com.ojn.gexf4j.core.impl.writer;

import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.dynamic.Spell;

public class SpellsEntityWriter extends AbstractEntityWriter<List<Spell>> {
	private static final String ENTITY = "spells";
	
	public SpellsEntityWriter(XMLStreamWriter writer, List<Spell> entity) {
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
		for (Spell s : entity) {
			new SpellEntityWriter(writer, s);
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		// do nothing
	}
}