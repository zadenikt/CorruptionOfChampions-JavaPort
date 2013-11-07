package com.fenoxo.coc.zadenikt_java_port.characteristics;

public class Hair {
	private Double length;
    private Colour color;
    private Type type;
    
    public Hair() {
    	this(7.5);
    }
    public Hair(Double length) {
    	this(length, Colour.BLONDE);
    }
    public Hair(Double length, Colour colour) {
    	this(length, colour, Type.NORMAL);
    }
    public Hair(Double length, Colour colour, Type type) {
        this.length = length;
        this.color = colour;
        this.type = type;
    }
    
    public Double getLength() { return this.length; }
    public Double grow(double amount) { return this.length += amount; }
    public Double shrink(double amount) { return this.grow(-amount); }
    public void setLength(double length) { this.length = length; }
    public Colour getColour() { return this.color; }
    public void setColor(Colour color) { this.color = color; }
    public Type getType() { return this.type; }
    public void setType(Type type) { this.type = type; }
    
    public enum Colour { //TODO Add all of the hair colors.
        // Creation
        BLONDE,
        BROWN,
        BLACK,
        RED,
        GREY,
        WHITE,
        AUBURN,
        // Modified version of creation
        GOLDEN_BLONDE,
        SILVER_BLONDE,
        SHINY_BLACK,
        // TF-only
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