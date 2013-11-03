package com.fenoxo.coc.zadenikt_java_port.characteristics;

import com.fenoxo.coc.zadenikt_java_port.ChampionsApplet;
import com.fenoxo.coc.zadenikt_java_port.actors.Actor;

public class Perk {
    public static final Perk NULL = null;
    
    // Gifts, chosen on creation.
    public static final Perk GIFT_STRONG = new Perk("Gift: Strong");
    public static final Perk GIFT_TOUGH = new Perk("Gift: Tough");
    public static final Perk GIFT_FAST = new Perk("Gift: Fast");
    public static final Perk GIFT_SMART = new Perk("Gift: Smart");
    public static final Perk GIFT_LUSTY = new Perk("Gift: Lusty");
    public static final Perk GIFT_SENSITIVE = new Perk("Gift: Sensitive");
    public static final Perk GIFT_BIG_COCK = new Perk("Gift: Big Cock");
    public static final Perk GIFT_MESSY_ORGASMS = new Perk("Gift: Messy Orgasms");
    public static final Perk GIFT_BIG_TITS = new Perk("Gift: Big Tits");
    public static final Perk GIFT_BIG_CLIT = new Perk("Gift: Big Clit");
    public static final Perk GIFT_FERTILE = new Perk("Gift: Fertile");
    public static final Perk GIFT_WET_PUSSY = new Perk("Gift: Wet Pussy");
    
    // Histories, chosen on creation.
    public static final Perk HISTORY_ALCHEMIST = new Perk("History: Alchemist");
    public static final Perk HISTORY_FIGHTER = new Perk("History: Fighter");
    public static final Perk HISTORY_HEALER = new Perk("History: Healer");
    public static final Perk HISTORY_RELIGIOUS = new Perk("History: Religious");
    public static final Perk HISTORY_SCHOLAR = new Perk("History: Scholar");
    public static final Perk HISTORY_SLACKER = new Perk("History: Slacker");
    public static final Perk HISTORY_SLUT = new Perk("History: Slut");
    public static final Perk HISTORY_SMITH = new Perk("History: Smith");
    public static final Perk HISTORY_WHORE = new Perk("History: Whore");
    
    // "Normal" perks, gained through the Perk menu.
    // Tier 0 Perks, perks available from the beginning.
    public static final Perk LEVELUP_STRONG_BACK = new Perk("Strong Back");
    public static final Perk LEVELUP__STRONG_BACK2 = new Perk("Strong Back 2");
    public static final Perk LEVELUP_TANK = new Perk("Tank");
    public static final Perk LEVELUP_REGENERATION = new Perk("Regeneration");
    public static final Perk LEVELUP_EVADE = new Perk("Evade");
    public static final Perk LEVELUP_RUNNER = new Perk("Runner");
    public static final Perk LEVELUP_DOUBLE_ATTACK = new Perk("Double Attack");
    public static final Perk LEVELUP_PRECISION = new Perk("Precision");
    public static final Perk LEVELUP_SPELLPOWER = new Perk("Spellpower");
    public static final Perk LEVELUP_MAGE = new Perk("Mage");
    public static final Perk LEVELUP_FERTILITY_PLUS = new Perk("Fertility+");
    public static final Perk LEVELUP_HOT_BLOODED = new Perk("Hot Blooded");
    public static final Perk LEVELUP_CORRUPTED_LIBIDO = new Perk("Corrupted Libido");
    public static final Perk LEVELUP_SEDUCTION = new Perk("Seduction");
    public static final Perk LEVELUP_NYMPHOMANIA = new Perk("Nymphomania");
    public static final Perk LEVELUP_ACCLIMATION = new Perk("Acclimation");
    
    // Tier 1 Perks, In addition to each perk's individual requirements, these perks all require that the character is at least level 6.
    public static final Perk LEVELUP_THUNDEROUS_STRIKES = new Perk("TThunderous Strikes");
    public static final Perk LEVELUP_WEAPON_MASTERY = new Perk("Weapon Mastery");
    public static final Perk LEVELUP_BRUTAL_BLOWS = new Perk("Brutal Blows");
    public static final Perk LEVELUP_TANK_2 = new Perk("Tank 2");
    public static final Perk LEVELUP_REGENERATION_2 = new Perk("Regeneration 2");
    public static final Perk LEVELUP_IMMOVABLE_OBJECT = new Perk("Immovable Object");
    public static final Perk LEVELUP_SPEEDY_RECOVERY = new Perk("Speedy Recovery");
    public static final Perk LEVELUP_AGILITY = new Perk("Agility");
    public static final Perk LEVELUP_LIGHTNING_STRIKES = new Perk("Lightning Strikes");
    public static final Perk LEVELUP_TACTICIAN = new Perk("Tactician");
    public static final Perk LEVELUP_CHANNELING = new Perk("Channeling");
    public static final Perk LEVELUP_MEDICINE = new Perk("Medicine");
    public static final Perk LEVELUP_WELL_ADJUSTED = new Perk("Well Adjusted");
    public static final Perk LEVELUP_MASOCHIST = new Perk("Masochist");
    public static final Perk LEVELUP_SADIST = new Perk("Sadist");
    public static final Perk LEVELUP_AROUSING_AURA = new Perk("Arousing Aura");
    public static final Perk LEVELUP_RESISTANCE = new Perk("Resistance");
    
