package com.ojn.gexf4j.core.impl.viz;

import static com.google.common.base.Preconditions.checkArgument;

import com.ojn.gexf4j.core.viz.Color;

public class ColorImpl implements Color {

	private int r = 0;
	private int g = 0;
	private int b = 0;
	
	public ColorImpl() {
		// do nothing
	}
	
	public ColorImpl(int r, int g, int b) {
		setR(r);
		setG(g);
		setB(b);
	}

	@Override
	public int getR() {
		return r;
	}

	@Override
	public Color setR(int r) {
		checkArgument(r >= 0, "Color value cannot be less than 0.");
		checkArgument(r <= 255, "Color value cannot be greater than 255.");
		this.r = r;
		return this;
	}

	@Override
	public int getG() {
		return g;
	}

	@Override
	public Color setG(int g) {
		checkArgument(g >= 0, "Color value cannot be less than 0.");
		checkArgument(g <= 255, "Color value cannot be greater than 255.");
		this.g = g;
		return this;
	}

	@Override
	public int getB() {
		return b;
	}

	@Override
	public Color setB(int b) {
		checkArgument(b >= 0, "Color value cannot be less than 0.");
		checkArgument(b <= 255, "Color value cannot be greater than 255.");
		this.b = b;
		return this;
	}	
}