package com.fenoxo.coc.zadenikt_java_port.actors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fenoxo.coc.zadenikt_java_port.characteristics.ArmType;
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
import com.fenoxo.coc.zadenikt_java_port.equipment.Item;
import com.fenoxo.coc.zadenikt_java_port.equipment.Weapon;

/** NOTES:
 * getXPToLevelUpTease is slightly different than the real algorithm. Maybe.
 *         I couldn't really tell what the real algorithm was doing.
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
    protected Set<Perk> perks = new HashSet<>();
    protected Set<StatusEffect> statusEffects = new HashSet<>();
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
    public List<Cock> cocks = new ArrayList<>();
    public List<BreastRow> breasts = new ArrayList<>();
    public Vagina vagina;
    
    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.getName();
    }

    public String getDescription() {
        return this.description;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getToughness() {
        return this.toughness;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getLibido() {
        return this.libido;
    }

    public int getSensitivity() {
        return this.sensitivity;
    }

    public int getLust() {
        return this.lust;
    }

    public int getFatigue() {
        return this.fatigue;
    }

    public int getCorruption() {
        return this.corruption;
    }

    public boolean hasStatusEffect(StatusEffect se) {
        return this.statusEffects.contains(se);
    }

    public int getMaxHealth() {
        int max = 50 + (2 * this.getToughness());
        if (this.hasPerk(Perk.LEVELUP_TANK)) {
            max += 50;
        }
        if (this.hasPerk(Perk.LEVELUP_TANK_2)) {
            max += this.getToughness();
        }
        max += 15 * ((this.getLevel() <= 20) ? this.getLevel() : 20);
        return ((max > 999) ? 999 : max);
    }

    public int getCurHealth() {
        return this.health;
    }

    public int getHealth() {
        return this.getCurHealth();
    }

    public int getHealthPercent() {
        return this.getCurHealth() / this.getMaxHealth();
    }

    public int getLevel() {
        return this.level;
    }

    public int getXP() {
        return this.xp;
    }

    public int getXPToLevelUp() {
        return this.getLevel() * 100;
    }

    public int getXPToLevelUpRemaining() {
        return this.getXPToLevelUp() - this.getXP();
    }

    public int getLevelTease() {
        return this.levelTease;
    }

    public int getXPTease() {
        return this.xpTease;
    }

    public int getXPToLevelUpTease() {
        if (this.getLevelTease() >= 5) {
            return -1;
        }
        return (int) (Math.floor(10 + (5 * Math.pow(this.getLevelTease() + 1, 2)))); // TODO
                                                                                                                                                                 // Is
                                                                                                                                                                 // this
                                                                                                                                                                 // the
                                                                                                                                                                 // right
                                                                                                                                                                 // formula?
                                                                                                                                                                // *Shudder*...
    }

    public int getXPToLevelUpTeaseRemaining() {
        return this.getXPToLevelUpTease() - this.getXPTease();
    }

    public Gender getGender() {
        return Gender.get(this);
    }

    public int getCockCount() {
        return this.cocks.size();
    }

    public boolean hasCock() {
        return this.getCockCount() > 0;
    }

    public boolean hasVagina() {
        return this.vagina != null;
    }

    public Vagina getVagina() {
        return this.vagina;
    }

    public void setVagina(Vagina v) {
        this.vagina = v;
    }
    public Vagina ifNoVaginaMakeOne() {
        return this.ifNoVaginaMakeOne(new Vagina());
    }
    public Vagina ifNoVaginaMakeOne(Vagina vagina) {
        if (!this.hasVagina()) {
            this.setVagina(vagina);
        }
        return this.getVagina();
    }
    public double getVaginaCapacity() {
        if (this.getVagina() == null) {
            return 0;
        }
        double capacity = 0.0;
        if (this.lowerBody == LowerBodyType.NAGA) {
            capacity += 20.0;
        }
        if (this.lowerBody == LowerBodyType.CENTAUR) {
            capacity += 50.0;
        }
        if (this.hasPerk(Perk.GIFT_WET_PUSSY)) {
            capacity += 20.0;
        }
        if (this.hasPerk(Perk.HISTORY_SLUT)) {
            capacity += 20.0;
        }
        if (this.hasPerk(Perk.HOLIDAY_ONE_TRACK_MIND)) {
            capacity += 10.0;
        }
        if (this.hasPerk(Perk.HOLIDAY_CORNUCOPIA)) {
            capacity += 30.0;
        }
        capacity += (8 * this.vagina.getLooseness()) * (1 + (this.vagina.getWetness() / 10));
        return capacity;
    }

    public int getBreastRowsCount() { return this.breasts.size(); }
    public BreastRow largestBreasts() {
        BreastRow largest = this.breasts.get(0);
        for(BreastRow boobies : this.breasts)
            if (boobies.getSize() > largest.getSize())
                largest = boobies;
        return largest;
    }
    public BreastRow lactatestBreasts() {
        BreastRow lactatestIsTooAWord = this.breasts.get(0);
        for(BreastRow boobies : this.breasts)
            if (boobies.getLactation() > lactatestIsTooAWord.getSize())
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
        for(BreastRow row : this.breasts) {
            if (row.isFuckable()) {
                return true;
            }
        }
        return false;
    }

    public int getCockTypeCount(Cock.Type type) {
        int count = 0;
        for(Cock c : this.cocks) {
            if (c.getType() == type) {
                count++;
            }
        }
        return count;
    }
    
    public boolean hasTail() {
        return this.tail != null
                && this.tail.getType() != Tail.Type.NONE;
    }
    
    public void addPerk(Perk p) {
        if (!this.hasPerk(p)) {
            this.perks.add(p);
            p.add(this);
        }
    }
    public void removePerk(Perk p) {
        if (this.hasPerk(p)) {
            this.perks.remove(p);
            p.remove(this);
        }
    }
    public boolean hasPerk(Perk p) {
        return this.perks.contains(p);
    }
    public boolean addItem(Item i) { //TODO Add inventory toss-out.
        int slot = this.firstEmptyItemSlot();
        if (slot == -1) {
            System.out.println(String.format(
                    "%s would've got the item %s, but their inventory is full!", this.toString(), i.name));
            return false;
        }
        
        System.out.println(String.format("%s got the item %s!", this.toString(), i.name));
        this.itemSlots[slot] = i;
        this.itemSlotCounts[slot] = 1;
        return true;
    }
    public void removeItem(int slot) {
        if (this.itemSlots[slot - 1] == null) {
            this.itemSlotCounts[slot - 1] = 0;
            return;
        }
        this.itemSlotCounts[slot - 1]--;
        if (this.itemSlotCounts[slot - 1] == 0) {
            this.itemSlots[slot - 1] = null;
        }
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
            if (this.itemSlots[j] == i && this.itemSlotCounts[j] > 0) {
                return j;
            }
        }
        return -1;
    }
    
    public int firstEmptyItemSlot() {
        for(int j = 0; j < this.itemSlots.length; j++) {
            if (this.itemSlots[j] == null || this.itemSlotCounts[j] == 0) {
                return j;
            }
        }
        return -1;
    }
    
    public void setItemSlotsMax(int n) {
        if (this.itemSlots.length == n) {
            return;
        }
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
    
    public Weapon getWeapon() {
        return this.weapon;
    }

    public void equipWeapon(int slot) {
        Weapon w = (Weapon)this.itemSlots[slot - 1];
        this.removeItem(slot);
        this.equipWeapon(w);
    }
    
    public void equipWeapon(Weapon w) {
        this.unequipWeapon();
        this.weapon = w;
        System.out.println(
                String.format("%s equipped the weapon %s!", this.toString(), this.weapon.name));
    }
    
    public void unequipWeapon() {
        if (this.weapon == null) {
            return;
        }
        System.out.println(
                String.format("%s unequipped the weapon %s!", this.toString(), this.weapon.name));
        this.addItem(this.weapon);
        this.weapon = null;
    }

    public Armour getArmour() {
        return this.armour;
    }

    public void equipArmour(int slot) {
        Armour a = (Armour)this.itemSlots[slot - 1];
        this.removeItem(slot);
        this.equipArmour(a);
    }
    
    public void equipArmour(Armour newArmor) {
        this.unequipArmour();
        this.armour = newArmor;
        System.out.println(String.format("%s equipped the armor %s!", this.toString(), newArmor.name));
    }
    
    public void unequipArmour() {
        if (this.armour == null) {
            return;
        }
        System.out.println(
                String.format("%s unequipped the armour !", this.toString(), this.armour.name));
        this.addItem(this.armour);
        this.armour = null;
    }
    
    //Descriptions
    public String describeBodyType() {
        String out = "";
        if (this.thickness < 10) {
            out += (this.tone > 90) ? "a lithe body covered in highly visible muscles"
                     : (this.tone > 75) ? "an incredibly thin, well-muscled frame"
                     : (this.tone > 50) ? "a very thin body that has a good bit of muscle definition"
                     : (this.tone > 25) ? "a lithe body and only a little bit of muscle definition"
                     : "a waif-thin body, and soft, forgiving flesh";
        }
        else if (this.thickness < 25) {
            out += (this.tone > 90) ? "a thin body and incredible muscle definition"
                     : (this.tone > 75) ? "a narrow frame that shows off your muscles"
                     : (this.tone > 50) ? "a somewhat lithe body and a fair amount of definition"
                     : (this.tone > 25) ? "a narrow, soft body that still manages to show off a few muscles"
                     : "a thin, soft body";
        }
        //Somewhat thin
        else if (thickness < 40) {
            out += (this.tone > 90) ? "a fit, somewhat thin body and rippling muscles all over"
                     : (this.tone > 75) ? "a thinner-than-average frame and great muscle definition"
                     : (this.tone > 50) ? "a somewhat narrow body and a decent amount of visible muscle"
                     : (this.tone > 25) ? "a moderately thin body, soft curves,"
                             + " and only a little bit of muscle"
                     : "a fairly thin form and soft, cuddle-able flesh";
        }
        //average
        else if (thickness < 60) {
            out += (this.tone > 90) ? "average thickness and a bevy of perfectly defined muscles"
                     : (this.tone > 75) ? "an average-sized frame and great musculature"
                     : (this.tone > 50) ? "a normal waistline and decently visible muscles"
                     : (this.tone > 25) ? "an average body and soft, unremarkable flesh"
                     : "an average frame and soft, unthis.toned flesh with a tendency for jiggle";
        }
        else if (thickness < 75) {
            out += (this.tone > 90) ? "a somewhat thick body that's covered in slabs of muscle"
                     : (this.tone > 75) ? "a body that's a little bit wide"
                             + " and has some highly-visible muscles"
                     : (this.tone > 50) ? "a solid build that displays a decent amount of muscle"
                     : (this.tone > 25) ? "a slightly wide frame that displays your curves "
                             + "and has hints of muscle underneath"
                     : "a soft, plush body with plenty of jiggle";
        }
        else if (thickness < 90) {
            boolean curvy = (Gender.get(this) == Gender.HERM || this.largestBreasts().getSize() > 3 
                    || this.hips > 7 || this.butt > 7);
            out += (this.tone > 90) ? "a thickset frame that gives you the appearance of"
                             + " a wall of muscle"
                     : (this.tone > 75) ? "a burly form and plenty of muscle definition"
                     : (this.tone > 50) ? "a solid, thick frame and a decent amount of muscles"
                     : (this.tone > 25) ? "a wide-set body, some soft, forgiving flesh,"
                             + " and a hint of muscle underneath it"
                     : "a wide, cushiony body";
            out += (curvy) ? " and plenty of jiggle on your curves" : "";
        } else {//Chunky monkey
            boolean curvy = (Gender.get(this) == Gender.HERM || this.largestBreasts().getSize() > 4 
                    || this.hips > 10 || this.butt > 10);
            out += (this.tone > 90) ? "an extremely thickset frame and "
                             + "so much muscle others would find you harder to move than a huge boulder"
                     : (this.tone > 75) ? "a very wide body and enough muscle to make you look like a tank"
                     : (this.tone > 50) ? "an extremely substantial frame packing a decent amount of muscle"
                     : (this.tone > 25) ? String.format("a very wide body%s "
                             + "and hints of muscle underneath", (curvy) ? ", lots of curvy jiggles," : "")
                     : String.format("a thick%s body and plush, %s",
                             (curvy) ? ", voluptuous" : "", (curvy) ? " jiggly curves" : " soft flesh");
        }
        return out;
    }
    
    // Scores
    public int humanScore() {
        int score = getScore(
                (this.face == FaceType.NORMAL),
                (this.skin.getType() == Skin.Type.NORMAL),
                (this.horns == HornType.NONE),
                (this.tail.getType() == Tail.Type.NONE),
                (this.wings == WingType.NONE),
                (this.lowerBody == LowerBodyType.NORMAL),
                (this.getCockCount() == 1 && this.getCockTypeCount(Cock.Type.NORMAL) == 1),
                (this.getBreastRowsCount() == 1 && this.skin.getType() == Skin.Type.NORMAL));
        return score;
    }

    public int demonScore() {
        int score = getScore(
                (this.horns == HornType.DEMONIC),
                (this.tail.getType() == Tail.Type.DEMONIC),
                (this.wings == WingType.DEMONIC),
                (this.wings == WingType.DEMONIC_LARGE),
                (this.skin.getType() == Skin.Type.NORMAL && this.corruption > 50),
                (this.face == FaceType.NORMAL && this.corruption > 50),
                (this.lowerBody == LowerBodyType.DEMON_CLAWS),
                (this.lowerBody == LowerBodyType.DEMON_HEELS),
                (this.getCockTypeCount(Cock.Type.DEMON) > 0));
        return score;
    }

    public int minotaurScore() {
        int score = getScore(
                (this.face == FaceType.COW),
                (this.ears == EarType.COW),
                (this.tail.getType() == Tail.Type.COW),
                (this.horns == HornType.MINOTAUR));
        if (score > 0) {
            score += getScore(
                    (this.lowerBody == LowerBodyType.HOOVES),
                    (this.height > 80.0),
                    (this.getCockCount() > 0 && this.getCockTypeCount(Cock.Type.HORSE) > 0));
        }
        if (score > 0) {
            score -= getScore(
                    (this.hasVagina()));
        }
        return score;
    }

    public int cowScore() {
        int score = getScore(
                (this.face == FaceType.NORMAL),
                (this.ears == EarType.COW),
                (this.tail.getType() == Tail.Type.COW),
                (this.horns == HornType.MINOTAUR),
                (this.hasVagina()));
        score -= (this.face == FaceType.COW) ? 1 : 0;
        if (score > 0) {
            score += getScore(
                    (this.lowerBody == LowerBodyType.HOOVES),
                    (this.height >= 73.0),
                    (this.largestBreasts().getSize() > 4.0),
                    (this.lactatestBreasts().getLactation() > 2.0));
        }
        return score;
    }

    public int sandTrapScore() {
        int score = getScore(
                (this.hasStatusEffect(StatusEffect.BLACK_NIPPLES)),
                (this.hasVagina() && this.getVagina().getType() == Vagina.Type.SANDTRAP),
                (this.eyes == EyeType.SAND_TRAP),
                (this.wings == WingType.SAND_TRAP));
        return score;
    }

    public int beeScore() {
        int score = getScore(
                (this.hair.getColour() == Hair.Colour.SHINY_BLACK),
                (this.hair.getColour() == Hair.Colour.BLACK_AND_YELLOW),
                (this.antennae),
                (this.antennae && this.face == FaceType.NORMAL),
                (this.lowerBody == LowerBodyType.BEE),
                (this.lowerBody == LowerBodyType.BEE && this.hasVagina()),
                (this.tail.getType() == Tail.Type.BEE),
                (this.wings == WingType.BEE || this.wings == WingType.BEE_LARGE));
        return score;
    }

    public int dogScore() {
        int score = getScore(
                (this.face == FaceType.DOG),
                (this.ears == EarType.DOG),
                (this.tail.getType() == Tail.Type.DOG),
                (this.lowerBody == LowerBodyType.PAWS),
                (this.getCockTypeCount(Cock.Type.DOG) > 0),
                (this.getBreastRowsCount() > 0),
                (this.getBreastRowsCount() == 3));
        score -= (this.getBreastRowsCount() > 3) ? 1 : 0;
        if (score > 0) {
            score += getScore((this.skin.getType() == Skin.Type.FUR));
        }
        return score;
    }

    public int foxScore() {
        int score = getScore(
                (this.face == FaceType.FOX),
                (this.ears == EarType.FOX),
                (this.tail.getType() == Tail.Type.FOX),
                (this.lowerBody == LowerBodyType.FOX));
        score += (score > 0 && this.getCockTypeCount(Cock.Type.DOG) > 0) ? 1 : 0;
        score += getScore(
                (this.getBreastRowsCount() > 1),
                (this.getBreastRowsCount() == 3),
                (this.getBreastRowsCount() == 4));
        score += (score > 0 && this.skin.getType() == Skin.Type.FUR) ? 1 : 0;
        return score;
    }

    public int catScore() {
        int score = getScore(
                (this.face == FaceType.CAT),
                (this.ears == EarType.CAT),
                (this.tail.getType() == Tail.Type.CAT),
                (this.lowerBody == LowerBodyType.CAT),
                (this.getCockTypeCount(Cock.Type.CAT) > 0));
        if (score > 0) {
            score += getScore(
                    (this.getBreastRowsCount() > 1),
                    (this.getBreastRowsCount() == 3),
                    (this.skin.getType() == Skin.Type.FUR));
        }
        score -= (this.getBreastRowsCount() > 3) ? 2 : 0;
        return score;
    }

    public int lizardScore() {
        int score = getScore(
                (this.face == FaceType.LIZARD),
                (this.ears == EarType.SNAKE),
                (this.tail.getType() == Tail.Type.LIZARD),
                (this.lowerBody == LowerBodyType.LIZARD),
                (this.getCockTypeCount(Cock.Type.LIZARD) > 0),
                (this.horns == HornType.LIZARD || this.horns == HornType.QUAD_LIZARD),
                (this.skin.getType() == Skin.Type.SCALES));
        return score;
    }

    public int spiderScore() {
        int score = getScore(
                (this.eyes == EyeType.SPIDER), // Intentional
                (this.eyes == EyeType.SPIDER),
                (this.face == FaceType.SPIDER),
                (this.arms == ArmType.SPIDER),
                (this.tail.getType() == Tail.Type.SPIDER), // Intentional
                (this.tail.getType() == Tail.Type.SPIDER));
        if (this.lowerBody == LowerBodyType.DRIDER
                || this.lowerBody == LowerBodyType.SPIDER)
            score += 2;
        else if (score > 0)
            score--;
        if (score > 0) {
            score -= getScore(
                    (this.skin.getType() != Skin.Type.NORMAL));
        }
        return score;
    }

    public int horseScore() {
        int score = getScore(
                (this.face == FaceType.HORSE),
                (this.ears == EarType.HORSE),
                (this.tail.getType() == Tail.Type.HORSE),
                (this.lowerBody == LowerBodyType.CENTAUR),
                (this.lowerBody == LowerBodyType.HOOVES),
                (this.lowerBody == LowerBodyType.MY_LITTLE_PONY));
        if (score > 0) {
            score += getScore(
                    (this.skin.getType() == Skin.Type.FUR));
        }
        return score;
    }

    public int kitsuneScore() {
        int score = getScore(
                (this.ears == EarType.FOX),
                (this.tail.getType() == Tail.Type.FOX),
                (this.tail.getType() == Tail.Type.FOX && this.tail.getVenom() >= 2.0), // Intentional
                (this.tail.getType() == Tail.Type.FOX && this.tail.getVenom() >= 2.0),
                (this.getVaginaCapacity() >= 8000));

        if (score > 0) {
                score += getScore(
                        (this.face == FaceType.NORMAL),
                        (this.hair.getColour() == Hair.Colour.GOLDEN_BLONDE),
                        (this.hair.getColour() == Hair.Colour.BLACK),
                        (this.hair.getColour() == Hair.Colour.RED),
                        (this.hair.getColour() == Hair.Colour.WHITE),
                        (this.hair.getColour() == Hair.Colour.SILVER_BLONDE),
                        (this.femininity >= 40));
        }

        score -= getScore(
                (this.skin.getType() == Skin.Type.NORMAL),
                (this.skin.getType() != Skin.Type.FUR), // Intentional
                (this.skin.getType() != Skin.Type.FUR),
                (this.lowerBody != LowerBodyType.NORMAL),
                (this.face != FaceType.NORMAL),
                (this.ears != EarType.FOX),
                (this.tail.getType() != Tail.Type.FOX));

        return score;
    }

    public int dragonScore() {
        int score = getScore(
                (this.face == FaceType.DRAGON),
                (this.ears == EarType.DRAGON),
                (this.tail.getType() == Tail.Type.DRAGON),
                (this.tongue == TongueType.DRAGON),
                (this.getCockTypeCount(Cock.Type.DRAGON) > 0),
                (this.wings == WingType.DRAGON),
                (this.wings == WingType.DRAGON_LARGE), // Intentional, Counts twice
                (this.wings == WingType.DRAGON_LARGE), // Intentional, Counts twice
                (this.lowerBody == LowerBodyType.DRAGON));
        if (score > 0) {
            score += getScore(
                    (this.skin.getType() == Skin.Type.SCALES));
        }
        score += (this.skin.getType() == Skin.Type.SCALES && score > 0) ? 1 : 0;
        return score;
    }

    public int goblinScore() {
        int score = getScore(
                (this.ears == EarType.DRAGON), // 4
                (this.skin.getTone() == Skin.Tone.PALE_YELLOW),
                (this.skin.getTone() == Skin.Tone.GRAYISH_BLUE),
                (this.skin.getTone() == Skin.Tone.GREEN),
                (this.skin.getTone() == Skin.Tone.DARK_GREEN));
        if (score > 0) {
            score += getScore(
                    (this.face == FaceType.NORMAL), // 0
                    (this.height < 48),
                    (hasVagina()),
                    (this.lowerBody == LowerBodyType.NORMAL)); // 0
        }
        return score;
    }

    public int gooScore() {
        int score = getScore(
                (this.hair.getType() == Hair.Type.GOO), // 3
                (this.skin.getType() == Skin.Type.GOO), // "slimy"
                (this.lowerBody == LowerBodyType.GOO), // 8
                (this.getVaginaCapacity() > 9000),
                (this.hasStatusEffect(StatusEffect.SLIME_CRAVING)));
        return score;
    }

    public int nagaScore() {
        int score = getScore(
                (this.face == FaceType.NAGA), // 5
                (this.tongue == TongueType.SNAKE)); // 1
        if (score > 0) {
            score += getScore(
                    (!this.antennae),
                    (this.wings == WingType.NONE));
        }
        return score;
    }

    public int rabbitScore() {
        int score = getScore(
                (this.face == FaceType.RABBIT),
                (this.tail.getType() == Tail.Type.RABBIT),
                (this.ears == EarType.RABBIT ),
                (this.lowerBody == LowerBodyType.RABBIT));
        //More than 2 balls reduces bunny score
        /* TODO Implement Ball Counting
        if (score > 0) {
            score -= getScore(
                    (this.getBalls() > 2));
        }
        */
        if (score > 0) {
            score += getScore(
                    (this.skin.getType() == Skin.Type.FUR),
                    (!this.antennae),
                    (this.wings == WingType.NONE));
        }
        return score;
    }

    public int harpyScore() {
        int score = getScore(
                (this.arms == ArmType.HARPY),
                (this.hair.getType() == Hair.Type.FEATHER),
                (this.wings == WingType.BIRD),
                (this.tail.getType() == Tail.Type.HARPY),
                (this.lowerBody == LowerBodyType.HARPY));
        if (score > 0) {
            score += getScore(
                    (this.face == FaceType.NORMAL),
                    (this.ears == EarType.NORMAL),
                    (this.ears == EarType.ELF));
        }
        return score;
    }

    public int kangarooScore() {
        int score = getScore(
                (this.getCockTypeCount(Cock.Type.KANGAROO) > 0),
                (this.ears == EarType.KANGAROO),
                (this.tail.getType() == Tail.Type.KANGAROO),
                (this.lowerBody == LowerBodyType.KANGAROO),
                (this.face == FaceType.KANGAROO));
        if (score >= 2) {
            score += getScore(
                    (this.skin.getType() == Skin.Type.FUR));
        }
        return score;
    }

    public int sharkScore() {
        int score = getScore(
                (this.face == FaceType.SHARK),
                (this.wings == WingType.SHARK_FIN),
                (this.tail.getType() == Tail.Type.SHARK));
        return score;
    }

    public int mutantScore() {
        int score = getScore(
                (this.face != FaceType.NORMAL),
                (this.skin.getType() != Skin.Type.NORMAL),
                (this.hasTail()),
                (this.getCockCount() > 1),
                (this.hasCock() && this.hasVagina()),
                (this.hasFuckableNipples()),
                (this.getBreastRowsCount() > 1));
        if (score > 0) {
            score--;
        }
        return score;
    }

    private static int getScore(boolean... values) {
        int score = 0;
        for (boolean value : values) {
            score += value ? 1 : 0;
        }
        return score;
    }

    //DEBUG FOLLOWETH
    public void printInventory() {
        for(int i = 0; i < this.itemSlots.length; i++) {
            System.out.println(
                    String.format("%d - %dx%s",
                            (i + 1), this.itemSlotCounts[i],
                            (this.itemSlots[i] == null ? "Empty" : this.itemSlots[i].name)));
        }
    }
}
