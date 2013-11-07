package com.fenoxo.coc.zadenikt_java_port.characteristics;

public class BreastRow {
	private Integer breastsInRow;
	private Integer nipplesPerBreast;
	private Double size, fullness;
	private Double nippleLength = 0.25;
	private Double lactation, milk;
	private Boolean fuckable;
	
	public BreastRow() { this(0.0, 0.0); }
	public BreastRow(Double size, Double fullness) { this(size, fullness, 2, 1); }
	public BreastRow(Double size, Double fullness, Integer breastsInRow, Integer nipplesPerBreast) { this(size, fullness, breastsInRow, nipplesPerBreast, false); }
	public BreastRow(Double size, Double fullness, Integer breastsInRow, Integer nipplesPerBreast, Boolean fuckable) { this(size, fullness, breastsInRow, nipplesPerBreast, fuckable, 0.0); }
	public BreastRow(Double size, Double fullness, Integer breastsInRow, Integer nipplesPerBreast, Boolean fuckable, Double lactation) { this(size, fullness, breastsInRow, nipplesPerBreast, fuckable, lactation, 0.0); }
	public BreastRow(Double size, Double fullness, Integer breastsInRow, Integer nipplesPerBreast, Boolean fuckable, Double lactation, Double milk) {
		this.size = size;
		this.fullness = fullness;
		this.breastsInRow = breastsInRow;
		this.nipplesPerBreast = nipplesPerBreast;
		this.fuckable = fuckable;
		this.lactation = lactation;
		this.milk = milk;
	}
	
	public Integer getBreastsInRow() { return breastsInRow; }
	public void setBreastsInRow(Integer breastsInRow) { this.breastsInRow = breastsInRow; }
	
	public Integer getNipplesPerBreast() { return nipplesPerBreast; }
	public void setNipplesPerBreast(Integer nipplesPerBreast) { this.nipplesPerBreast = nipplesPerBreast; }
	
	public Double getSize() { return size; }
	public void setSize(Double size) { this.size = size; }
	
	public Double getFullness() { return fullness; }
	public void setFullness(Double fullness) { this.fullness = fullness; }
	
	public Double getNippleLength() {
		return this.nippleLength;
	}
	public BreastRow setNippleLength(Double nippleLength) {
		this.nippleLength = nippleLength;
		return this;
	}
	
	public Double getLactation() { return lactation; }
	public void setLactation(Double lactation) { this.lactation = lactation; }
	
	public Double getMilk() { return milk; }
	public void setMilk(Double milk) { this.milk = milk; }
	
	public Boolean isFuckable() { return fuckable; }
	public void setFuckable(Boolean fuckable) { this.fuckable = fuckable; }
}
