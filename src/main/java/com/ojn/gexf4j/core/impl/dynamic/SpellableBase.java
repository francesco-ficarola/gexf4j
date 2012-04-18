package com.ojn.gexf4j.core.impl.dynamic;

import java.util.ArrayList;
import java.util.List;

import com.ojn.gexf4j.core.dynamic.Spellable;
import com.ojn.gexf4j.core.dynamic.Spell;

public abstract class SpellableBase<T extends Object> extends DynamicBase<T> implements Spellable<T> {

	private List<Spell> spells = null;
	
	public SpellableBase() {
		spells = new ArrayList<Spell>();
	}
	
	@Override
	public List<Spell> getSpells() {
		return spells;
	}
}