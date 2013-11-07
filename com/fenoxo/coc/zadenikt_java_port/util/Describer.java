package com.fenoxo.coc.zadenikt_java_port.util;

import com.fenoxo.coc.zadenikt_java_port.actors.Actor;
import com.fenoxo.coc.zadenikt_java_port.characteristics.ArmType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Cock;
import com.fenoxo.coc.zadenikt_java_port.characteristics.EarType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.EyeType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.FaceType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Gender;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Hair;
import com.fenoxo.coc.zadenikt_java_port.characteristics.HornType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.LowerBodyType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Skin;
import com.fenoxo.coc.zadenikt_java_port.characteristics.StatusEffect;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Tail;
import com.fenoxo.coc.zadenikt_java_port.characteristics.TongueType;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Vagina;
import com.fenoxo.coc.zadenikt_java_port.characteristics.WingType;

public class Describer {
    public static String describeBodyType(Actor actor) {
        Boolean curvy = (Gender.get(actor) == Gender.HERM 
                || actor.largestBreasts().getSize() > 3
                || actor.getHips() > 7 || actor.getButt() > 7);
        Boolean curvier = (Gender.get(actor) == Gender.HERM 
                || actor.largestBreasts().getSize() > 4
                || actor.getHips() > 10 || actor.getButt() > 10);
        return (isSkeletal(actor)) ?
                ((isHeavyweight(actor)) ? "a lithe body covered in highly visible muscles"
             : (isMiddleweight(actor)) ? "an incredibly thin, well-muscled frame"
             : (isWelterweight(actor)) ? "a very thin body that has a good bit of muscle definition"
             : (isLightweight(actor)) ? "a lithe body and only a little bit of muscle definition"
             : "a waif-thin body, and soft, forgiving flesh")
        : (isWaifish(actor)) ?
                ((isHeavyweight(actor)) ? "a thin body and incredible muscle definition"
             : (isMiddleweight(actor)) ? "a narrow frame that shows off your muscles"
             : (isWelterweight(actor)) ? "a somewhat lithe body and a fair amount of definition"
             : (isLightweight(actor)) ? "a narrow, soft body that still manages to show off a few muscles"
             : "a thin, soft body")
        : (isThin(actor)) ? //Somewhat thin
                ((isHeavyweight(actor)) ? "a fit, somewhat thin body and rippling muscles all over"
             : (isMiddleweight(actor)) ? "a thinner-than-average frame and great muscle definition"
             : (isWelterweight(actor)) ? "a somewhat narrow body and a decent amount of visible muscle"
             : (isLightweight(actor)) ? "a moderately thin body, soft curves, and only a little bit of muscle"
             : "a fairly thin form and soft, cuddle-able flesh")
        : (isAverage(actor)) ? //average
                ((isHeavyweight(actor)) ? "average thickness and a bevy of perfectly defined muscles"
             : (isMiddleweight(actor)) ? "an average-sized frame and great musculature"
             : (isWelterweight(actor)) ? "a normal waistline and decently visible muscles"
             : (isLightweight(actor)) ? "an average body and soft, unremarkable flesh"
             : "an average frame and soft, unactor.toned flesh with a tendency for jiggle")
        : (isLarger(actor)) ?
                ((isHeavyweight(actor)) ? "a somewhat thick body that's covered in slabs of muscle"
             : (isMiddleweight(actor)) ? "a body that's a little bit wide and has some highly-visible muscles"
             : (isWelterweight(actor)) ? "a solid build that displays a decent amount of muscle"
             : (isLightweight(actor)) ? "a slightly wide frame that displays your curves "
                     + "and has hIntegers of muscle underneath"
             : "a soft, plush body with plenty of jiggle")
        : (isHefty(actor)) ?
                (((isHeavyweight(actor)) ? "a thickset frame that gives you the appearance of a wall of muscle"
             : (isMiddleweight(actor)) ? "a burly form and plenty of muscle definition"
             : (isWelterweight(actor)) ? "a solid, thick frame and a decent amount of muscles"
             : (isLightweight(actor)) ? "a wide-set body, some soft, forgiving flesh,"
                     + " and a hInteger of muscle underneath it"
             : "a wide, cushiony body")
                     + ((curvy) ? " and plenty of jiggle on your curves" : ""))
        :
                ((isHeavyweight(actor)) ? "an extremely thickset frame and so much muscle others would find you"
                        + " harder to move than a huge boulder"
             : (isMiddleweight(actor)) ? "a very wide body and enough muscle to make you look like a tank"
             : (isWelterweight(actor)) ? "an extremely substantial frame packing a decent amount of muscle"
             : (isLightweight(actor)) ? String.format("a very wide body%s and hints of muscle underneath",
                     (curvier) ? ", lots of curvy jiggles," : "")
             : String.format("a thick%s body and plush, %s",
                     (curvier) ? ", voluptuous" : "", (curvier) ? " jiggly curves" : " soft flesh"));
    }
    public static String describeSkin(Actor actor) {
    	//TODO
    	return null;
    }

