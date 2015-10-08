package it.uniroma1.dis.wsngroup.gexf4j.core.utils;

import javax.xml.stream.XMLStreamWriter; 
import java.lang.reflect.InvocationHandler; 
import java.lang.reflect.Method; 
import java.util.HashMap; 
import java.util.Map; 

public class PrettyPrintHandler implements InvocationHandler { 
	private XMLStreamWriter target; 

	private int depth = 0; 
	private Map<Integer, Boolean> hasChildElement = new HashMap<Integer,Boolean>(); 

	private static final String INDENT_CHAR = " "; 
	private static final String LINEFEED_CHAR = "\n"; 

	public PrettyPrintHandler( XMLStreamWriter target ) 
	{ 
		this.target = target; 
	} 

	public Object invoke(Object proxy, Method method, Object[] args) throws Exception { 

		String m = method.getName(); 


		if( "writeStartElement".equals( m )) 
		{ 
			// update state of parent node 
			if( depth > 0 ) 
			{ 
				hasChildElement.put( depth-1, true ); 
			} 

			// reset state of current node 
			hasChildElement.put( depth, false ); 

			// indent for current depth 
			target.writeCharacters( LINEFEED_CHAR ); 
			target.writeCharacters( repeat( depth, INDENT_CHAR )); 

			depth++; 
		} 

		if( "writeEndElement".equals( m )) 
		{ 
			depth--; 

			if(hasChildElement.get(depth)) 
			{ 
				target.writeCharacters( LINEFEED_CHAR ); 
				target.writeCharacters( repeat( depth, INDENT_CHAR )); 
			} 

		} 

		if( "writeEmptyElement".equals(m )) 
		{ 
			// update state of parent node 
			if( depth > 0 ) 
			{ 
				hasChildElement.put( depth-1, true ); 
			} 

			// indent for current depth 
			target.writeCharacters( LINEFEED_CHAR ); 
			target.writeCharacters( repeat( depth, INDENT_CHAR )); 

		} 


		method.invoke( target, args ); 

		return null; 
	} 

	private String repeat( int d, String s ) { 
		String _s = "";
		while (d-- > 0) {
			_s += s;
		}
		return _s;
	} 
}