    // Tier 2 Perks, These perks require 12 level.
    public static final Perk LEVELUP_BERZERKER = new Perk("Berzerker");
    public static final Perk LEVELUP_RESOLUTE = new Perk("Resolute");
    public static final Perk LEVELUP_LUNGING_ATTACKS = new Perk("Lunging Attacks");
    public static final Perk LEVELUP_ARCHMAGE = new Perk("Archmage");
    public static final Perk LEVELUP_IRON_MAN = new Perk("Iron Man");
    
    // Holiday perks, given on... holidays.
    public static final Perk HOLIDAY_CORNUCOPIA = new Perk("Cornucopia");
    public static final Perk HOLIDAY_PILGRIMS_BOUNTY = new Perk("Pilgrim's Bounty");
    public static final Perk HOLIDAY_ONE_TRACK_MIND = new Perk("One Track Mind");
    public static final Perk HOLIDAY_PURE_AND_LOVING = new Perk("Pure and Loving");
    public static final Perk HOLIDAY_SENSUAL_LOVER = new Perk("Sensual Lover");
    public static final Perk HOLIDAY_FERAS_BOON_ALPHA = new Perk("Fera's Boon - Alpha");
    public static final Perk HOLIDAY_FERAS_BOON_BREEDING_BITCH = new Perk("Fera's Boon - Breeding Bitch");
    public static final Perk HOLIDAY_FERAS_BOON_MILKING_TWAT = new Perk("Fera's Boon - Milking Twat");
    public static final Perk HOLIDAY_FERAS_BOON_SEEDER = new Perk("Fera's Boon - Seeder");
    public static final Perk HOLIDAY_FERAS_BOON_WIDE_OPEN = new Perk("Fera's Boon - Wide Open");
    public static final Perk HOLIDAY_ELVEN_BOUNTY = new Perk("Elven Bounty");
    
    // Event Perks, given from doing specific events.
    public static final Perk EVENT_PERK_ANDROGYNY = new Perk("Androgyny");//given by purchasing the Androgyny treatment from Joey at Bizarre Bazaar
    public static final Perk EVENT_PERK_BASILISK_WOMB = new Perk("Basilisk Womb");//wiki says given by Beonit in Bizarre Bazaar
    public static final Perk EVENT_PERK_BEE_OVIPOSTERIOR = new Perk("Bee Oviposterior");
    public static final Perk EVENT_PERK_BROOD_MOTHER = new Perk("Brood Mother");
    public static final Perk EVENT_PERK_BUNNY_EGGS = new Perk("Bunny Eggs");
    public static final Perk EVENT_PERK_BULGE_ARMOR = new Perk("Bugle Armor");
    public static final Perk EVENT_PERK_DRAGONFIRE = new Perk("Dragonfire");
    public static final Perk EVENT_PERK_FIRE_LORD = new Perk("Fire Lord");
    public static final Perk EVENT_PERK_FLEXIBILITY = new Perk("Flexibility");
    public static final Perk EVENT_PERK_HELLFIRE = new Perk("Hellfire");
    public static final Perk EVENT_PERK_LUSTSTICK_ADAPTED = new Perk("Luststick Adapted");
    public static final Perk EVENT_PERK_MAGICAL_FERTILITY = new Perk("Magical Fertility");
    public static final Perk EVENT_PERK_MAGICAL_VIRILITY = new Perk("Magical Virility");
    public static final Perk EVENT_PERK_MARBLES_MILK = new Perk("Marble's Milk");
    public static final Perk EVENT_PERK_MARBLE_RESISTANCE = new Perk("Marble Resistance");
    public static final Perk EVENT_PERK_MARAES_GIFT_BUTTSLUT = new Perk("Marae's Gift - Buttslut");
    public static final Perk EVENT_PERK_MARAES_GIFT_FERTILITY = new Perk("Marae's Gift - Fertility");
    public static final Perk EVENT_PERK_MARAES_GIFT_PROFRACTORY = new Perk("Marae's Gift - Profractory");
    public static final Perk EVENT_PERK_MARAES_GIFT_STUD = new Perk("Marae's Gift - Stud");
    public static final Perk EVENT_PERK_MINOTAUR_CUM_ADDICT = new Perk("Minotaur Cum Addict");
    public static final Perk EVENT_PERK_MISDIRECTION = new Perk("Misdirection");
    public static final Perk EVENT_PERK_CORRUPTED_NINE_TAILS = new Perk("Corrupted Nine-Tails");
    public static final Perk EVENT_PERK_ENLIGHTENED_NINE_TAILS = new Perk("Enlightened Nine-Tails");
    public static final Perk EVENT_PERK_OMNIBUS_GIFT = new Perk("Omnibus' Gift");
    public static final Perk EVENT_PERK_SLIME_CORE = new Perk("Slime Core");
    public static final Perk EVENT_PERK_WHISPERED = new Perk("Whispered");
    
