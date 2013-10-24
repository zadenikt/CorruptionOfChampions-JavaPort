package com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts;

public class Hair {
	protected double length;
	protected Color color;
	protected Type type;

	public Hair() { this(2.5, Color.BLONDE, Type.NORMAL); }
	public Hair(double length, Color color, Type type) {
		this.length = length;
		this.color = color;
		this.type = type;
	}
	
	public double getLength() { return this.length; }
	public double grow(double amount) { return this.length += amount; }
	public double shrink(double amount) { return this.grow(-amount); }
	public void setLength(double length) { this.length = length; }
	public Color getColor() { return this.color; }
	public void setColor(Color color) { this.color = color; }
	public Type getType() { return this.type; }
	public void setType(Type type) { this.type = type; }
	
	public enum Color { //TODO Add all of the hair colors.
		//Creation
		BLONDE,
		BROWN,
		BLACK,
		RED,
		GREY,
		WHITE,
		AUBURN,
		//TF
		SHINY_BLACK,
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
