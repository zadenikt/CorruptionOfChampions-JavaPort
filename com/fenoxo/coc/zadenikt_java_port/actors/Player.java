package com.fenoxo.coc.zadenikt_java_port.actors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fenoxo.coc.zadenikt_java_port.scenes.Location;

public class Player extends Actor {
	protected String notes;
	protected Map<String, Actor> followers, lovers, slaves;
	protected ArrayList<Location> explorable, places;
	
	public Player(String playerName) {
		this.strength = 15;
		this.toughness = 15;
		this.speed = 15;
		this.intelligence = 15;
		this.sensitivity = 15;
		this.libido = 15;
		this.corruption = 0;
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
		this.notes = "No Notes Available.";
		this.followers = new HashMap<String, Actor>();
		this.lovers = new HashMap<String, Actor>();
		this.slaves = new HashMap<String, Actor>();
		this.explorable = new ArrayList<Location>();
		this.places = new ArrayList<Location>();
	}
	
	public Player setNotes(String notes) { this.notes = notes; return this; }
	public String getNotes() { return this.notes; }
	
	public Player addFollower(String name, Actor follower) { this.followers.put(name.toLowerCase(), follower); return this; }
	public Player removeFollower(String follower) { this.followers.remove(follower.toLowerCase()); return this; }
	public Actor getFollower(String follower) { return this.followers.get(follower.toLowerCase()); }
	public Boolean hasFollower(String follower) { return this.followers.containsKey(follower.toLowerCase()); }
	public Boolean hasAnyFollowers() { return !this.followers.isEmpty(); }
	
	public Player addLover(String name, Actor lover) { this.lovers.put(name.toLowerCase(), lover); return this; }
	public Player removeLover(String lover) { this.lovers.remove(lover.toLowerCase()); return this; }
	public Actor getLover(String lover) { return this.lovers.get(lover.toLowerCase()); }
	public Boolean hasLover(String lover) { return this.lovers.containsKey(lover.toLowerCase()); }
	public Boolean hasAnyLovers() { return !this.lovers.isEmpty(); }
	
	public Player addSlave(String name, Actor slave) { this.slaves.put(name.toLowerCase(), slave); return this; }
	public Player removeSlave(String slave) { this.slaves.remove(slave.toLowerCase()); return this; }
	public Actor getSlave(String slave) { return this.slaves.get(slave.toLowerCase()); }
	public Boolean hasSlave(String slave) { return this.slaves.containsKey(slave.toLowerCase()); }
	public Boolean hasAnySlaves() { return !this.slaves.isEmpty(); }
	
	public Player addExplorable(Location explorable) { this.explorable.add(explorable); return this; }
	public Player removeExplorable(Location explorable) { this.explorable.remove(explorable); return this; }
	public Boolean canExploreExplorable(Location explorable) { return this.explorable.contains(explorable); }
	public Boolean hasAnyExplorables() { return !this.explorable.isEmpty(); }
	
	public Player addPlace(Location place) { this.places.add(place); return this; }
	public Player removePlace(Location place) { this.places.remove(place); return this; }
	public Boolean canExplorePlace(Location place) { return this.places.contains(place); }
	public Boolean hasAnyPlaces() { return !this.places.isEmpty(); }
}
