package it.uniroma1.dis.wsngroup.gexf4j.core.dynamic;

import it.uniroma1.dis.wsngroup.gexf4j.core.IntervalType;

public interface Dynamic<T extends Object> {

	/**
	 * Checks if the element has a start date
	 * @return true if the element has a start date
	 */
	boolean hasStartDate();
	
	/**
	 * Clears the start date of the element
	 * @return the current element
	 */
	T clearStartDate();
	
	/**
	 * Returns the start date of the element
	 * @return an instance of the start date
	 */
	Object getStartValue();
	
	/**
	 * Sets the start date for that element
	 * @param startDate an instance of the start date
	 * @return the current element
	 */
	T setStartValue(Object startDate);
	
	/**
	 * Sets the interval type for the start date
	 * @param startIntervalType an instance of IntervalType enum
	 * @return the current element
	 */
	T setStartIntervalType(IntervalType startIntervalType);
	
	/**
	 * Returns the interval type of the start date
	 * @return an instance of IntervalType enum
	 */
	IntervalType getStartIntervalType();
	
	/**
	 * Checks if the element has an end date
	 * @return true if the element has an end date
	 */
	boolean hasEndDate();
	
	/**
	 * Clears the end date of the element
	 * @return the current element
	 */
	T clearEndDate();
	
	/**
	 * Returns the end date of the element
	 * @return an instance of the end date
	 */
	Object getEndValue();
	
	/**
	 * Sets the end date for that element
	 * @param endDate an instance of the end date
	 * @return the current element
	 */
	T setEndValue(Object endDate);
	
	/**
	 * Sets the interval type for the end date
	 * @param endIntervalType an instance of IntervalType enum
	 * @return the current element
	 */
	T setEndIntervalType(IntervalType endIntervalType);
	
	/**
	 * Returns the interval type of the end date
	 * @return an instance of IntervalType enum
	 */
	IntervalType getEndIntervalType();
}