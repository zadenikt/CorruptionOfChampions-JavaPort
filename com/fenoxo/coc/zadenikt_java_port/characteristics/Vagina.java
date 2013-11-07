package com.fenoxo.coc.zadenikt_java_port.characteristics;

public class Vagina {
	private Type type = Type.NORMAL;
	private Double looseness = 0.0, wetness = 0.0, clitLength = 0.5;
	private Boolean virgin = true;
	
	public Vagina() {
		this(0.0);
	}
	public Vagina(Double looseness) {
		this(looseness, 0.0);
	}
	public Vagina(Double looseness, Double wetness) {
		this(looseness, wetness, 0.5);
	}
	public Vagina(Double looseness, Double wetness, Double clitLength) {
		this(looseness, wetness, clitLength, true);
	}
	public Vagina(Double looseness, Double wetness, Double clitLength, Boolean virgin) {
		this(looseness, wetness, clitLength, virgin, Type.NORMAL);
	}
	public Vagina(Double looseness, Double wetness, Double clitLength, Boolean virgin, Type type) {
		this.setLooseness(looseness)
		.setWetness(wetness)
		.setClitLength(clitLength)
		.magicallyRegrowHymen(virgin)
		.setType(type);
	}
	
	public Type getType() {
		return this.type;
	}
	public Double getLooseness() {
		return this.looseness;
	}
	public Double getWetness() {
		return this.wetness;
	}
	public Double getClitLength() {
		return this.clitLength;
	}
	public Boolean isVirgin() {
		return virgin;
	}
	
	public Vagina setType(Type type) {
		this.type = type;
		return this;
	}
	public Vagina setLooseness(double looseness) {
		this.looseness = looseness;
		return this;
	}
	public Vagina setWetness(double wetness) {
		this.wetness = wetness;
		return this;
	}
	public Vagina setClitLength(Double clitLength) {
		this.clitLength = clitLength;
		return this;
	}
	public Vagina magicallyRegrowHymen(boolean virgin) {
		this.virgin = virgin;
		return this;
	}
	
	public enum Type {
		NORMAL,
		SANDTRAP;
	}
}
