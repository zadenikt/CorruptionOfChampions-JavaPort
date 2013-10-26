package com.fenoxo.coc.zadenikt_java_port;

public class Player extends Actor {
	protected String notes;
	
	public Player(String playerName) {
		this.strength = 15;
		this.toughness = 15;
		this.speed = 15;
		this.intelligence = 15;
		this.sensitivity = 15;
		this.libido = 15;
		this.corruption = 0;
		this.notes = "No Notes Available.";
		this.lust = 15;
		this.name = "You";
		this.description = playerName;
		this.health = this.getMaxHealth();
		this.lust = 0;
		this.fatigue = 0;
		this.xp = 0;
		this.level = 1;
		this.xpTease = 0;
		this.levelTease = 1;
	}
	
	public Player setNotes(String notes) { this.notes = notes; return this; }
	
	public String getNotes() { return this.notes; }
}
