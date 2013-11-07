package com.fenoxo.coc.zadenikt_java_port.actors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fenoxo.coc.zadenikt_java_port.characteristics.ArmType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.EarType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.EyeType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.FaceType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Hair;
import com.fenoxo.coc.zadenikt_java_port.characteristics.HornType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.LowerBodyType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Skin;
import com.fenoxo.coc.zadenikt_java_port.characteristics.TongueType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.WingType;
import com.fenoxo.coc.zadenikt_java_port.equipment.Armour;
import com.fenoxo.coc.zadenikt_java_port.equipment.Item;
import com.fenoxo.coc.zadenikt_java_port.equipment.Weapon;
import com.fenoxo.coc.zadenikt_java_port.scenes.Location;

public class Player extends Actor {
    private Item itemSlots[] = { null, null, null }; //This can be increased by setItemSlotsMax()
    private Integer itemSlotCounts[] = { 0, 0, 0 };
    private String notes;
    private Map<String, Actor> followers, lovers, slaves;
    private ArrayList<Location> places;
    private Integer numberOfTimesExplored;
    
    public Player(String playerName) {
        // Name and Description
        this.setName("You")
        .setDescription(playerName);
        // Base Stats
        this.setStrength(15)
        .setToughness(15)
        .setSpeed(15)
        .setIntelligence(15)
        .setSensitivity(15)
        .setLibido(15)
        .setCorruption(0);
        this.setHealth(this.getMaxHealth())
        .setLust(15)
        .setFatigue(0);
        // Level Stats
        this.setXP(0)
        .setLevel(1)
        .setTeaseXP(0)
        .setTeaseLevel(0);
        // Money
        this.setGems(0);
        // Effects
        // Equipment
        this.equipWeapon(Weapon.FISTS)
        .equipArmour(Armour.COMFORTABLE_CLOTHES);
        // Appearance Stats
        this.setFemininity(50.0)
        .setHeight(69.0) // Average for male and female
        .setThickness(50.0)
        .setTone(50.0)
        .setHips(5.0) // Average for male and female
        .setButt(5.0); // Average for male and female
        this.setHair(new Hair())
        .setEyes(EyeType.NORMAL)
        .setSkin(new Skin())
        .setFace(FaceType.NORMAL)
        .setTongue(TongueType.NORMAL)
        .setEars(EarType.NORMAL)
        .setArms(ArmType.NORMAL)
        .setHorns(HornType.NONE)
        .setWings(WingType.NONE)
        .setLowerBody(LowerBodyType.NORMAL)
        .setTail(null)
        .setAntennae(false);
        // Piercings
        // Sex Organs
        // Player.java
        this.notes = "No Notes Available.";
        this.followers = new HashMap<>();
        this.lovers = new HashMap<>();
        this.slaves = new HashMap<>();
        this.places = new ArrayList<>();
        this.numberOfTimesExplored = 0;
    }
    