    // Item Perks, recived when a item is used or equiped.
    public static final Perk ITEM_PERK_PENT_UP = new Perk("Pent Up");//comes from the Cockring Cock-Sock
    public static final Perk ITEM_PERK_LUST_REGENERATION = new Perk("Lust Regeneration");//comes from the Viridian Cock-Sock
    public static final Perk ITEM_PERK_PHALLIC_POTENTIAL = new Perk("Phallic Potential");//comes from the Scartlet Cock-Sock
    public static final Perk ITEM_PERK_PHALLIC_RESTRAINT = new Perk("Phallic Restraint");//comes from the Cobalt Cock-Sock
    public static final Perk ITEM_PERK_MIDAS_COCK = new Perk("Midas Cock");//comes from the Gilded Cock-Sock
    public static final Perk ITEM_PERK_PIERCED_LETHITE = new Perk("Pierced: Lethite");
    public static final Perk ITEM_PERK_PIERCED_FERTITE = new Perk("Pierced: Fertite");
    public static final Perk ITEM_PERK_PIERCED_FURRITE = new Perk("Pierced: Furrite");
    public static final Perk ITEM_PERK_PIERCED_CRIMSTONE = new Perk("Pierced: Crimstone");
    public static final Perk ITEM_PERK_PURITY_BLESSING = new Perk("Purity Blessing");
    public static final Perk ITEM_PERK_SLUTTY_SEDUCTION = new Perk("Slutty Seduction");
    public static final Perk ITEM_PERK_THICK_SKIN = new Perk("Thick Skin");
    public static final Perk ITEM_PERK_WIZARDS_ENDURANCE = new Perk("Wizard's Endurance");
    public static final Perk ITEM_PERK_WIZARDS_FOCUS = new Perk("Wizard's Focus");
    public static final Perk ITEM_PERK_BIMBO_BODY = new Perk("Bimbo Body");
    public static final Perk ITEM_PERK_BIMBO_BRAINS = new Perk("Bimbo Brains");
    public static final Perk ITEM_PERK_BRO_BODY = new Perk("Bro Body");
    public static final Perk ITEM_PERK_BRO_BRAINS = new Perk("Bro Brains");
    public static final Perk ITEM_PERK_FUTA_FACULTIES = new Perk("Futa Faculties");
    public static final Perk ITEM_PERK_FUTA_FORM = new Perk("Futa Form");
    public static final Perk ITEM_PERK_BLOOD_MAGE = new Perk("Blood Mage");
    public static final Perk ITEM_PERK_DIAPAUSE = new Perk("Diapause");
    public static final Perk ITEM_PERK_HARPY_WOMB = new Perk("Harpy Womb");
    public static final Perk ITEM_PERK_INCORPOREALITY = new Perk("Incorporeality");
    public static final Perk ITEM_PERK_OVIPOSITION = new Perk("Oviposition");
    
    protected String name;

    private Perk(String name) {
        this.name = name;
    }

    public void add(Actor me) {
        System.out.println(String.format("%s got the perk %s!", me.toString(), this.name));
    }

    public void remove(Actor me) {
        System.out.println(String.format("%s lost the perk %s!", me.toString(), this.name));
    }

    // For overriding, if necessary
    public void onAttack(ChampionsApplet applet, Actor me, Actor enemy) {}
    public void onGotAttacked(ChampionsApplet applet, Actor me, Actor enemy) {}
}
