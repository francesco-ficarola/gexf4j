package com.ojn.gexf4j.core.impl.writer;

import static com.google.common.base.Preconditions.checkArgument;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.dynamic.TimeFormat;

public abstract class AbstractEntityWriter<T extends Object> {
	private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	protected static String writerTimeType = TimeFormat.DOUBLE;
	
	protected static String toDouble(Object number) {
		String returnValue = null;
		if(number instanceof Double) {
			Double n = (Double) number;
			returnValue = String.valueOf(n);
		}
		return returnValue;
	}
	
	protected static String toInteger(Object number) {
		String returnValue = null;
		if(number instanceof Integer) {
			Integer n = (Integer) number;
			returnValue = String.valueOf(n);
		}
		return returnValue;
	}
	
	protected static String toDateString(Object date) {
		String returnValue = null;
		if(date instanceof Date) {
			Date d = (Date) date;
			returnValue = sdfDate.format(d);
		}
		return returnValue;
	}
	
	protected static String toDateTimeString(Object date) {
		String returnValue = null;
		if(date instanceof Date) {
			Date d = (Date) date;
			returnValue = sdfDateTime.format(d);
		}
		return returnValue;
	}
	
	protected XMLStreamWriter writer = null;
	protected T entity = null;

	protected abstract String getElementName();
	protected abstract void writeAttributes() throws XMLStreamException;
	protected abstract void writeElements() throws XMLStreamException;
	
	public AbstractEntityWriter(XMLStreamWriter writer, T entity) {
		checkArgument(writer != null, "XML Writer cannot be null.");
		checkArgument(entity != null, "Entity cannot be null.");
		
		this.writer = writer;
		this.entity = entity;
	}
	
	protected void write() {
		try {
			writeStartElement();
			
			writeAttributes();
			writeElements();
			
			writer.writeEndElement();
			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	protected void writeStartElement() throws XMLStreamException {
		writer.writeStartElement(getElementName());
	}
}