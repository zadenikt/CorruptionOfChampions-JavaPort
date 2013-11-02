package com.fenoxo.coc.zadenikt_java_port.characteristics;

import com.fenoxo.coc.zadenikt_java_port.actors.Actor;

public enum Gender {
	NONE, MALE, FEMALE, HERM;
	
	public static Gender get(Actor a) {
		return a.getGender();
	}
}
