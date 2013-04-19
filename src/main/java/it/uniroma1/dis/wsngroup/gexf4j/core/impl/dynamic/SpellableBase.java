package it.uniroma1.dis.wsngroup.gexf4j.core.impl.dynamic;

import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Spell;
import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Spellable;

import java.util.ArrayList;
import java.util.List;


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