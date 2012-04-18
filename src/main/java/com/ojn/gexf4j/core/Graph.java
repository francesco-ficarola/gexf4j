package com.ojn.gexf4j.core;

import java.util.List;

import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.dynamic.Dynamic;

public interface Graph extends Dynamic<Graph>, HasNodes {

	EdgeType getDefaultEdgeType();
	Graph setDefaultEdgeType(EdgeType edgeType);
	
	IDType getIDType();
	Graph setIDType(IDType idType);

	Mode getMode();
	Graph setMode(Mode graphMode);
	
	String getTimeType();
	Graph setTimeType(String timeType);
	
	List<AttributeList> getAttributeLists();
}