    public Player addItem(Item i) { //TODO Add inventory toss-out.
        int slot = this.firstEmptyItemSlot();
        if(slot == -1) {
            System.out.println(String.format("%s would've got the item %s, but their inventory is full!", this.toString(), i.name));
        } else {
            System.out.println(String.format("%s got the item %s!", this.toString(), i.name));
            this.itemSlots[slot] = i;
        }
        return this;
    }
    public Player removeItem(int slot) {
        if (this.itemSlots[slot] != null && this.itemSlotCounts[slot] > 0) {
            this.itemSlots[slot].count--;
            if (this.itemSlots[slot].count == 0) {
                this.itemSlots[slot] = null;
            }
        }
        return this;
    }
    public Player removeItem(Item item, Integer count) {
        for(int i = 0; i < count; i++) {
            this.removeItem(this.firstItemSlot(item));
        }
        return this;
    }
    public Boolean hasItem(Item i) {
        return this.firstItemSlot(i) != -1;
    }
    public Player useItem(int i) {
        this.useItem(this.itemSlots[i]);
        return this;
    }
    public Player useItem(Item i) {
        i.action(this); //TODO See if this actually works.
        return this;
    }
    public int firstItemSlot(Item item) {
        for(int i = 0; i < this.itemSlots.length; i++) {
            if(this.itemSlots[i] == item && this.itemSlots[i].count > 0) {
                return i;
            }
        }
        return -1;
    }
    public int firstEmptyItemSlot() {
        for(int j = 0; j < this.itemSlots.length; j++) {
            if(this.itemSlots[j] == null || this.itemSlots[j].count == 0) {
                return j;
            }
        }
        return -1;
    }
    public Player setItemSlotsMax(int n) {
        if(this.itemSlots.length != n) {
            this.itemSlots = Arrays.copyOf(this.itemSlots, n);
            this.itemSlotCounts = Arrays.copyOf(this.itemSlotCounts, n);
        }
        return this;
    }
    public Player equipWeapon(int slot) {
        Weapon w = (Weapon) this.itemSlots[slot];
        this.removeItem(slot);
        this.equipWeapon(w);
        return this;
    }
    public Player unequipWeapon() {
        if(this.getWeapon() != null){
            this.addItem(this.getWeapon());
            this.unequipWeapon();
        }
        return this;
    }
    public Player equipArmour(int slot) {
        Armour a = (Armour)this.itemSlots[slot];
        this.removeItem(slot);
        this.equipArmour(a);
        return this;
    }
    public Player unequipArmour() {
        if(this.getArmour() != null){
            this.addItem(this.getArmour());
            this.unequipArmour();
        }
        return this;
    }
    public Player setNotes(String notes) {
        this.notes = notes;
        return this;
    }
    public String getNotes() {
        return this.notes;
    }
    
    // Gonna break style (horribly?) for a tiny bit. Hope your word-wrap's off!
    public void addFollower(String name, Actor follower) { this.followers.put(name.toLowerCase(), follower); } public void removeFollower(String follower) { this.followers.remove(follower.toLowerCase()); } public Actor getFollower(String follower) { return this.followers.get(follower.toLowerCase()); } public Boolean hasFollower(String follower) { return this.followers.containsKey(follower.toLowerCase()); } public Boolean hasAnyFollowers() { return !this.followers.isEmpty(); }
    public void addLover(String name, Actor lover) { this.lovers.put(name.toLowerCase(), lover); }             public void removeLover(String lover) { this.lovers.remove(lover.toLowerCase()); }             public Actor getLover(String lover) { return this.lovers.get(lover.toLowerCase()); }             public Boolean hasLover(String lover) { return this.lovers.containsKey(lover.toLowerCase()); }             public Boolean hasAnyLovers() { return !this.lovers.isEmpty(); }
    public void addSlave(String name, Actor slave) { this.slaves.put(name.toLowerCase(), slave); }             public void removeSlave(String slave) { this.slaves.remove(slave.toLowerCase()); }             public Actor getSlave(String slave) { return this.slaves.get(slave.toLowerCase()); }             public Boolean hasSlave(String slave) { return this.slaves.containsKey(slave.toLowerCase()); }             public Boolean hasAnySlaves() { return !this.slaves.isEmpty(); }
    
    public Actor addPlace(Location place) {
        this.places.add(place);
        return this;
    }
    public Actor removePlace(Location place) {
	    this.places.remove(place);
	    return this;
    }
    public Boolean canExplorePlace(Location place) {
    	return this.places.contains(place);
    }
    
    public Boolean hasAnyExplorables() {
        for(Location l : this.places) {
            if(l.goesInExploreMenu()) {
                return true;
            }
        }
        return false;
    }
    public Boolean hasAnyPlaces() {
        for(Location l : this.places) {
            if(l.goesInPlacesMenu()) {
                return true;
            }
        }
        return false;
    }
    
    public Integer getNumberOfTimesExplored() {
    	return numberOfTimesExplored;
    }
    public void incrementNumberOfTimesExplored() {
        this.numberOfTimesExplored++;
    }
}
