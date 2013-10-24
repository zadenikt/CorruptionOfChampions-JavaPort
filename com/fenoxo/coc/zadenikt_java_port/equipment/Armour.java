package com.fenoxo.coc.zadenikt_java_port.equipment;

import com.fenoxo.coc.zadenikt_java_port.Actor;
import com.fenoxo.coc.zadenikt_java_port.Perk;

public class Armour extends Item { //I spell most words the British way.
	public static final Armour COMFORTABLE_CLOTHES =	new Armour("C.Cloth",	"Comfortable Clothes",	"These loose fitting and comfortable clothes allow you to move freely while protecting you from the elements.",		-1,			0);
	public static final Armour DEBUG_GAWDARMOR_OFF =	new Armour("OldClok",	"Old Cloak",			"A well-worn cloak.",																								100,		1);
	public static final Armour DEBUG_GAWDARMOR_ON =	new Armour("IshtClk",	"Ishtar's Cloak",		"A well-worn cloak. A rainbow aura surrounds it.",																	1000000,	9001); //OVAH 9000!!!
	
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
