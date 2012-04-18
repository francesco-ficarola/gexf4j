package com.ojn.gexf4j.core.impl;

import com.ojn.gexf4j.core.SpellableDatum;
import com.ojn.gexf4j.core.data.AttributeValueList;
import com.ojn.gexf4j.core.impl.data.AttributeValueListImpl;
import com.ojn.gexf4j.core.impl.dynamic.SpellableBase;

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