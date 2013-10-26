package com.fenoxo.coc.zadenikt_java_port;

import java.util.ArrayList;
import java.util.List;

import com.fenoxo.coc.zadenikt_java_port.characteristics.ArmType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.EarType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.EyeType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.FaceType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.HornType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.LowerBodyType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.TongueType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.WingType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.creation.Gender;
import com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts.BreastRow;
import com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts.Cock;
import com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts.Hair;
import com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts.Skin;
import com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts.Tail;
import com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts.Vagina;
import com.fenoxo.coc.zadenikt_java_port.equipment.Armour;
import com.fenoxo.coc.zadenikt_java_port.equipment.Item;
import com.fenoxo.coc.zadenikt_java_port.equipment.Weapon;

/** NOTES:
 * getXPToLevelUpTease is slightly different than the real algorithm. Maybe.
 *     I couldn't really tell what the real algorithm was doing.
 *
 */

public abstract class Actor {
	// TODO Make all public variables protected.
	protected String name, description;
	protected int strength, toughness, speed, intelligence, libido, sensitivity;
	public int corruption;
	public int health, lust, fatigue;
	public int xp, level;
	public int xpTease, levelTease;
	public int gems;
	protected List<Perk> perks = new ArrayList<Perk>();
	protected List<StatusEffect> statusEffects = new ArrayList<StatusEffect>();
	protected Weapon weapon;
	protected Armour armour;
	
	protected Item itemSlots[] = {null, null, null}; //This can be increased by setItemSlotsMax()
	protected int itemSlotCounts[] = {0, 0, 0};
	
	public double femininity, height, thickness, tone;
	public double hips, butt;
	//Don't put a beard in (abandoned feature), but leave this todo here just in case.
	public Hair hair;
	public EyeType eyes;
	public Skin skin;
	public FaceType face;
	public TongueType tongue;
	public EarType ears;
	public ArmType arms;
	public HornType horns;
	public WingType wings;
	public LowerBodyType lowerBody;
	public Tail tail;
	public boolean antennae;
	//TODO Put in gills if they actually exist.
	//TODO Piercings
	public List<Cock> cocks = new ArrayList<Cock>();
	public List<BreastRow> breasts = new ArrayList<BreastRow>();
	public Vagina vagina;
	
	public String getName() { return this.name; }
	public String toString() { return this.getName(); }
	public String getDescription() { return this.description; }
	public int getStrength() { return this.strength; }
	public int getToughness() { return this.toughness; }
	public int getSpeed() { return this.speed; }
	public int getIntelligence() { return this.intelligence; }
	public int getLibido() { return this.libido; }
	public int getSensitivity() { return this.sensitivity; }
	public int getLust() { return this.lust; }
	public int getFatigue() { return this.fatigue; }
	public int getCorruption() { return this.corruption; }
	
	public boolean hasStatusEffect(StatusEffect se) { return this.statusEffects.contains(se); }
	
	public int getMaxHealth() {
		int max = 50 + (2 * this.getToughness());
		if(this.hasPerk(Perk.LEVELUP_TANK)) max += 50;
		if(this.hasPerk(Perk.LEVELUP_TANK_2)) max += this.getToughness();
		max += 15 * ((this.getLevel() <= 20) ? this.getLevel() : 20);
		return ((max > 999) ? 999 : max);
	}
	public int getCurHealth() { return this.health; }
	public int getHealth() { return this.getCurHealth(); }
	public int getHealthPercent() { return this.getCurHealth() / this.getMaxHealth(); }

	public int getLevel() { return this.level; }
	public int getXP() { return this.xp; }
	public int getXPToLevelUp() { return this.getLevel() * 100; }
	public int getXPToLevelUpRemaining() { return this.getXPToLevelUp() - this.getXP(); }
	public int getLevelTease() { return this.levelTease; }
	public int getXPTease() { return this.xpTease; }
	public int getXPToLevelUpTease() {
		if(this.getLevelTease() >= 5) return -1;
		return (int)(Math.floor(10 + (5 * Math.pow(this.getLevelTease() + 1, 2)))); // TODO Is this the right formula? *Shudder*...
	}
	public int getXPToLevelUpTeaseRemaining() { return this.getXPToLevelUpTease() - this.getXPTease(); }
	
