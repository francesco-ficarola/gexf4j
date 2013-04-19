package it.uniroma1.dis.wsngroup.gexf4j.core.impl;

import it.uniroma1.dis.wsngroup.gexf4j.core.SpellableDatum;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeValueList;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.data.AttributeValueListImpl;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.dynamic.SpellableBase;

public abstract class SpellableDatumBase<T extends Object> extends SpellableBase<T> implements SpellableDatum<T> {

	private AttributeValueList attributes = null;
	
	public SpellableDatumBase() {
		attributes = new AttributeValueListImpl();
	}

	@Override
	public AttributeValueList getAttributeValues() {
		return attributes;
	}
}