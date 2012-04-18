package com.ojn.gexf4j.core.data;

import java.util.List;

import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.dynamic.Dynamic;

public interface AttributeList extends List<Attribute>, Dynamic<AttributeList> {
	
	AttributeClass getAttributeClass();
	
	Mode getMode();
	AttributeList setMode(Mode mode);
	
	Attribute createAttribute(AttributeType type, String title);
	Attribute createAttribute(String id, AttributeType type, String title);
	
	AttributeList addAttribute(AttributeType type, String title);
	AttributeList addAttribute(String id, AttributeType type, String title);
}