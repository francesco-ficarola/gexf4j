package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.dynamic.Spell;

public class SpellEntityWriter extends DynamicEntityWriter<Spell> {
	private static final String ENTITY = "spell";
	
	public SpellEntityWriter(XMLStreamWriter writer, Spell entity) {
		super(writer, entity);
		write();
	}

	@Override
	protected String getElementName() {
		return ENTITY;
	}
}