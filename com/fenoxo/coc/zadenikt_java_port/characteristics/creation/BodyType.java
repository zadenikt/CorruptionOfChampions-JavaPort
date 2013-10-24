package com.fenoxo.coc.zadenikt_java_port.characteristics.creation;


public enum BodyType {
	THIN("Lean", "Slender"),
	AVERAGE("Average", "Average"),
	THICK("Thick", "Curvy"),
	OPPGEN("Girly", "Tomboyish");
	
	protected String m, f;
	
	private BodyType(String forMales, String forFemales) {
		this.m = forMales;
		this.f = forFemales;
	}
	
	public String getName(Gender g) {
		if(g == Gender.MALE) return this.m;
		else if(g == Gender.FEMALE) return this.f;
		else throw new IllegalArgumentException();
	}
}
