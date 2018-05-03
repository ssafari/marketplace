package com.marketplace.limit;

public class LimitsData {
	
	private int maximum;
	private int minimum;

	public LimitsData() {
		super();
	}

	public LimitsData(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}
}
