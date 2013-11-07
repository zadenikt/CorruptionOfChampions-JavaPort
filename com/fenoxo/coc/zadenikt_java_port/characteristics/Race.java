package com.fenoxo.coc.zadenikt_java_port.characteristics;

import com.fenoxo.coc.zadenikt_java_port.actors.Actor;
import com.fenoxo.coc.zadenikt_java_port.util.Describer;

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

  private Race(String text) { 
    this.none = this.male = this.female = this.hermaphrodite = text; 
  }
  
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
  
  public String getGenderless() {
    return this.none;
  }

  public String getMale() {
    return this.male;
  }

  public String getFemale() {
    return this.female;
  }

  public String getHermaphrodite() {
    return this.hermaphrodite;
  }
  
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
    if (a.getLowerBody() == LowerBodyType.CENTAUR) {
      return CENTAUR;
    } else if (a.getLowerBody() == LowerBodyType.MY_LITTLE_PONY) {
      return MY_LITTLE_PONY;
    } else if (Describer.catScore(a) >= 4) {
      return CAT;
    } else if (Describer.lizardScore(a) >= 4) {
      return LIZARD;
    } else if (Describer.dragonScore(a) >= 4) {
      return DRAGON;
    } else if (Describer.dogScore(a) >= 4) {
      return DOG;
    } else if (Describer.foxScore(a) >= 4) {
      return FOX;
    } else if (Describer.kitsuneScore(a) >= 4) {
      return KITSUNE;
    } else if (Describer.horseScore(a) >= 3) {
      return HORSE;
    } else if (Describer.minotaurScore(a) >= 4) {
      return MINOTAUR;
    } else if (Describer.cowScore(a) >= 6) {
      return COW;
    } else if (Describer.beeScore(a) >= 5) {
      return BEE;
    } else if (Describer.goblinScore(a) >= 5) {
      return GOBLIN;
    } else if (Describer.demonScore(a) >= 5) {
      return DEMON;
    } else if (Describer.sharkScore(a) >= 3) {
      return SHARK;
    } else if (Describer.rabbitScore(a) >= 4) {
      return RABBIT;
    } else if (Describer.harpyScore(a) >= 4) {
      return HARPY;
    } else if (Describer.spiderScore(a) >= 4) {
      return (a.getLowerBody() == LowerBodyType.DRIDER) ? DRIDER : SPIDER;
    } else if (Describer.kangarooScore(a) >= 4) {
      return KANGAROO;
    } else if (Describer.nagaScore(a) >= 4) {
      return NAGA; // a.nagaScore()?
    } else if (Describer.gooScore(a) >= 3) {
      return GOO;
    } else if (Describer.mutantScore(a) >= 5) {
      return (Describer.humanScore(a) >= 5) ? SEMI_MUTANT : MUTANT;
    } else {
      return HUMAN;
    }
  }

  public static String get(Actor a) {
    return getRace(a).getString(a.getGender());
  }
}
