package it.uniroma1.dis.wsngroup.gexf4j.core.impl;

import static com.google.common.base.Preconditions.*;
import it.uniroma1.dis.wsngroup.gexf4j.core.Edge;
import it.uniroma1.dis.wsngroup.gexf4j.core.EdgeType;
import it.uniroma1.dis.wsngroup.gexf4j.core.Node;
import it.uniroma1.dis.wsngroup.gexf4j.core.viz.Color;
import it.uniroma1.dis.wsngroup.gexf4j.core.viz.EdgeShape;

/**
 * EdgeImpl class is an implementation of the Edge interface.
 *
 */
public class EdgeImpl extends SpellableDatumBase<Edge> implements Edge {

	private String id = "";
	private String label = null;
	private Node source = null;
	private Node target = null;
	private Color color = null;
	private EdgeShape shape = EdgeShape.NOTSET;
	private float thickness = Float.MIN_VALUE;
	private float weight = Float.MIN_VALUE;
	private EdgeType edgeType = EdgeType.UNDIRECTED;
	
	/**
	 * Constructs an Edge with a specific ID, a source Node and a target Node
	 * @param id the ID of the Edge
	 * @param source the source node of the Edge
	 * @param target the target node of the Edge
	 */
	public EdgeImpl(String id, Node source, Node target) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		checkArgument(source != null, "Source Node cannot be null.");
		checkArgument(target != null, "Target Node cannot be null.");
		
		this.id = id;
		this.source = source;
		this.target = target;
	}

	@Override
	protected Edge getSelf() {
		return this;
	}

	@Override
	public Edge clearLabel() {
		label = null;
		return this;
	}

	@Override
	public Edge clearThickness() {
		thickness = Float.MIN_VALUE;
		return this;
	}

	@Override
	public Edge clearWeight() {
		weight = Float.MIN_VALUE;
		return this;
	}

	@Override
	public EdgeType getEdgeType() {
		return edgeType;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getLabel() {
		checkState(hasLabel(), "Label has not been set.");
		return label;
	}

	@Override
	public EdgeShape getShape() {
		return shape;
	}

	@Override
	public Node getSource() {
		return source;
	}

	@Override
	public Node getTarget() {
		return target;
	}

	@Override
	public float getThickness() {
		checkState(hasThickness(), "Thickness has not been set.");
		return thickness;
	}

	@Override
	public float getWeight() {
		checkState(hasWeight(), "Weight has not been set.");
		return weight;
	}
	
	@Override
	public boolean hasLabel() {
		return (label != null);
	}

	@Override
	public boolean hasThickness() {
		return (thickness != Float.MIN_VALUE);
	}

	@Override
	public boolean hasWeight() {
		return (weight != Float.MIN_VALUE);
	}

	@Override
	public Edge clearColor() {
		color = null;
		return this;
	}
	
	@Override
	public Color getColor() {
		checkState(hasColor(), "Color has not been set.");
		return color;
	}
	

	@Override
	public boolean hasColor() {
		return (color != null);
	}
	
	@Override
	public Edge setColor(Color color) {
		checkArgument(color != null, "Color cannot be null.");
		this.color = color;
		return this;
	}

	@Override
	public Edge setEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
		return this;
	}

	@Override
	public Edge setLabel(String label) {
		checkArgument(label != null, "Label cannot be null.");
		this.label = label;
		return this;
	}

	@Override
	public Edge setShape(EdgeShape shape) {
		this.shape = shape;
		return this;
	}

	@Override
	public Edge setTarget(Node target) {
		checkArgument(target != null, "Target cannot be null.");
		this.target = target;
		return this;
	}

	@Override
	public Edge setThickness(float thickness) {
		this.thickness = thickness;
		return this;
	}

	@Override
	public Edge setWeight(float weight) {
		this.weight = weight;
		return this;
	}
}