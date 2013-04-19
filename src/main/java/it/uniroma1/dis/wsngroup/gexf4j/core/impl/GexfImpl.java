package it.uniroma1.dis.wsngroup.gexf4j.core.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import it.uniroma1.dis.wsngroup.gexf4j.core.Gexf;
import it.uniroma1.dis.wsngroup.gexf4j.core.Graph;
import it.uniroma1.dis.wsngroup.gexf4j.core.Metadata;

/**
 * GexfImpl class is an implementation of the Gexf interface.
 *
 */
public class GexfImpl implements Gexf {
	private static final String VERSION = "1.2";
	
	private String variant = null;
	private Graph graph = null;
	private Metadata meta = null;
	private boolean viz = false;
	
	/**
	 * Constructs a GEXF object
	 */
	public GexfImpl() {
		graph = new GraphImpl();
		meta = new MetadataImpl();
	}

	@Override
	public Graph getGraph() {
		return graph;
	}

	@Override
	public Metadata getMetadata() {
		return meta;
	}

	@Override
	public String getVersion() {
		return VERSION;
	}

	@Override
	public boolean hasVariant() {
		return (variant != null);
	}

	@Override
	public Gexf clearVariant() {
		variant = null;
		return this;
	}

	@Override
	public String getVariant() {
		checkState(hasVariant(), "Variant has not been set.");
		return variant;
	}
	
	@Override
	public Gexf setVariant(String variant) {
		checkArgument(variant != null, "Variant cannot be null.");
		checkArgument(!variant.trim().isEmpty(), "Variant cannot be empty or blank.");
		this.variant = variant;
		return this;
	}

	@Override
	public boolean hasVisualization() {
		return viz;
	}

	@Override
	public Gexf setVisualization(boolean viz) {
		this.viz = viz;
		return this;
	}
}