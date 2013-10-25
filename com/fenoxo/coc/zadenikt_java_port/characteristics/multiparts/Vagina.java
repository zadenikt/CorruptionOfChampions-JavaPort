package com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts;

public class Vagina {
	protected Type type = Type.NORMAL;
	protected double looseness = 0.0, wetness = 0.0;
	protected boolean virgin = true;

	public Type getType() { return this.type; }
	public double getLooseness() { return this.looseness; }
	public double getWetness() { return this.wetness; }
	public boolean isVirgin() { return virgin; }

	public Vagina setType(Type type) { this.type = type; return this; }
	public Vagina setLooseness(double looseness) { this.looseness = looseness; return this; }
	public Vagina setWetness(double wetness) { this.wetness = wetness; return this; }
	public Vagina magicallyRegrowHymen(boolean virgin) { this.virgin = virgin; return this; }
	
	public enum Type {
		NORMAL,
		SANDTRAP;
	}
}
