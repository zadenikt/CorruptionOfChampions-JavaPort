package com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts;

public class Skin {
	protected Type type;
	protected Tone tone;
	//TODO See if I need a descriptor.
	//TODO See if I need an adjective.
	
	public Skin(Type type, Tone tone) {
		this.type = type;
		this.tone = tone;
	}
	
	public void setType(Type type) { this.type = type; }
	public Type getType() { return type; }
	public void setTone(Tone tone) { this.tone = tone; }
	public Tone getTone() { return tone; }
	
	public String describe() {
		// TODO Auto-generated method stub
		return null;
	}

	public enum Type {
		NORMAL,
		FUR,
		SCALES,
		GOO;
	}
	public enum Tone { // TODO Add more.
		LIGHT,
		OLIVE,
		DARK,
		EBONY,
		ALBINO;
	}
}
