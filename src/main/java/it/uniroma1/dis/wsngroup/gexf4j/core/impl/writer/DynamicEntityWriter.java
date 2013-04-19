package it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer;

import static com.google.common.base.Preconditions.checkArgument;
import it.uniroma1.dis.wsngroup.gexf4j.core.IntervalType;
import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.Dynamic;
import it.uniroma1.dis.wsngroup.gexf4j.core.dynamic.TimeFormat;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public abstract class DynamicEntityWriter<T extends Dynamic<?>> extends AbstractEntityWriter<T> {
	protected static final String ATTRIB_START = "start";
	protected static final String ATTRIB_START_OPEN = "startopen";
	protected static final String ATTRIB_END = "end";
	protected static final String ATTRIB_END_OPEN = "endopen";
	private IntervalType startIntervalType = IntervalType.CLOSE;
	private IntervalType endIntervalType = IntervalType.CLOSE;
	
	public DynamicEntityWriter(XMLStreamWriter writer, T entity) {
		super(writer, entity);
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		
		/** Set open or close tags */
		
		startIntervalType = entity.getStartIntervalType();
		endIntervalType = entity.getEndIntervalType();
		String attribStart = ATTRIB_START;
		String attribEnd = ATTRIB_END;
		
		if(startIntervalType.equals(IntervalType.OPEN)) {
			attribStart = ATTRIB_START_OPEN;
		}
		
		if(endIntervalType.equals(IntervalType.OPEN)) {
			attribEnd = ATTRIB_END_OPEN;
		}
		
		
		/** Write Attributes */
		
		/** double timeformat */
		if(AbstractEntityWriter.writerTimeType.equals(TimeFormat.DOUBLE)) {
			if (entity.hasStartDate()) {
				String startValue = AbstractEntityWriter.toDouble(entity.getStartValue());
				checkArgument(startValue != null,
						entity.getClass().getName() + ": " +
						"For timeformat \"double\" please enter a Double object.");
				writer.writeAttribute(attribStart, startValue);
			}
			
			if (entity.hasEndDate()) {
				String endValue = AbstractEntityWriter.toDouble(entity.getEndValue());
				checkArgument(endValue != null,
						entity.getClass().getName() + ": " +
						"For timeformat \"double\" please enter a Double object.");
				writer.writeAttribute(attribEnd, endValue);
			}
		} else
		/** integer timeformat */
		if(AbstractEntityWriter.writerTimeType.equals(TimeFormat.INTEGER)) {
			if (entity.hasStartDate()) {
				String startValue = toInteger(entity.getStartValue());
				checkArgument(startValue != null,
						entity.getClass().getName() + ": " +
						"For timeformat \"integer\" please enter a Integer object.");
				writer.writeAttribute(attribStart, startValue);
			}
			
			if (entity.hasEndDate()) {
				String endValue = toInteger(entity.getEndValue());
				checkArgument(endValue != null,
						entity.getClass().getName() + ": " +
						"For timeformat \"integer\" please enter a Integer object.");
				writer.writeAttribute(attribEnd, endValue);
			}
		} else
		/** date timeformat */
		if(AbstractEntityWriter.writerTimeType.equals(TimeFormat.DATE)) {
			if (entity.hasStartDate()) {
				String startValue = toDateString(entity.getStartValue());
				checkArgument(startValue != null,
						entity.getClass().getName() + ": " +
						"For timeformat \"date\" please enter a Date object.");
				writer.writeAttribute(attribStart, startValue);
			}
			
			if (entity.hasEndDate()) {
				String endValue = toDateString(entity.getEndValue());
				checkArgument(endValue != null,
						entity.getClass().getName() + ": " +
						"For timeformat \"date\" please enter a Date object.");
				writer.writeAttribute(attribEnd, endValue);
			}
		} else
		/** dateTime timeformat */
		if(AbstractEntityWriter.writerTimeType.equals(TimeFormat.XSDDATETIME)) {
			if (entity.hasStartDate()) {
				String startValue = toDateTimeString(entity.getStartValue());
				checkArgument(startValue != null,
						entity.getClass().getName() + ": " +
						"For timeformat \"date\" please enter a Date object.");
				writer.writeAttribute(attribStart, startValue);
			}
			
			if (entity.hasEndDate()) {
				String endValue = toDateTimeString(entity.getEndValue());
				checkArgument(endValue != null,
						entity.getClass().getName() + ": " +
						"For timeformat \"date\" please enter a Date object.");
				writer.writeAttribute(attribEnd, endValue);
			}
		}
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		// do nothing
	}
}