	public Gender getGender() { return Gender.get(this); }
	
	public int getCockCount() { return this.cocks.size(); }
	public boolean hasCock() { return this.getCockCount() > 0; }
	
	public boolean hasVagina() { return this.vagina != null; }
	public Vagina getVagina() { return this.vagina; }
	public void setVagina(Vagina v) { this.vagina = v; }
	public Vagina ifNoVaginaMakeOne() { return this.ifNoVaginaMakeOne(new Vagina()); }
	public Vagina ifNoVaginaMakeOne(Vagina vagina) {
		if(!this.hasVagina()) this.setVagina(vagina);
		return this.getVagina();
	}
	public double getVaginaCapacity() {
		if(this.getVagina() == null) return 0;
		double capacity = 0.0;
		if(this.lowerBody == LowerBodyType.NAGA)		capacity += 20.0;
		if(this.lowerBody == LowerBodyType.CENTAUR)		capacity += 50.0;
		if(this.hasPerk(Perk.GIFT_WET_PUSSY))			capacity += 20.0;
		if(this.hasPerk(Perk.HISTORY_SLUT))				capacity += 20.0;
		if(this.hasPerk(Perk.HOLIDAY_ONE_TRACK_MIND))	capacity += 10.0;
		if(this.hasPerk(Perk.HOLIDAY_CORNUCOPIA))		capacity += 30.0;
		capacity += (8 * this.vagina.getLooseness()) * (1 + (this.vagina.getWetness() / 10));
		return capacity;
	}

	public int getBreastRowsCount() { return this.breasts.size(); }
	public BreastRow largestBreasts() {
		BreastRow largest = this.breasts.get(0);
		for(BreastRow boobies : this.breasts)
			if(boobies.getSize() > largest.getSize())
				largest = boobies;
		return largest;
	}
	public BreastRow lactatestBreasts() {
		BreastRow lactatestIsTooAWord = this.breasts.get(0);
		for(BreastRow boobies : this.breasts)
			if(boobies.getLactation() > lactatestIsTooAWord.getSize())
				lactatestIsTooAWord = boobies;
		return lactatestIsTooAWord;
	}
	public int getBreastCount() {
		int boobs = 0;
		for(BreastRow row : this.breasts)
			boobs += row.getBreastsInRow();
		return boobs;
	}
	public int getNippleCount() {
		int nipples = 0;
		for(BreastRow row : this.breasts)
			nipples += (row.getBreastsInRow() * row.getNipplesPerBreast());
		return nipples;
	}
	public boolean hasFuckableNipples() {
		for(BreastRow row : this.breasts)
			if(row.isFuckable()) return true;
		return false; 
	}

	public int getCockTypeCount(Cock.Type type) {
		int count = 0;
		for(Cock c : this.cocks)
			if(c.getType() == type) count++;
		return count;
	}
	
	public boolean hasTail() { return this.tail != null && this.tail.getType() != Tail.Type.NONE; }
	
