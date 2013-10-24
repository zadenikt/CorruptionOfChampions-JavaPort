package com.fenoxo.coc.zadenikt_java_port.equipment;

import com.fenoxo.coc.zadenikt_java_port.Actor;
import com.fenoxo.coc.zadenikt_java_port.Perk;

public class Weapon extends Item {
	public static final Weapon FISTS =				null;
	public static final Weapon DEBUG_GAWDSWORD_OFF =	new Weapon("ClayBld", "Clay Blade",     "slash", "An ancient sword. It seems to be made from clay.",                              100,     1);
	public static final Weapon DEBUG_GAWDSWORD_ON =	new Weapon("IshtBld", "Ishtar's Blade", "slash", "An ancient sword. It seems to be made from clay. A rainbow aura surrounds it.", 1000000, 9001); //OVAH 9000!!!
	
	protected int attack;
	protected Perk perk;
	protected String verb;

	public Weapon(String shortName, String name, String verb, String desc, int value, int attack) {
		this(shortName, name, verb, desc, value, attack, Perk.NULL);
	}
	public Weapon(String shortName, String name, String verb, String desc, int value, int attack, Perk perk) {
		super(shortName, name, desc, value);
		this.verb = verb;
		this.attack = attack;
		this.perk = perk;
	}
	
	public void action(Actor user) {
		user.equipWeapon(this);
	}
}
