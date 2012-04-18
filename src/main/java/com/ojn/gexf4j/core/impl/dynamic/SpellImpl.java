package com.ojn.gexf4j.core.impl.dynamic;

import com.ojn.gexf4j.core.dynamic.Spell;

public class SpellImpl extends DynamicBase<Spell> implements Spell {

	public SpellImpl() {
		// do nothing
	}
	
	@Override
	protected Spell getSelf() {
		return this;
	}
}