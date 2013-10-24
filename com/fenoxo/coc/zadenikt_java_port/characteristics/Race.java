package com.fenoxo.coc.zadenikt_java_port.characteristics;

import com.fenoxo.coc.zadenikt_java_port.Actor;
import com.fenoxo.coc.zadenikt_java_port.characteristics.creation.Gender;

public enum Race {
	HUMAN("human"),
	CENTAUR("centaur"),
	MY_LITTLE_PONY("pony-kin"),
	CAT("cat-boy", "cat-girl"),
	LIZARD("lizan", "male lizan", "female lizan", "hermaphrodite lizan"),
	DRAGON("dragon-man", "dragon-girl"),
	DOG("dog-morph"),
	FOX("fox-morph", "fox-girl"),
	KITSUNE("kitsune"),
	HORSE("equine-morph"),
	MINOTAUR("minotaur-morph"),
	COW("cow-morph", "cow-girl"),
	BEE("bee-morph"),
	GOBLIN("goblin"),
	DEMON("demon-morph"),
	SHARK("shark-morph"),
	RABBIT("bunny-boy", "bunny-girl"),
	HARPY("avian", "harpy"),
	SPIDER("spider-morph", "spider-girl"),
	DRIDER("drider"),
	KANGAROO("kangaroo-morph"),
	NAGA("naga"),
	GOO("goo-boi", "goo-girl"),
	SEMI_MUTANT("somewhat human mutant"),
	MUTANT("corrupted mutant");
	
	private String none, male, female, hermaphrodite;

	private Race(String text) { this.none = this.male = this.female = this.hermaphrodite = text; }
	private Race(String m, String f) {
		this.none = this.male = m;
		this.female = this.hermaphrodite = f;
	}
	private Race(String n, String m, String f, String h) {
		this.none = n;
		this.male = m;
		this.female = f;
		this.hermaphrodite = h;
	}
	
	public String getGenderless() { return this.none; }
	public String getMale() { return this.male; }
	public String getFemale() { return this.female; }
	public String getHermaphrodite() { return this.hermaphrodite; }
	public String getString(Gender g) {
		switch(g) {
		case MALE:
			return this.getMale();
		case FEMALE:
			return this.getFemale();
		case HERM:
			return this.getHermaphrodite();
		case NONE:
		default:
			return this.getGenderless();
		}
	}
	
	public static Race getRace(Actor a) {
		if(a.lowerBody == LowerBodyType.CENTAUR) return CENTAUR;
		else if(a.lowerBody == LowerBodyType.MY_LITTLE_PONY) return MY_LITTLE_PONY;
		else if(a.catScore() >= 4) return CAT;
		else if(a.lizardScore() >= 4) return LIZARD;
		else if(a.dragonScore() >= 4) return DRAGON;
		else if(a.dogScore() >= 4) return DOG;
		else if(a.foxScore() >= 4) return FOX;
		else if(a.kitsuneScore() >= 4) return KITSUNE;
		else if(a.horseScore() >= 3) return HORSE;
		else if(a.minotaurScore() >= 4) return MINOTAUR;
		else if(a.cowScore() >= 6) return COW;
		else if(a.beeScore() >= 5) return BEE;
		else if(a.goblinScore() >= 5) return GOBLIN;
		else if(a.demonScore() >= 5) return DEMON;
		else if(a.sharkScore() >= 3) return SHARK;
		else if(a.rabbitScore() >= 4) return RABBIT;
		else if(a.harpyScore() >= 4) return HARPY;
		else if(a.spiderScore() >= 4) {
			if(a.lowerBody == LowerBodyType.DRIDER) return DRIDER;
			else return SPIDER;
		}
		else if(a.kangarooScore() >= 4) return KANGAROO;
		else if(a.lowerBody == LowerBodyType.NAGA) return NAGA; // a.nagaScore()?
		else if(a.gooScore() >= 3) return GOO;
		else if(a.mutantScore() >= 5) {
			if(a.humanScore() >= 5) return SEMI_MUTANT;
			else return MUTANT;
		}
		else return HUMAN;
	}
	public static String get(Actor a) { return getRace(a).getString(Gender.get(a)); }
}
