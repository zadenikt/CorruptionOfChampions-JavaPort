package com.fenoxo.coc.zadenikt_java_port.equipment;

import com.fenoxo.coc.zadenikt_java_port.actors.Actor;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Perk;

public class Armour extends Item { //I spell most words the British way.
	public static final Armour COMFORTABLE_CLOTHES =	new Armour("C.Cloth",	"Comfortable Clothes",	"These loose fitting and comfortable clothes allow you to move freely while protecting you from the elements.",		-1,			0);
	
	public final int defense;
	public final Perk perk;

	public Armour(String shortName, String name, String desc, int value, int defense) {
		this(shortName, name, desc, value, defense, Perk.NULL);
	}
	public Armour(String shortName, String name, String desc, int value, int defense, Perk perk) {
		super(shortName, name, desc, value);
		this.defense = defense;
		this.perk = perk;
	}
	
	public void action(Actor user) {
		user.equipArmour(this);
	}
}
