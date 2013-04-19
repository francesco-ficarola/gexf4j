package it.uniroma1.dis.wsngroup.gexf4j.core.impl.dynamic;

import static com.google.common.base.Preconditions.*;
import it.uniroma1.dis.wsngroup.gexf4j.core.IntervalType;
import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Dynamic;


public abstract class DynamicBase<T extends Object> implements Dynamic<T> {

	private Object endDate = null;
	private Object startDate = null;
	private IntervalType startIntervalType = IntervalType.CLOSE;
	private IntervalType endIntervalType = IntervalType.CLOSE;

	protected abstract T getSelf();
	
	public DynamicBase() {}

	@Override
	public T clearEndDate() {
		endDate = null;
		return getSelf();
	}

	@Override
	public T clearStartDate() {
		startDate = null;
		return getSelf();
	}

	@Override
	public Object getEndValue() {
		checkState(hasEndDate(), "End Date has not been set.");
		return endDate;
	}

	@Override
	public Object getStartValue() {
		checkState(hasStartDate(), "Start Date has not been set.");
		return startDate;
	}

	@Override
	public IntervalType getStartIntervalType() {
		return startIntervalType;
	}

	@Override
	public IntervalType getEndIntervalType() {
		return endIntervalType;
	}

	@Override
	public boolean hasEndDate() {
		return (endDate != null);
	}

	@Override
	public boolean hasStartDate() {
		return (startDate != null);
	}

	@Override
	public T setEndValue(Object endDate) {
		checkArgument(endDate != null, "End Date cannot be null.");
		this.endDate = endDate;
		return getSelf();
	}

	@Override
	public T setStartValue(Object startDate) {
		checkArgument(startDate != null, "Start Date cannot be null.");
		this.startDate = startDate;
		return getSelf();
	}

	@Override
	public T setStartIntervalType(IntervalType startIntervalType) {
		checkArgument(startIntervalType != null, "Start Interval Type cannot be null.");
		this.startIntervalType = startIntervalType;
		return getSelf();
	}

	@Override
	public T setEndIntervalType(IntervalType endIntervalType) {
		checkArgument(endIntervalType != null, "End Interval Type cannot be null.");
		this.endIntervalType = endIntervalType;
		return getSelf();
	}
}