package com.fenoxo.coc.zadenikt_java_port.equipment;

import com.fenoxo.coc.zadenikt_java_port.actors.Actor;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Perk;

public class Weapon extends Item {
	public static final Weapon FISTS = null;
	
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
