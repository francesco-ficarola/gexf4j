package com.ojn.gexf4j.core.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.impl.viz.NodeShapeImpl;
import com.ojn.gexf4j.core.viz.Color;
import com.ojn.gexf4j.core.viz.NodeShape;
import com.ojn.gexf4j.core.viz.NodeShapeEntity;
import com.ojn.gexf4j.core.viz.Position;

public class NodeImpl extends SpellableDatumBase<Node> implements Node {

	private String id = "";
	private String label = "";
	private Color color = null;
	private String pid = null;
	private Position position = null;
	private NodeShapeEntity shape = null;
	private float size = Float.MIN_VALUE;
	private List<Node> nodes = null;
	private List<Edge> edges = null;
	private List<Node> parentForList = null;
	
	public NodeImpl() {
		this(UUID.randomUUID().toString());
	}
	
	public NodeImpl(String id) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		
		this.id = id;
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
		this.parentForList = new ArrayList<Node>();
		this.shape = new NodeShapeImpl();
	}
	
	@Override
	protected Node getSelf() {
		return this;
	}

	@Override
	public Node clearColor() {
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
	public Node setColor(Color color) {
		checkArgument(color != null, "Color cannot be null.");
		this.color = color;
		return this;
	}

	@Override
	public Node clearPID() {
		pid = null;
		return this;
	}

	@Override
	public Node clearPosition() {
		position = null;
		return this;
	}

	@Override
	public Node clearShape() {
		shape = null;
		return this;
	}

	@Override
	public Node clearSize() {
		size = Float.MIN_VALUE;
		return this;
	}

	@Override
	public List<Edge> getEdges() {
		return edges;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String getPID() {
		checkState(hasPID(), "PID has not been set.");
		return pid;
	}

	@Override
	public List<Node> getParentForList() {
		return parentForList;
	}

	@Override
	public Position getPosition() {
		checkState(hasPosition(), "Position has not been set.");
		return position;
	}

	@Override
	public NodeShapeEntity getShapeEntity() {
		return shape;
	}

	@Override
	public float getSize() {
		checkState(hasSize(), "Size has not been set.");
		return size;
	}

	@Override
	public boolean hasPID() {
		return (pid != null);
	}

	@Override
	public boolean hasPosition() {
		return (position != null);
	}

	@Override
	public boolean hasShape() {
		return (shape.getNodeShape() != NodeShape.NOTSET);
	}

	@Override
	public boolean hasSize() {
		return (size != Float.MIN_VALUE);
	}

	@Override
	public Node setLabel(String label) {
		checkArgument(label != null, "Label cannot be null.");
		this.label = label;
		return this;
	}

	@Override
	public Node setPID(String pid) {
		checkArgument(pid != null, "PID cannot be null.");
		checkArgument(!pid.trim().isEmpty(), "PID cannot be empty or blank.");
		this.pid = pid;
		return this;
	}

	@Override
	public Node setPosition(Position position) {
		checkArgument(position != null, "Position cannot be null.");
		this.position = position;
		return this;
	}

	@Override
	public Node setSize(float size) {
		this.size = size;
		return this;
	}

	@Override
	public Edge connectTo(Node target) {
		return connectTo(UUID.randomUUID().toString(), target);
	}

	@Override
	public Edge connectTo(String id, Node target) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		checkArgument(target != null, "Target cannot be null.");
		checkArgument(!hasEdgeTo(target.getId()), "Edge already exists.");
		
		Edge rv = new EdgeImpl(id, this, target);
		edges.add(rv);
		return rv;
	}
	
	@Override
	public boolean hasEdgeTo(String id) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		
		for (Edge e : edges) {
			if (e.getTarget().getId().equals(id)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public Node createNode() {
		return createNode(UUID.randomUUID().toString());
	}

	@Override
	public Node createNode(String id) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		
		Node rv = new NodeImpl(id);
		nodes.add(rv);
		return rv;
	}

	@Override
	public List<Node> getNodes() {
		return nodes;
	}

	@Override
	public List<Edge> getAllEdges() {
		List<Edge> rv = new ArrayList<Edge>();
		
		for (Node n : getNodes()) {
			_getEdges(rv, n);
		}
		
		return rv;
	}
	
	private List<Edge> _getEdges(List<Edge> soFar, Node n) {
		// add the nodes' edges
		soFar.addAll(n.getEdges());
		
		// call this function on all of the sub nodes
		for (Node subNode : n.getNodes()) {
			_getEdges(soFar, subNode);
		}
		
		return soFar;
	}
}