	public void addPerk(Perk p) {
		if(!this.hasPerk(p)) {
			this.perks.add(p);
			p.add(this);
		}
	}
	public void removePerk(Perk p) {
		if(this.hasPerk(p)) {
			this.perks.remove(p);
			p.remove(this);
		}
	}
	public boolean hasPerk(Perk p) {
		return this.perks.contains(p);
	}
	public boolean addItem(Item i) { //TODO Add inventory toss-out.
		int slot = this.firstEmptyItemSlot();
		if(slot == -1) {
			System.out.println(this.toString() + " would've got the item " + i.name + ", but their inventory is full!");
			return false;
		}
		
		System.out.println(this.toString() + " got the item " + i.name + "!");
		this.itemSlots[slot] = i;
		this.itemSlotCounts[slot] = 1;
		return true;
	}
	public void removeItem(int slot) {
		if(this.itemSlots[slot - 1] == null) {
			this.itemSlotCounts[slot - 1] = 0;
			return;
		}
		this.itemSlotCounts[slot - 1]--;
		if(this.itemSlotCounts[slot - 1] == 0) this.itemSlots[slot - 1] = null;
	}
	public void removeItem(Item i) {
		this.removeItem(this.firstItemSlot(i));
	}
	public boolean hasItem(Item i) {
		return this.firstItemSlot(i) != -1;
	}
	public void useItem(int i) {
		this.useItem(this.itemSlots[i]);
	}
	public void useItem(Item i) {
		i.action(this); //TODO See if this actually works.
	}
	public int firstItemSlot(Item i) {
		for(int j = 0; j < this.itemSlots.length; j++) {
			if(this.itemSlots[j] == i && this.itemSlotCounts[j] > 0) return j;
		}
		return -1;
	}
	public int firstEmptyItemSlot() {
		for(int j = 0; j < this.itemSlots.length; j++) {
			if(this.itemSlots[j] == null || this.itemSlotCounts[j] == 0) return j;
		}
		return -1;
	}
	public void setItemSlotsMax(int n) {
		if(this.itemSlots.length == n) return;
		Item oldSlots[] = new Item[this.itemSlots.length];
		int oldCounts[] = new int[this.itemSlots.length];
		for(int i = 0; i < this.itemSlots.length; i++) {
			oldSlots[i] = this.itemSlots[i];
			oldCounts[i] = this.itemSlotCounts[i];
		}
		this.itemSlots = new Item[n];
		this.itemSlotCounts = new int[n];
		for(int i = 0; i < n; i++) {
			this.itemSlots[i] = oldSlots[i];
			this.itemSlotCounts[i] = oldCounts[i];
		}
	}
	public Weapon getWeapon() { return this.weapon; }
	public void equipWeapon(int slot) {
		Weapon w = (Weapon)this.itemSlots[slot - 1];
		this.removeItem(slot);
		this.equipWeapon(w);
	}
	public void equipWeapon(Weapon w) {
		this.unequipWeapon();
		this.weapon = w;
		System.out.println(this.toString() + " equipped the weapon " + this.weapon.name + "!");
	}
	public void unequipWeapon() {
		if(this.weapon == null) return;
		System.out.println(this.toString() + " unequipped the weapon " + this.weapon.name + "!");
		this.addItem(this.weapon);
		this.weapon = null;
	}
	public Armour getArmour() { return this.armour; }
	public void equipArmour(int slot) {
		Armour a = (Armour)this.itemSlots[slot - 1];
		this.removeItem(slot);
		this.equipArmour(a);
	}
	public void equipArmour(Armour a) {
		this.unequipArmour();
		this.armour = a;
		System.out.println(this.toString() + " equipped the armour " + a.name + "!");
	}
	public void unequipArmour() {
		if(this.armour == null) return;
		System.out.println(this.toString() + " unequipped the armour " + this.armour.name + "!");
		this.addItem(this.armour);
		this.armour = null;
	}
	//Descriptions
	public String describeBodyType() {
		String out = "";
		if(this.thickness < 10) {
			if(this.tone > 90) out += "a lithe body covered in highly visible muscles";
			else if(this.tone > 75) out += "an incredibly thin, well-muscled frame";
			else if(this.tone > 50) out += "a very thin body that has a good bit of muscle definition";
			else if(this.tone > 25) out += "a lithe body and only a little bit of muscle definition";
			else out += "a waif-thin body, and soft, forgiving flesh";
		}
		else if(this.thickness < 25) {
			if(this.tone > 90) out += "a thin body and incredible muscle definition";
			else if(this.tone > 75) out += "a narrow frame that shows off your muscles";
			else if(this.tone > 50) out += "a somewhat lithe body and a fair amount of definition";
			else if(this.tone > 25) out += "a narrow, soft body that still manages to show off a few muscles";
			else out += "a thin, soft body";
		}
		//Somewhat thin
		else if(thickness < 40) {
			if(this.tone > 90) out += "a fit, somewhat thin body and rippling muscles all over";
			else if(this.tone > 75) out += "a thinner-than-average frame and great muscle definition";
			else if(this.tone > 50) out += "a somewhat narrow body and a decent amount of visible muscle";
			else if(this.tone > 25) out += "a moderately thin body, soft curves, and only a little bit of muscle";
			else out += "a fairly thin form and soft, cuddle-able flesh";
		}
		//average
		else if(thickness < 60) {
			if(this.tone > 90) out += "average thickness and a bevy of perfectly defined muscles";
			else if(this.tone > 75) out += "an average-sized frame and great musculature";
			else if(this.tone > 50) out += "a normal waistline and decently visible muscles";
			else if(this.tone > 25) out += "an average body and soft, unremarkable flesh";
			else out += "an average frame and soft, unthis.toned flesh with a tendency for jiggle";
		}
		else if(thickness < 75) {
			if(this.tone > 90) out += "a somewhat thick body that's covered in slabs of muscle";
			else if(this.tone > 75) out += "a body that's a little bit wide and has some highly-visible muscles";
			else if(this.tone > 50) out += "a solid build that displays a decent amount of muscle";
			else if(this.tone > 25) out += "a slightly wide frame that displays your curves and has hints of muscle underneath";
			else out += "a soft, plush body with plenty of jiggle";
		}
		else if(thickness < 90) {
			if(this.tone > 90) out += "a thickset frame that gives you the appearance of a wall of muscle";
			else if(this.tone > 75) out += "a burly form and plenty of muscle definition";
			else if(this.tone > 50) out += "a solid, thick frame and a decent amount of muscles";
			else if(this.tone > 25) out += "a wide-set body, some soft, forgiving flesh, and a hint of muscle underneath it";
			else {
				out += "a wide, cushiony body";
				if(Gender.get(this) == Gender.HERM || this.largestBreasts().getSize() > 3 || this.hips > 7 || this.butt > 7) out += " and plenty of jiggle on your curves";
			}
		}
		//Chunky monkey
		else {
			if(this.tone > 90) out += "an extremely thickset frame and so much muscle others would find you harder to move than a huge boulder";
			else if(this.tone > 75) out += "a very wide body and enough muscle to make you look like a tank";
			else if(this.tone > 50) out += "an extremely substantial frame packing a decent amount of muscle";
			else if(this.tone > 25) {
				out += "a very wide body";
				if(Gender.get(this) == Gender.HERM || this.largestBreasts().getSize() > 4 || this.hips > 10 || this.butt > 10) out += ", lots of curvy jiggles,";
				out += " and hints of muscle underneath";
			}
			else {
				out += "a thick";
				if(Gender.get(this) == Gender.HERM || this.largestBreasts().getSize() > 4 || this.hips > 10 || this.butt > 10) out += ", voluptuous";
				out += " body and plush, ";
				if(Gender.get(this) == Gender.HERM || this.largestBreasts().getSize() > 4 || this.hips > 10 || this.butt > 10) out += " jiggly curves";
				else out += " soft flesh";   
			}
		}
		return out;
	}
	//Scores
	public int humanScore() {
		int score = 0;
		if(this.face == FaceType.NORMAL) score++;
		if(this.skin.getType() == Skin.Type.NORMAL) score++;
		if(this.horns == HornType.NONE) score++;
		if(this.tail.getType() == Tail.Type.NONE) score++;
		if(this.wings == WingType.NONE) score++;
		if(this.lowerBody == LowerBodyType.NORMAL) score++;
		if(this.getCockCount() == 1 && this.getCockTypeCount(Cock.Type.NORMAL) == 1) score++;
		if(this.getBreastRowsCount() == 1 && this.skin.getType() == Skin.Type.NORMAL) score++;
		return score;
	}
	public int demonScore() {
		int score = 0;
		if(this.horns == HornType.DEMONIC) score++;
		if(this.tail.getType() == Tail.Type.DEMONIC) score++;
		if(this.wings == WingType.DEMONIC || this.wings == WingType.DEMONIC_LARGE) score++;
		if(this.skin.getType() == Skin.Type.NORMAL && this.corruption > 50) score++;
		if(this.face == FaceType.NORMAL && this.corruption > 50) score++;
		if(this.lowerBody == LowerBodyType.DEMON_CLAWS || this.lowerBody == LowerBodyType.DEMON_HEELS) score++;
		if(this.getCockTypeCount(Cock.Type.DEMON) > 0) score++;
		return score;
	}
	public int minotaurScore() {
		int score = 0;
		if(this.face == FaceType.COW) score++;
		if(this.ears == EarType.COW) score++;
		if(this.tail.getType() == Tail.Type.COW) score++;
		if(this.horns == HornType.MINOTAUR) score++;
		if(this.lowerBody == LowerBodyType.HOOVES && score > 0) score++;
		if(this.height > 80.0 && score > 0) score++;
		if(this.getCockCount() > 0 && score > 0 && this.getCockTypeCount(Cock.Type.HORSE) > 0) score++;
		if(this.hasVagina() && score > 0) score--;
		return score;
	}
	public int cowScore() {
		int score = 0;
		if(this.face == FaceType.NORMAL) score++;
		if(this.face == FaceType.COW) score--;
		if(this.ears == EarType.COW) score++;
		if(this.tail.getType() == Tail.Type.COW) score++;
		if(this.horns == HornType.MINOTAUR) score++;
		if(this.lowerBody == LowerBodyType.HOOVES && score > 0) score++;
		if(this.height >= 73.0 && score > 0) score++; 
		if(this.hasVagina()) score++;
		if(this.largestBreasts().getSize() > 4.0 && score > 0) score++;
		if(this.lactatestBreasts().getLactation() > 2.0 && score > 0) score++;
		return score;
	}
	public int sandTrapScore() {
		int score = 0;
		if(this.hasStatusEffect(StatusEffect.BLACK_NIPPLES)) score++;
		if(this.hasVagina() && this.getVagina().getType() == Vagina.Type.SANDTRAP) score++;
		if(this.eyes == EyeType.SAND_TRAP) score++;
		if(this.wings == WingType.SAND_TRAP) score++;
		return score;
	}
	public int beeScore() {
		int score = 0;
		if(this.hair.getColour() == Hair.Colour.SHINY_BLACK) score++;
		if(this.hair.getColour() == Hair.Colour.BLACK_AND_YELLOW) score++;
		if(this.antennae) {
			score++;
			if(this.face == FaceType.NORMAL) score++;
		}
		if(this.lowerBody == LowerBodyType.BEE) {
			score++;
			if(this.hasVagina()) score++;
		}
		if(this.tail.getType() == Tail.Type.BEE) score++;
		if(this.wings == WingType.BEE || this.wings == WingType.BEE_LARGE) score++;
		return score;
	}
	public int dogScore() {
		int score = 0;
		if(this.face == FaceType.DOG) score++;
		if(this.ears == EarType.DOG) score++;
		if(this.tail.getType() == Tail.Type.DOG) score++;
		if(this.lowerBody == LowerBodyType.PAWS) score++;
		if(this.getCockTypeCount(Cock.Type.DOG) > 0) score++;
		if(this.getBreastRowsCount() > 0) score++;
		if(this.getBreastRowsCount() == 3) score++;
		if(this.getBreastRowsCount() > 3) score--;
		if(this.skin.getType() == Skin.Type.FUR && score > 0) score++;
		return score;
	}
	public int foxScore() {
		int score = 0;
		if(this.face == FaceType.FOX) score++;
		if(this.ears == EarType.FOX) score++;
		if(this.tail.getType() == Tail.Type.FOX) score++;
		if(this.lowerBody == LowerBodyType.FOX) score++;
		if(this.getCockTypeCount(Cock.Type.DOG) > 0 && score > 0) score++;
		if(this.getBreastRowsCount() > 1) score++;
		if(this.getBreastRowsCount() == 3 || this.getBreastRowsCount() == 4) score++;
		if(this.skin.getType() == Skin.Type.FUR && score > 0) score++;
		return score;
	}
	public int catScore() {
		int score = 0;
		if(this.face == FaceType.CAT) score++;
		if(this.ears == EarType.CAT) score++;
		if(this.tail.getType() == Tail.Type.CAT) score++;
		if(this.lowerBody == LowerBodyType.CAT) score++;
		if(this.getCockTypeCount(Cock.Type.CAT) > 0) score++;
		if(this.getBreastRowsCount() > 1 && score > 0) score++;
		if(this.getBreastRowsCount() == 3 && score > 0) score++;
		if(this.getBreastRowsCount() > 3) score -= 2;
		if(this.skin.getType() == Skin.Type.FUR && score > 0) score++;
		return score;
	}
	public int lizardScore() {
		int score = 0;
		if(this.face == FaceType.LIZARD) score++;
		if(this.ears == EarType.SNAKE) score++;
		if(this.tail.getType() == Tail.Type.LIZARD) score++;
		if(this.lowerBody == LowerBodyType.LIZARD) score++;
		if(this.getCockTypeCount(Cock.Type.LIZARD) > 0) score++;
		if(this.horns == HornType.LIZARD || this.horns == HornType.QUAD_LIZARD) score++;
		if(this.skin.getType() == Skin.Type.SCALES) score++;
		return score;
	}
	public int spiderScore() {
		int score = 0;
		if(this.eyes == EyeType.SPIDER) score += 2;
		if(this.face == FaceType.SPIDER) score++;
		if(this.arms == ArmType.SPIDER) score++;
		if(this.lowerBody == LowerBodyType.DRIDER || this.lowerBody == LowerBodyType.SPIDER) score += 2;
		else if(score > 0) score--;
		if(this.tail.getType() == Tail.Type.SPIDER) score += 2;
		if(this.skin.getType() != Skin.Type.NORMAL && score > 0) score--;
		return score;
	}
	public int horseScore() {
		int score = 0;
		if(this.face == FaceType.HORSE) score++;
		if(this.ears == EarType.HORSE) score++;
		if(this.tail.getType() == Tail.Type.HORSE) score++;
		if(this.lowerBody == LowerBodyType.CENTAUR || this.lowerBody == LowerBodyType.HOOVES || this.lowerBody == LowerBodyType.MY_LITTLE_PONY) score++;
		if(this.skin.getType() == Skin.Type.FUR && score > 0) score++;
		return score;
	}
	public int kitsuneScore() {
		int score = 0;
		if(this.ears == EarType.FOX) score++;
		if(this.tail.getType() == Tail.Type.FOX) score++;
		if(this.tail.getType() == Tail.Type.FOX && this.tail.getVenom() >= 2.0) score += 2;
		if(this.getVaginaCapacity() >= 8000) score++;
		if(score > 0 && this.face == FaceType.NORMAL) score++;
		if(score > 0 && (this.hair.getColour() == Hair.Colour.GOLDEN_BLONDE || this.hair.getColour() == Hair.Colour.BLACK || this.hair.getColour() == Hair.Colour.RED || this.hair.getColour() == Hair.Colour.WHITE || this.hair.getColour() == Hair.Colour.SILVER_BLONDE)) score++;
		if(score > 0 && this.femininity >= 40) score++;
		
		if(this.skin.getType() == Skin.Type.NORMAL) score--;
		else if(this.skin.getType() != Skin.Type.FUR) score -= 2;
		if(this.lowerBody != LowerBodyType.NORMAL) score--;
		if(this.face != FaceType.NORMAL) score--;
		if(this.ears != EarType.FOX) score--;
		if(this.tail.getType() != Tail.Type.FOX) score--;
		return score;
	}
	public int dragonScore() {
		int score = 0;
		throw new RuntimeException("dragon");
		//return score;
	}
	public int goblinScore() {
		int score = 0;
		throw new RuntimeException("goblin");
		//return score;
	}
	public int gooScore() {
		int score = 0;
		throw new RuntimeException("goo");
		//return score;
	}
	public int nagaScore() {
		int score = 0;
		throw new RuntimeException("naga");
		//return score;
	}
	public int rabbitScore() {
		int score = 0;
		throw new RuntimeException("rabbit");
		//return score;
	}
	public int harpyScore() {
		int score = 0;
		throw new RuntimeException("harpy");
		//return score;
	}
	public int kangarooScore() {
		int score = 0;
		throw new RuntimeException("kangaroo");
		//return score;
	}
	public int sharkScore() {
		int score = 0;
		throw new RuntimeException("shark");
		//return score;
	}
	public int mutantScore() {
		int score = 0;
		if(this.face != FaceType.NORMAL) score++;
		if(this.skin.getType() != Skin.Type.NORMAL) score++;
		if(this.hasTail()) score++;
		if(this.getCockCount() > 1) score++;
		if(this.hasCock() && this.hasVagina()) score++;
		if(this.hasFuckableNipples()) score++;
		if(this.getBreastRowsCount() > 1) score++;
		if(score > 0) score--;
		return score;
	}
	//ACTIONSCRIPT { TODO
	/*
	//Determine Horse Rating
	public function dragonScore():Number {
		var dragonCounter:Number = 0;
		if(faceType == 12) dragonCounter++;
		if(earType == 10) dragonCounter++;
		if(tailType == 14) dragonCounter++;
		if(tongueType == 3) dragonCounter++;
		if(dragonCocks() > 0) dragonCounter++;
		if(wingType == 10) dragonCounter++;
		if(wingType == 11) dragonCounter += 2;
		if(lowerBody == 18) dragonCounter++;
		if(skinType == 2 && dragonCounter > 0) dragonCounter++;
		return dragonCounter;
	}
	//Goblinscore
	public function goblinScore():Number {
		var horseCounter:Number = 0;
		if(earType == 4) horseCounter++;
		if(skinTone == "pale yellow" || skinTone == "grayish-blue" || skinTone == "green" || skinTone == "dark green") horseCounter++;
		if(horseCounter > 0) {
			if(faceType == 0) horseCounter++;
			if(tallness < 48) horseCounter++;
			if(hasVagina()) horseCounter++;
			if(lowerBody == 0) horseCounter++;
		}				
		return horseCounter;
	}
	//Gooscore
	public function gooScore():Number {
		var gooCounter:Number = 0;
		if(hairType == 3) gooCounter++;
		if(skinAdj == "slimy") gooCounter++;
		if(lowerBody == 8) gooCounter++;
		if(vaginalCapacity() > 9000) gooCounter++;
		if(hasStatusAffect("Slime Craving") >= 0) gooCounter++;
		return gooCounter;
	}
	//Nagascore
	public function nagaScore():Number {
		var nagaCounter:Number = 0;
		if(faceType == 5) nagaCounter++;
		if(tongueType == 1) nagaCounter++;
		if(nagaCounter > 0 && antennae == 0) nagaCounter++;
		if(nagaCounter > 0 && wingType == 0) nagaCounter++;
		return nagaCounter;
	}
	//Bunnyscore
	public function bunnyScore():Number {
		var bunnyCounter:Number = 0;
		if(faceType == 8) bunnyCounter++;
		if(tailType == 10) bunnyCounter++;
		if(earType == 7) bunnyCounter++;
		if(lowerBody == 12) bunnyCounter++;
		//More than 2 balls reduces bunny score
		if(balls > 2 && bunnyCounter > 0) bunnyCounter--;
		//Human skin on bunmorph adds
		if(skinType == 0 && bunnyCounter > 1) bunnyCounter++;
		//No wings and antennae a plus
		if(bunnyCounter > 0 && antennae == 0) bunnyCounter++;
		if(bunnyCounter > 0 && wingType == 0) bunnyCounter++;
		return bunnyCounter;
	}
	//Harpyscore
	public function harpyScore():Number {
		var harpy:Number = 0;
		if(armType == 1) harpy++;
		if(hairType == 1) harpy++;
		if(wingType == 9) harpy++;
		if(tailType == 11) harpy++;
		if(lowerBody == 13) harpy++;
		if(harpy >= 2 && faceType == 0) harpy++;
		if(harpy >= 2 && (earType == 0 || earType == 4)) harpy++;
		return harpy;
	}
	//Kangascore
	public function kangaScore():Number {
		var kanga:Number = 0;
		if(kangaCocks() > 0) kanga++;
		if(earType == 8) kanga++;
		if(tailType == 12) kanga++;
		if(lowerBody == 14) kanga++;
		if(faceType == 9) kanga++;
		if(kanga >= 2 && skinType == 1) kanga++;
		return kanga;
	}
	//sharkscore
	public function sharkScore():Number {
		var sharkCounter:Number = 0;
		if(faceType == 4) sharkCounter++;
		if(wingType == 8) sharkCounter++;
		if(tailType == 7) sharkCounter++;
		return sharkCounter;
	}/*/
	
	//DEBUG FOLLOWETH
	public void printInventory() {
		for(int i = 0; i < this.itemSlots.length; i++) {
			System.out.println((i + 1) + " - " + this.itemSlotCounts[i] + "x" + (this.itemSlots[i] == null ? "Empty" : this.itemSlots[i].name));
		}
	}
}
