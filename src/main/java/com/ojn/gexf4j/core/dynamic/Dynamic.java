package com.ojn.gexf4j.core.dynamic;

import com.ojn.gexf4j.core.IntervalType;

public interface Dynamic<T extends Object> {

	boolean hasStartDate();
	T clearStartDate();
	Object getStartValue();
	T setStartValue(Object startDate);
	T setStartIntervalType(IntervalType startIntervalType);
	IntervalType getStartIntervalType();
	
	boolean hasEndDate();
	T clearEndDate();
	Object getEndValue();
	T setEndValue(Object endDate);
	T setEndIntervalType(IntervalType endIntervalType);
	IntervalType getEndIntervalType();
}