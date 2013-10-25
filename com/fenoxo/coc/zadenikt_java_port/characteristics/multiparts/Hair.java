package com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts;

public class Hair {
	protected double length;
	protected Colour color;
	protected Type type;

	public Hair() { this(2.5, Colour.BLONDE, Type.NORMAL); }
	public Hair(double length, Colour color, Type type) {
		this.length = length;
		this.color = color;
		this.type = type;
	}
	
	public double getLength() { return this.length; }
	public double grow(double amount) { return this.length += amount; }
	public double shrink(double amount) { return this.grow(-amount); }
	public void setLength(double length) { this.length = length; }
	public Colour getColour() { return this.color; }
	public void setColor(Colour color) { this.color = color; }
	public Type getType() { return this.type; }
	public void setType(Type type) { this.type = type; }
	
	public enum Colour { //TODO Add all of the hair colors.
		//Creation
		BLONDE,
		BROWN,
		BLACK,
		RED,
		GREY,
		WHITE,
		AUBURN,
		//"Upgraded"/specialized
		GOLDEN_BLONDE,
		SILVER_BLONDE,
		SHINY_BLACK,
		//TF
		BLACK_AND_YELLOW;
	}
	public enum Type {
		NORMAL,
		FEATHER,
		GHOST,
		GOO,
		ANEMONE;
	}
}