package com.fenoxo.coc.zadenikt_java_port.actors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fenoxo.coc.zadenikt_java_port.characteristics.ArmType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Balls;
import com.fenoxo.coc.zadenikt_java_port.characteristics.BreastRow;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Cock;
import com.fenoxo.coc.zadenikt_java_port.characteristics.EarType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.EyeType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.FaceType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Gender;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Hair;
import com.fenoxo.coc.zadenikt_java_port.characteristics.HornType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.LowerBodyType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Perk;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Skin;
import com.fenoxo.coc.zadenikt_java_port.characteristics.StatusEffect;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Tail;
import com.fenoxo.coc.zadenikt_java_port.characteristics.TongueType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Vagina;
import com.fenoxo.coc.zadenikt_java_port.characteristics.WingType;
import com.fenoxo.coc.zadenikt_java_port.equipment.Armour;
import com.fenoxo.coc.zadenikt_java_port.equipment.Weapon;
import com.fenoxo.coc.zadenikt_java_port.util.RuntimeMostest;
import com.fenoxo.coc.zadenikt_java_port.util.RuntimeTest;

public abstract class Actor {
	// Name and Description
    private String name, description;
    // Base Stats
    private Integer strength, toughness, speed, intelligence, libido, sensitivity, corruption;
    private Integer health, lust, fatigue;
    // Level Stats
    private Integer xp, level;
    private Integer teaseXP, teaseLevel;
    // Money
    private Integer gems;
    // Effects
    private Set<Perk> perks = new HashSet<>();
    private Set<StatusEffect> statusEffects = new HashSet<>();
    // Equipment
    private Weapon weapon;
    private Armour armour;
    // Appearance Stats
    private Double femininity, height, thickness, tone, hips, butt;
    private Hair hair;
    private EyeType eyes;
    private Skin skin;
    private FaceType face;
    private TongueType tongue;
    private EarType ears;
    private ArmType arms;
    private HornType horns;
    private WingType wings;
    private LowerBodyType lowerBody;
    private Tail tail;
    private Boolean hasAntennae;
    // Piercings
    	// TODO!!!
    // Sex Organs
    private Balls balls;
    private List<Cock> cocks = new ArrayList<>();
    private List<BreastRow> breasts = new ArrayList<>();
    private Vagina vagina;
    
