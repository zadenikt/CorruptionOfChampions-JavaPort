package com.fenoxo.coc.zadenikt_java_port.equipment;

import com.fenoxo.coc.zadenikt_java_port.Actor;

public class Item {
	public final String shortName, name, description;
	public final int value;
	
	public Item(String shortName, String name, String desc, int value) {
		if(shortName.length() > 7) throw new RuntimeException("shortName must be 7 characters or fewer."); //TODO Make this more "polite".
		this.shortName = shortName;
		this.name = name;
		this.description = desc;
		this.value = value;
	}
	
	public void action(Actor user) {}
}
