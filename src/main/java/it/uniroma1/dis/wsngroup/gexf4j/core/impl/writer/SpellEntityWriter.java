package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Spell;

import javax.xml.stream.XMLStreamWriter;


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