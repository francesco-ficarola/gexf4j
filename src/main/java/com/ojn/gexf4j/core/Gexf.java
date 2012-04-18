package com.ojn.gexf4j.core;

public interface Gexf {

	String getVersion();
	
	boolean hasVariant();
	Gexf clearVariant();
	String getVariant();
	Gexf setVariant(String variant);
	
	Metadata getMetadata();
	
	Graph getGraph();
	
	boolean hasVisualization();
	Gexf setVisualization(boolean viz);
}