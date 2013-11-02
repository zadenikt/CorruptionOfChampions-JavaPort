package com.fenoxo.coc.zadenikt_java_port.equipment;

import com.fenoxo.coc.zadenikt_java_port.actors.Actor;

public class Item {
	public final String shortName, name, description;
	public final int value;
	public int count;
	
	public Item(String shortName, String name, String desc, int value) {
		if(shortName.length() > 7) {
		  throw new RuntimeException("shortName must be 7 characters or fewer."); 
		  //TODO Make this more "polite".
		}
		this.shortName = shortName;
		this.name = name;
		this.description = desc;
		this.value = value;
		this.count = 1;
	}
	
	public void action(Actor user) {
	  throw new RuntimeException("Not yet implemented");
	}
}
