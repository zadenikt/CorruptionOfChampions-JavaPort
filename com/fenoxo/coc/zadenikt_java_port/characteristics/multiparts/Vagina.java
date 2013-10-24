package com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts;

public class Vagina {
	protected Type type;
	
	public Vagina() { this(Type.NORMAL); }
	public Vagina(Type type) {
		this.type = type;
	}

	public Type getType() { return this.type; }
	
	public enum Type {
		NORMAL,
		SANDTRAP;
	}
}
