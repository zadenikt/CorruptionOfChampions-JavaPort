package com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts;

public class BreastRow {
	protected int breastsInRow;
	protected int nipplesPerBreast;
	protected double size, fullness;
	protected double lactation, milk;
	protected boolean fuckable;
	
	public BreastRow() { this(0.0, 0.0); }
	public BreastRow(double size, double fullness) { this(size, fullness, 2, 1); }
	public BreastRow(double size, double fullness, int breastsInRow, int nipplesPerBreast) { this(size, fullness, breastsInRow, nipplesPerBreast, false); }
	public BreastRow(double size, double fullness, int breastsInRow, int nipplesPerBreast, boolean fuckable) { this(size, fullness, breastsInRow, nipplesPerBreast, fuckable, 0.0); }
	public BreastRow(double size, double fullness, int breastsInRow, int nipplesPerBreast, boolean fuckable, double lactation) { this(size, fullness, breastsInRow, nipplesPerBreast, fuckable, lactation, 0.0); }
	public BreastRow(double size, double fullness, int breastsInRow, int nipplesPerBreast, boolean fuckable, double lactation, double milk) {
		this.size = size;
		this.fullness = fullness;
		this.breastsInRow = breastsInRow;
		this.nipplesPerBreast = nipplesPerBreast;
		this.fuckable = fuckable;
		this.lactation = lactation;
		this.milk = milk;
	}
	
	public int getBreastsInRow() { return breastsInRow; }
	public void setBreastsInRow(int breastsInRow) { this.breastsInRow = breastsInRow; }
	
	public int getNipplesPerBreast() { return nipplesPerBreast; }
	public void setNipplesPerBreast(int nipplesPerBreast) { this.nipplesPerBreast = nipplesPerBreast; }
	
	public double getSize() { return size; }
	public void setSize(double size) { this.size = size; }
	
	public double getFullness() { return fullness; }
	public void setFullness(double fullness) { this.fullness = fullness; }
	
	public double getLactation() { return lactation; }
	public void setLactation(double lactation) { this.lactation = lactation; }
	
	public double getMilk() { return milk; }
	public void setMilk(double milk) { this.milk = milk; }
	
	public boolean isFuckable() { return fuckable; }
	public void setFuckable(boolean fuckable) { this.fuckable = fuckable; }
}
