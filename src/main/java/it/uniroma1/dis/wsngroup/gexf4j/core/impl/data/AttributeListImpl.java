package it.uniroma1.dis.wsngroup.gexf4j.core.impl.data;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import it.uniroma1.dis.wsngroup.gexf4j.core.IntervalType;
import it.uniroma1.dis.wsngroup.gexf4j.core.Mode;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.Attribute;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeClass;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeList;
import it.uniroma1.dis.wsngroup.gexf4j.core.data.AttributeType;

import java.util.ArrayList;
import java.util.UUID;

/**
 * AttributeListImpl class is an implementation of the AttributeList interface.
 *
 */
public class AttributeListImpl extends ArrayList<Attribute> implements AttributeList {
	private static final long serialVersionUID = 8240096318919688740L;
	
	private Object endDate = null;
	private Object startDate = null;
	private AttributeClass attrClass = AttributeClass.NODE;
	private Mode mode = Mode.STATIC;
	private IntervalType startIntervalType = IntervalType.CLOSE;
	private IntervalType endIntervalType = IntervalType.CLOSE;
	
	/**
	 * Constructs an AttributeList object
	 * @param attrClass an instance of AttributeClass enum
	 */
	public AttributeListImpl(AttributeClass attrClass) {
		this.attrClass = attrClass;
	}
	
	@Override
	public AttributeClass getAttributeClass() {
		return attrClass;
	}

	@Override
	public Mode getMode() {
		return mode;
	}

	@Override
	public AttributeList setMode(Mode mode) {
		if (mode == Mode.STATIC) {
			clearStartDate();
			clearEndDate();
		}
		this.mode = mode;
		return this;
	}

	@Override
	public AttributeList clearEndDate() {
		endDate = null;
		return this;
	}

	@Override
	public AttributeList clearStartDate() {
		startDate = null;
		return this;
	}

	@Override
	public Object getEndValue() {
		checkState(endDate != null, "End Date has not been set.");
		return endDate;
	}

	@Override
	public Object getStartValue() {
		checkState(startDate != null, "Start Date has not been set.");
		return startDate;
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
	public AttributeList setEndValue(Object endDate) {
		checkArgument(endDate != null, "End Date cannot be null.");
		this.endDate = endDate;
		return this;
	}

	@Override
	public AttributeList setStartValue(Object startDate) {
		checkArgument(startDate != null, "Start Date cannot be null.");
		this.endDate = startDate;
		return this;
	}

	@Override
	public Attribute createAttribute(AttributeType type, String title) {
		return createAttribute(UUID.randomUUID().toString(), type, title);
	}

	@Override
	public Attribute createAttribute(String id, AttributeType type, String title) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		checkArgument(title != null, "Title cannot be null.");
		checkArgument(!title.trim().isEmpty(), "Title cannot be empty or blank.");
		
		Attribute rv = new AttributeImpl(id, type, title);
		this.add(rv);
		return rv;
	}

	@Override
	public AttributeList addAttribute(AttributeType type, String title) {
		return addAttribute(UUID.randomUUID().toString(), type, title);
	}

	@Override
	public AttributeList addAttribute(String id, AttributeType type, String title) {
		createAttribute(id, type, title);
		return this;
	}

	@Override
	public AttributeList setStartIntervalType(IntervalType startIntervalType) {
		checkArgument(startIntervalType != null, "Start Interval Type cannot be null.");
		this.startIntervalType = startIntervalType;
		return this;
	}

	@Override
	public IntervalType getStartIntervalType() {
		return startIntervalType;
	}

	@Override
	public AttributeList setEndIntervalType(IntervalType endIntervalType) {
		checkArgument(endIntervalType != null, "End Interval Type cannot be null.");
		this.endIntervalType = endIntervalType;
		return this;
	}

	@Override
	public IntervalType getEndIntervalType() {
		return endIntervalType;
	}
}