    public static Integer humanScore(Actor actor) {
        Integer score = getScore(
			(actor.getFace() == FaceType.NORMAL),
            (actor.getSkin().getType() == Skin.Type.NORMAL),
            (actor.getHorns() == HornType.NONE),
            (actor.getTail().getType() == Tail.Type.NONE),
            (actor.getWings() == WingType.NONE),
            (actor.getLowerBody() == LowerBodyType.NORMAL),
            (actor.getCockCount() == 1 && actor.getCockTypeCount(Cock.Type.NORMAL) == 1),
            (actor.getBreastRowsCount() == 1 && actor.getSkin().getType() == Skin.Type.NORMAL));
        return score;
    }
    public static Integer demonScore(Actor actor) {
        Integer score = getScore(
            (actor.getHorns() == HornType.DEMONIC),
            (actor.getTail().getType() == Tail.Type.DEMONIC),
            (actor.getWings() == WingType.DEMONIC),
            (actor.getWings() == WingType.DEMONIC_LARGE),
            (actor.getSkin().getType() == Skin.Type.NORMAL && actor.getCorruption() > 50),
            (actor.getFace() == FaceType.NORMAL && actor.getCorruption() > 50),
            (actor.getLowerBody() == LowerBodyType.DEMON_CLAWS),
            (actor.getLowerBody() == LowerBodyType.DEMON_HEELS),
            (actor.getCockTypeCount(Cock.Type.DEMON) > 0));
        return score;
    }
    public static Integer minotaurScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.COW),
                (actor.getEars() == EarType.COW),
                (actor.getTail().getType() == Tail.Type.COW),
                (actor.getHorns() == HornType.MINOTAUR));
        if (score > 0) {
            score += getScore(
                    (actor.getLowerBody() == LowerBodyType.HOOVES),
                    (actor.getHeight() > 80.0),
                    (actor.getCockCount() > 0 && actor.getCockTypeCount(Cock.Type.HORSE) > 0));
        }
        if (score > 0) {
            score -= getScore(
                    (actor.hasVagina()));
        }
        return score;
    }
    public static Integer cowScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.NORMAL),
                (actor.getEars() == EarType.COW),
                (actor.getTail().getType() == Tail.Type.COW),
                (actor.getHorns() == HornType.MINOTAUR),
                (actor.hasVagina()));
        score -= (actor.getFace() == FaceType.COW) ? 1 : 0;
        if (score > 0) {
            score += getScore(
                    (actor.getLowerBody() == LowerBodyType.HOOVES),
                    (actor.getHeight() >= 73.0),
                    (actor.largestBreasts().getSize() > 4.0),
                    (actor.lactatestBreasts().getLactation() > 2.0));
        }
        return score;
    }
    public static Integer sandTrapScore(Actor actor) {
        Integer score = getScore(
                (actor.hasStatusEffect(StatusEffect.BLACK_NIPPLES)),
                (actor.hasVagina() && actor.getVagina().getType() == Vagina.Type.SANDTRAP),
                (actor.getEyes() == EyeType.SAND_TRAP),
                (actor.getWings() == WingType.SAND_TRAP));
        return score;
    }
    public static Integer beeScore(Actor actor) {
        Integer score = getScore(
                (actor.getHair().getColour() == Hair.Colour.SHINY_BLACK),
                (actor.getHair().getColour() == Hair.Colour.BLACK_AND_YELLOW),
                (actor.hasAntennae()),
                (actor.hasAntennae() && actor.getFace() == FaceType.NORMAL),
                (actor.getLowerBody() == LowerBodyType.BEE),
                (actor.getLowerBody() == LowerBodyType.BEE && actor.hasVagina()),
                (actor.getTail().getType() == Tail.Type.BEE),
                (actor.getWings() == WingType.BEE || actor.getWings() == WingType.BEE_LARGE));
        return score;
    }
    public static Integer dogScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.DOG),
                (actor.getEars() == EarType.DOG),
                (actor.getTail().getType() == Tail.Type.DOG),
                (actor.getLowerBody() == LowerBodyType.PAWS),
                (actor.getCockTypeCount(Cock.Type.DOG) > 0),
                (actor.getBreastRowsCount() > 0),
                (actor.getBreastRowsCount() == 3));
        score -= (actor.getBreastRowsCount() > 3) ? 1 : 0;
        if (score > 0) {
            score += getScore((actor.getSkin().getType() == Skin.Type.FUR));
        }
        return score;
    }
    public static Integer foxScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.FOX),
                (actor.getEars() == EarType.FOX),
                (actor.getTail().getType() == Tail.Type.FOX),
                (actor.getLowerBody() == LowerBodyType.FOX));
        score += (score > 0 && actor.getCockTypeCount(Cock.Type.DOG) > 0) ? 1 : 0;
        score += getScore(
                (actor.getBreastRowsCount() > 1),
                (actor.getBreastRowsCount() == 3),
                (actor.getBreastRowsCount() == 4));
        score += (score > 0 && actor.getSkin().getType() == Skin.Type.FUR) ? 1 : 0;
        return score;
    }
    public static Integer catScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.CAT),
                (actor.getEars() == EarType.CAT),
                (actor.getTail().getType() == Tail.Type.CAT),
                (actor.getLowerBody() == LowerBodyType.CAT),
                (actor.getCockTypeCount(Cock.Type.CAT) > 0));
        if (score > 0) {
            score += getScore(
                    (actor.getBreastRowsCount() > 1),
                    (actor.getBreastRowsCount() == 3),
                    (actor.getSkin().getType() == Skin.Type.FUR));
        }
        score -= (actor.getBreastRowsCount() > 3) ? 2 : 0;
        return score;
    }
    public static Integer lizardScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.LIZARD),
                (actor.getEars() == EarType.SNAKE),
                (actor.getTail().getType() == Tail.Type.LIZARD),
                (actor.getLowerBody() == LowerBodyType.LIZARD),
                (actor.getCockTypeCount(Cock.Type.LIZARD) > 0),
                (actor.getHorns() == HornType.LIZARD || actor.getHorns() == HornType.QUAD_LIZARD),
                (actor.getSkin().getType() == Skin.Type.SCALES));
        return score;
    }
    public static Integer spiderScore(Actor actor) {
        Integer score = getScore(
                (actor.getEyes() == EyeType.SPIDER), // Integerentional
                (actor.getEyes() == EyeType.SPIDER),
                (actor.getFace() == FaceType.SPIDER),
                (actor.getArms() == ArmType.SPIDER),
                (actor.getTail().getType() == Tail.Type.SPIDER), // Integerentional
                (actor.getTail().getType() == Tail.Type.SPIDER));
        if (actor.getLowerBody() == LowerBodyType.DRIDER
                || actor.getLowerBody() == LowerBodyType.SPIDER)
            score += 2;
        else if (score > 0)
            score--;
        if (score > 0) {
            score -= getScore(
                    (actor.getSkin().getType() != Skin.Type.NORMAL));
        }
        return score;
    }
    public static Integer horseScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.HORSE),
                (actor.getEars() == EarType.HORSE),
                (actor.getTail().getType() == Tail.Type.HORSE),
                (actor.getLowerBody() == LowerBodyType.CENTAUR),
                (actor.getLowerBody() == LowerBodyType.HOOVES),
                (actor.getLowerBody() == LowerBodyType.MY_LITTLE_PONY));
        if (score > 0) {
            score += getScore(
                    (actor.getSkin().getType() == Skin.Type.FUR));
        }
        return score;
    }
    public static Integer kitsuneScore(Actor actor) {
        Integer score = getScore(
                (actor.getEars() == EarType.FOX),
                (actor.getTail().getType() == Tail.Type.FOX),
                (actor.getTail().getType() == Tail.Type.FOX && actor.getTail().getVenom() >= 2.0), // Integerentional
                (actor.getTail().getType() == Tail.Type.FOX && actor.getTail().getVenom() >= 2.0),
                (actor.getVaginaCapacity() >= 8000));
        if (score > 0) {
                score += getScore(
                        (actor.getFace() == FaceType.NORMAL),
                        (actor.getHair().getColour() == Hair.Colour.GOLDEN_BLONDE),
                        (actor.getHair().getColour() == Hair.Colour.BLACK),
                        (actor.getHair().getColour() == Hair.Colour.RED),
                        (actor.getHair().getColour() == Hair.Colour.WHITE),
                        (actor.getHair().getColour() == Hair.Colour.SILVER_BLONDE),
                        (actor.getFemininity() >= 40));
        }
        score -= getScore(
                (actor.getSkin().getType() == Skin.Type.NORMAL),
                (actor.getSkin().getType() != Skin.Type.FUR), // Integerentional
                (actor.getSkin().getType() != Skin.Type.FUR),
                (actor.getLowerBody() != LowerBodyType.NORMAL),
                (actor.getFace() != FaceType.NORMAL),
                (actor.getEars() != EarType.FOX),
                (actor.getTail().getType() != Tail.Type.FOX));
        return score;
    }
    public static Integer dragonScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.DRAGON),
                (actor.getEars() == EarType.DRAGON),
                (actor.getTail().getType() == Tail.Type.DRAGON),
                (actor.getTongue() == TongueType.DRAGON),
                (actor.getCockTypeCount(Cock.Type.DRAGON) > 0),
                (actor.getWings() == WingType.DRAGON),
                (actor.getWings() == WingType.DRAGON_LARGE), // Integerentional, Counts twice
                (actor.getWings() == WingType.DRAGON_LARGE), // Integerentional, Counts twice
                (actor.getLowerBody() == LowerBodyType.DRAGON));
        if (score > 0) {
            score += getScore(
                    (actor.getSkin().getType() == Skin.Type.SCALES));
        }
        score += (actor.getSkin().getType() == Skin.Type.SCALES && score > 0) ? 1 : 0;
        return score;
    }
    public static Integer goblinScore(Actor actor) {
        Integer score = getScore(
                (actor.getEars() == EarType.DRAGON), // 4
                (actor.getSkin().getTone() == Skin.Tone.PALE_YELLOW),
                (actor.getSkin().getTone() == Skin.Tone.GRAYISH_BLUE),
                (actor.getSkin().getTone() == Skin.Tone.GREEN),
                (actor.getSkin().getTone() == Skin.Tone.DARK_GREEN));
        if (score > 0) {
            score += getScore(
                    (actor.getFace() == FaceType.NORMAL), // 0
                    (actor.getHeight() < 48),
                    (actor.hasVagina()),
                    (actor.getLowerBody() == LowerBodyType.NORMAL)); // 0
        }
        return score;
    }
    public static Integer gooScore(Actor actor) {
        Integer score = getScore(
                (actor.getHair().getType() == Hair.Type.GOO), // 3
                (actor.getSkin().getType() == Skin.Type.GOO), // "slimy"
                (actor.getLowerBody() == LowerBodyType.GOO), // 8
                (actor.getVaginaCapacity() > 9000),
                (actor.hasStatusEffect(StatusEffect.SLIME_CRAVING)));
        return score;
    }
    public static Integer nagaScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.NAGA), // 5
                (actor.getTongue() == TongueType.SNAKE)); // 1
        if (score > 0) {
            score += getScore(
                    (!actor.hasAntennae()),
                    (actor.getWings() == WingType.NONE));
        }
        return score;
    }
    public static Integer rabbitScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.RABBIT),
                (actor.getTail().getType() == Tail.Type.RABBIT),
                (actor.getEars() == EarType.RABBIT ),
                (actor.getLowerBody() == LowerBodyType.RABBIT));
        if (score > 0) {
            score -= getScore(
                    (actor.getBalls().getCount() > 2));
        }
        if (score > 0) {
            score += getScore(
                    (actor.getSkin().getType() == Skin.Type.FUR),
                    (!actor.hasAntennae()),
                    (actor.getWings() == WingType.NONE));
        }
        return score;
    }
    public static Integer harpyScore(Actor actor) {
        Integer score = getScore(
                (actor.getArms() == ArmType.HARPY),
                (actor.getHair().getType() == Hair.Type.FEATHER),
                (actor.getWings() == WingType.BIRD),
                (actor.getTail().getType() == Tail.Type.HARPY),
                (actor.getLowerBody() == LowerBodyType.HARPY));
        if (score > 0) {
            score += getScore(
                    (actor.getFace() == FaceType.NORMAL),
                    (actor.getEars() == EarType.NORMAL),
                    (actor.getEars() == EarType.ELF));
        }
        return score;
    }
    public static Integer kangarooScore(Actor actor) {
        Integer score = getScore(
                (actor.getCockTypeCount(Cock.Type.KANGAROO) > 0),
                (actor.getEars() == EarType.KANGAROO),
                (actor.getTail().getType() == Tail.Type.KANGAROO),
                (actor.getLowerBody() == LowerBodyType.KANGAROO),
                (actor.getFace() == FaceType.KANGAROO));
        if (score >= 2) {
            score += getScore(
                    (actor.getSkin().getType() == Skin.Type.FUR));
        }
        return score;
    }
    public static Integer sharkScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() == FaceType.SHARK),
                (actor.getWings() == WingType.SHARK_FIN),
                (actor.getTail().getType() == Tail.Type.SHARK));
        return score;
    }
    public static Integer mutantScore(Actor actor) {
        Integer score = getScore(
                (actor.getFace() != FaceType.NORMAL),
                (actor.getSkin().getType() != Skin.Type.NORMAL),
                (actor.getTail() != null || actor.getTail().getType() != Tail.Type.NONE),
                (actor.getCockCount() > 1),
                (actor.hasCock() && actor.hasVagina()),
                (actor.hasFuckableNipples()),
                (actor.getBreastRowsCount() > 1));
        if (score > 0) {
            score--;
        }
        return score;
    }
    private static Integer getScore(Boolean... values) { // Why do I feel like you came from Lisp...
        Integer score = 0;
        for (Boolean value : values) {
            score += value ? 1 : 0;
        }
        return score;
    }
    
    public static Boolean isSkeletal(Actor actor) {
        return actor.getThickness() < 10.0;
    }
    public static Boolean isWaifish(Actor actor) {
        return actor.getThickness() >= 10.0 && actor.getThickness() < 25.0;
    }
    public static Boolean isThin(Actor actor) {
        return actor.getThickness() >= 25.0 && actor.getThickness() < 40.0;
    }
    public static Boolean isAverage(Actor actor) {
        return actor.getThickness() >= 40.0 && actor.getThickness() < 60.0;
    }
    public static Boolean isLarger(Actor actor) {
        return actor.getThickness() >= 60.0 && actor.getThickness() < 75.0;
    }
    public static Boolean isHefty(Actor actor) {
        return actor.getThickness() >= 75.0 && actor.getThickness() < 90.0;
    }
    public static Boolean isChunky(Actor actor) {
        return actor.getThickness() >= 90.0;
    }
    public static Boolean isFeatherweight(Actor actor) {
        return actor.getTone() < 25.0;
    }
    public static Boolean isLightweight(Actor actor) {
        return actor.getTone() >= 25.0 && actor.getTone() < 50.0;
    }
    public static Boolean isWelterweight(Actor actor) {
        return actor.getTone() >= 50.0 && actor.getTone() < 75.0;
    }
    public static Boolean isMiddleweight(Actor actor) {
        return actor.getTone() >= 75.0 && actor.getTone() < 90.0;
    }
    public static Boolean isHeavyweight(Actor actor) {
        return actor.getTone() >= 90.0;
    }
}
