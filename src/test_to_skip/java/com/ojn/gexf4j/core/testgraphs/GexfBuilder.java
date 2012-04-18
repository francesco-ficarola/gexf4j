package com.ojn.gexf4j.core.testgraphs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ojn.gexf4j.core.Gexf;

public abstract class GexfBuilder {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public abstract Gexf buildGexf();
	public abstract String getSuffix();
	
	protected Date toDate(String s) {
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public String getSchemaUrl() {
		return "http://gexf.net/1.1draft/gexf.xsd";
	}
}