    // Name and Description
    public String getName() {
    	return this.name;
    }
    public String toString() {
    	return this.getName();
    }
    public String getDescription() {
    	return this.description;
    }
    public Actor setName(String name) {
    	this.name = name;
    	return this;
    }
    public Actor setDescription(String desc) {
    	this.description = desc;
    	return this;
    }
    // Base Stats
    public Integer getStrength() {
    	return this.strength;
    }
    public Integer getToughness() {
    	return this.toughness;
    }
    public Integer getSpeed() {
    	return this.speed;
    }
    public Integer getIntelligence() {
    	return this.intelligence;
    }
    public Integer getLibido() {
    	return this.libido;
    }
    public Integer getSensitivity() {
    	return this.sensitivity;
    }
    public Integer getCorruption() {
    	return this.corruption;
    }
    public Integer getHealth() {
    	return this.health;
    }
    public Integer getMaxHealth() {
        Integer max = 50 + (2 * this.getToughness());
        if(this.hasPerk(Perk.LEVELUP_TANK)) {
            max += 50;
        }
        if(this.hasPerk(Perk.LEVELUP_TANK_2)) {
            max += this.getToughness();
        }
        max += 15 * ((this.getLevel() <= 20) ? this.getLevel() : 20);
        return ((max > 700) ? 700 : max); // 700 *should* be the highest health.
    }
    public Double getHealthPercent() {
        return this.getHealth().doubleValue() / this.getMaxHealth().doubleValue();
    }
    public Integer getLust() {
    	return this.lust;
    }
    public Integer getFatigue() {
    	return this.fatigue;
    }
    public Actor setStrength(Integer strength) {
    	this.strength = strength;
    	return this;
    }
    public Actor setToughness(Integer toughness) {
    	this.toughness = toughness;
    	return this;
    }
    public Actor setSpeed(Integer speed) {
    	this.speed = speed;
    	return this;
    }
    public Actor setIntelligence(Integer intelligence) {
    	this.intelligence = intelligence;
    	return this;
    }
    public Actor setLibido(Integer libido) {
    	this.libido = libido;
    	return this;
    }
    public Actor setSensitivity(Integer sensitivity) {
    	this.sensitivity = sensitivity;
    	return this;
    }
    public Actor setCorruption(Integer corruption) {
    	this.corruption = corruption;
    	return this;
    }
    public Actor setHealth(Integer health) {
    	this.health = health;
    	return this;
    }
    public Actor setLust(Integer lust) {
    	this.lust = lust;
    	return this;
    }
    public Actor setFatigue(Integer fatigue) {
    	this.fatigue = fatigue;
    	return this;
    }
    // Level Stats
    public Integer getXP() {
    	return this.xp;
    }
    public Integer getXPToLevelUp() {
        return this.getLevel() * 100;
    }
    public Integer getXPToLevelUpRemaining() {
        return this.getXPToLevelUp() - this.getXP();
    }
    public Integer getLevel() {
    	return this.level;
    }
    public Integer getTeaseXP() {
    	return this.teaseXP;
    }
    public Integer getTeaseXPToLevelUp() {
        return this.getTeaseLevel() == 0 ?
          15 : this.getTeaseLevel() == 1 ?
          30 : this.getTeaseLevel() == 2 ?
          55 : this.getTeaseLevel() == 3 ?
          90 : this.getTeaseLevel() == 4 ?
         135 : -1;
    }
    public Integer getTeaseXPToLevelUpRemaining() {
        return this.getTeaseXPToLevelUp() - this.getTeaseXP();
    }
    public Integer getTeaseLevel() {
    	return this.teaseLevel;
    }
    public Actor setXP(Integer xp) {
    	this.xp = xp;
    	this.checkForLevelUp();
    	return this;
    }
    public Actor setLevel(Integer level) {
    	this.level = level;
    	this.checkForLevelUp();
    	return this;
    }
    public Actor setTeaseXP(Integer xp) {
    	this.teaseXP = xp;
    	this.checkForLevelUp();
    	return this;
    }
    public Actor setTeaseLevel(Integer level) {
    	this.teaseLevel = level;
    	this.checkForLevelUp();
    	return this;
    }
    public void checkForLevelUp() {
    	while(this.getXP() >= this.getXPToLevelUp()) {
    		this.setXP(this.getXP() - this.getXPToLevelUp());
    		this.setLevel(this.getLevel() + 1);
    	}
    	while(this.getTeaseXP() >= this.getTeaseXPToLevelUp()) {
    		this.setTeaseXP(this.getTeaseXP() - this.getTeaseXPToLevelUp());
    		this.setTeaseLevel(this.getTeaseLevel() + 1);
    	}
    }
    // Money
    public Integer getGems() {
    	return this.gems;
    }
    public Actor setGems(Integer gems) {
    	this.gems = gems;
    	return this;
    }
    // Effects
    public Actor addStatusEffect(StatusEffect se) {
    	if(!this.hasStatusEffect(se)) {
    		this.statusEffects.add(se);
    	}
    	return this;
    }
    public Actor removeStatusEffect(StatusEffect se) {
    	if(this.hasStatusEffect(se)) {
    		this.statusEffects.remove(se);
    	}
    	return this;
    }
    public Boolean hasStatusEffect(StatusEffect se) {
        return this.statusEffects.contains(se);
    }
    public Actor addPerk(Perk p) {
        if(!this.hasPerk(p)) {
            this.perks.add(p);
            p.add(this);
        }
    	return this;
    }
    public Actor removePerk(Perk p) {
        if(this.hasPerk(p)) {
            this.perks.remove(p);
            p.remove(this);
        }
    	return this;
    }
    public Boolean hasPerk(Perk p) {
        return this.perks.contains(p);
    }
    // Equipment
    public Weapon getWeapon() {
        return this.weapon;
    }
    public Armour getArmour() {
        return this.armour;
    }
    public Actor equipWeapon(Weapon w) {
        this.unequipWeapon();
        this.weapon = w;
        System.out.println(String.format("%s equipped the weapon %s!", this.toString(), this.weapon.name));
        return this;
    }
    public Actor unequipWeapon() {
        this.weapon = null;
        return this;
    }
    public Actor equipArmour(Armour newArmour) {
        this.unequipArmour();
        this.armour = newArmour;
        System.out.println(String.format("%s equipped the armor %s!", this.toString(), newArmour.name));
        return this;
    }
    public Actor unequipArmour() {
        this.armour = null;
        return this;
    }
    // Appearance Stats
    public Double getFemininity() {
    	return this.femininity;
    }
    public Double getHeight() {
    	return this.height;
    }
    public Double getThickness() {
    	return this.thickness;
    }
    public Double getTone() {
    	return this.tone;
    }
    public Double getHips() {
    	return this.hips;
    }
    public Double getButt() {
    	return this.butt;
    }
    public Hair getHair() {
    	return this.hair;
    }
    public EyeType getEyes() {
    	return this.eyes;
    }
    public Skin getSkin() {
    	return this.skin;
    }
    public FaceType getFace() {
    	return this.face;
    }
    public TongueType getTongue() {
    	return this.tongue;
    }
    public EarType getEars() {
    	return this.ears;
    }
    public ArmType getArms() {
    	return this.arms;
    }
    public HornType getHorns() {
    	return this.horns;
    }
    public WingType getWings() {
    	return this.wings;
    }
    public LowerBodyType getLowerBody() {
    	return this.lowerBody;
    }
    public Tail getTail() {
    	return this.tail;
    }
    public Boolean hasAntennae() {
    	return this.hasAntennae;
    }
    public Actor setFemininity(Double femininity) {
    	this.femininity = femininity;
    	return this;
    }
    public Actor setHeight(Double height) {
    	this.height = height;
    	return this;
    }
    public Actor setThickness(Double thickness) {
    	this.thickness = thickness;
    	return this;
    }
    public Actor setTone(Double tone) {
    	this.tone = tone;
    	return this;
    }
    public Actor setHips(Double hips) {
    	this.hips = hips;
    	return this;
    }
    public Actor setButt(Double butt) {
    	this.butt = butt;
    	return this;
    }
    public Actor setHair(Hair hair) {
    	this.hair = hair;
    	return this;
    }
    public Actor setEyes(EyeType eyes) {
    	this.eyes = eyes;
    	return this;
    }
    public Actor setSkin(Skin skin) {
    	this.skin = skin;
    	return this;
    }
    public Actor setFace(FaceType face) {
    	this.face = face;
    	return this;
    }
    public Actor setTongue(TongueType tongue) {
    	this.tongue = tongue;
    	return this;
    }
    public Actor setEars(EarType ears) {
    	this.ears = ears;
    	return this;
    }
    public Actor setArms(ArmType arms) {
    	this.arms = arms;
    	return this;
    }
    public Actor setHorns(HornType horns) {
    	this.horns = horns;
    	return this;
    }
    public Actor setWings(WingType wings) {
    	this.wings = wings;
    	return this;
    }
    public Actor setLowerBody(LowerBodyType lowerBody) {
    	this.lowerBody = lowerBody;
    	return this;
    }
    public Actor setTail(Tail tail) {
    	this.tail = tail;
    	return this;
    }
    public Actor setAntennae(Boolean antennae) {
    	this.hasAntennae = antennae;
    	return this;
    }
    // Piercings
    	// TODO!!!
    // Sex Organs
    public Balls getBalls() {
    	return this.balls;
    }
    public Actor setBalls(Balls balls) {
    	this.balls = balls;
    	return this;
    }
    public Actor addCock(Cock c) {
    	this.cocks.add(c);
    	return this;
    }
    public Actor removeCock(Cock c) {
    	this.cocks.remove(c);
    	return this;
    }
    public Cock firstCock() {
    	return this.firstCock(new RuntimeTest<Cock>() {
    		public Boolean test(Cock cock) {
    			return true;
    		}
    	});
    }
    public Cock firstCock(RuntimeTest<Cock> test) {
    	for(Cock c : this.cocks) {
    		if(test.test(c)) {
    			return c;
    		}
    	}
    	return null;
    }
    public Cock maximizeCock(RuntimeMostest<Cock> test) {
    	if(!this.hasCock()) {
    		return null;
    	}
    	Cock mostest = this.cocks.get(0);
    	for(Cock c : this.cocks) {
    		if(test.value(c) > test.value(mostest)) {
    			mostest = c;
    		}
    	}
    	return mostest;
    }
    public Double sumCocks(RuntimeMostest<Cock> test) {
    	Double count = 0.0;
    	for(Cock c : this.cocks) {
    		count += test.value(c);
    	}
    	return count;
    }
    public Integer getCockTypeCount(final Cock.Type type) {
        return this.sumCocks(new RuntimeMostest<Cock>() {
        	public Double value(Cock c) {
        		return c.getType() == type ? 1.0 : 0.0;
        	}
        }).intValue();
    }
    public Boolean hasCock() {
        return this.getCockCount() > 0;
    }
    public Integer getCockCount() {
        return this.cocks.size();
    }
    public Actor addBreastRow(BreastRow br) {
    	this.breasts.add(br);
    	return this;
    }
    public Actor removeBreastRow(BreastRow br) {
    	this.breasts.remove(br);
    	return this;
    }
    public BreastRow maximizeBreasts(RuntimeMostest<BreastRow> test) {
    	BreastRow mostest = this.breasts.get(0);
    	for(BreastRow b : this.breasts) {
    		if(test.value(b) > test.value(mostest)) {
    			mostest = b;
    		}
    	}
    	return mostest;
    }
    public Double sumBreasts(RuntimeMostest<BreastRow> test) {
    	Double count = 0.0;
    	for(BreastRow b : this.breasts) {
    		count += test.value(b);
    	}
    	return count;
    }
    public BreastRow largestBreasts() {
        return this.maximizeBreasts(new RuntimeMostest<BreastRow>() {
        	public Double value(BreastRow b) {
        		return b.getSize();
        	}
        });
    }
    public BreastRow lactatestBreasts() {
        return this.maximizeBreasts(new RuntimeMostest<BreastRow>() {
        	public Double value(BreastRow b) {
        		return b.getLactation();
        	}
        });
    }
    public Integer getBreastCount() {
        return this.sumBreasts(new RuntimeMostest<BreastRow>() {
        	public Double value(BreastRow b) {
        		return b.getBreastsInRow().doubleValue();
        	}
        }).intValue();
    }
    public Integer getNippleCount() {
        return this.sumBreasts(new RuntimeMostest<BreastRow>() {
        	public Double value(BreastRow b) {
        		return new Integer(b.getBreastsInRow() * b.getNipplesPerBreast()).doubleValue();
        	}
        }).intValue();
    }
    public Boolean hasFuckableNipples() {
        for(BreastRow row : this.breasts) {
            if(row.isFuckable()) {
                return true;
            }
        }
        return false;
    }
    public Integer getBreastRowsCount() {
        return this.breasts.size();
    }
    public Vagina getVagina() {
    	return this.vagina;
    }
    public Actor setVagina(Vagina vagina) {
    	this.vagina = vagina;
    	return this;
    }
    public Boolean hasVagina() {
        return this.vagina != null;
    }
    public Vagina ifNoVaginaMakeOne() {
        return this.ifNoVaginaMakeOne(new Vagina());
    }
    public Vagina ifNoVaginaMakeOne(Vagina vagina) {
        if(!this.hasVagina()) {
            this.setVagina(vagina);
        }
        return this.getVagina();
    }
    public Double getVaginaCapacity() {
        if(!this.hasVagina()) {
            return 0.0;
        }
        Double capacity = 0.0;
        if(this.lowerBody == LowerBodyType.NAGA) {
            capacity += 20.0;
        }
        if(this.lowerBody == LowerBodyType.CENTAUR) {
            capacity += 50.0;
        }
        if(this.hasPerk(Perk.GIFT_WET_PUSSY)) {
            capacity += 20.0;
        }
        if(this.hasPerk(Perk.HISTORY_SLUT)) {
            capacity += 20.0;
        }
        if(this.hasPerk(Perk.HOLIDAY_ONE_TRACK_MIND)) {
            capacity += 10.0;
        }
        if(this.hasPerk(Perk.HOLIDAY_CORNUCOPIA)) {
            capacity += 30.0;
        }
        capacity += (8 * this.vagina.getLooseness()) * (1 + (this.vagina.getWetness() / 10));
        return capacity;
    }
    // Other
    public Gender getGender() {
        return Gender.get(this);
    }
}
