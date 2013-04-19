package it.uniroma1.dis.wsngroup.gexf4j.core.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import it.uniroma1.dis.wsngroup.gexf4j.core.IntervalType;
import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Spell;

/**
 * SpellImpl class is an implementation of the Spell interface.
 *
 */
public class SpellImpl implements Spell {

	private Object startDate = null;
	private Object endDate = null;
	private IntervalType startIntervalType = IntervalType.CLOSE;
	private IntervalType endIntervalType = IntervalType.CLOSE;

	/**
	 * Constructs a Spell element
	 */
	public SpellImpl() {}

	@Override
	public boolean hasStartDate() {
		return (startDate != null);
	}
	
	@Override
	public Spell clearStartDate() {
		startDate = null;
		return this;
	}
	
	@Override
	public Object getStartValue() {
		checkState(hasStartDate(), "Start Data has not been set.");
		return startDate;
	}
	
	@Override
	public Spell setStartValue(Object startDate) {
		checkArgument(startDate != null, "Start Date cannot be set to null.");
		this.startDate = startDate;
		return this;
	}

	@Override
	public boolean hasEndDate() {
		return (endDate != null);
	}
	
	@Override
	public Spell clearEndDate() {
		endDate = null;
		return this;
	}
	
	@Override
	public Object getEndValue() {
		checkState(hasEndDate(), "End Data has not been set.");
		return endDate;
	}

	@Override
	public Spell setEndValue(Object endDate) {
		checkArgument(endDate != null, "End Date cannot be set to null.");
		this.endDate = endDate;
		return this;
	}

	@Override
	public Spell setStartIntervalType(IntervalType startIntervalType) {
		checkArgument(startIntervalType != null, "Start Interval Type cannot be null.");
		this.startIntervalType = startIntervalType;
		return this;
	}

	@Override
	public IntervalType getStartIntervalType() {
		return startIntervalType;
	}

	@Override
	public Spell setEndIntervalType(IntervalType endIntervalType) {
		checkArgument(endIntervalType != null, "End Interval Type cannot be null.");
		this.endIntervalType = endIntervalType;
		return this;
	}

	@Override
	public IntervalType getEndIntervalType() {
		return endIntervalType;
	}
}