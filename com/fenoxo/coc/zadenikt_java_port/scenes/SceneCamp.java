package com.fenoxo.coc.zadenikt_java_port.scenes;

import com.fenoxo.coc.zadenikt_java_port.Game;
import com.fenoxo.coc.zadenikt_java_port.actors.Actor;
import com.fenoxo.coc.zadenikt_java_port.actors.ActorRathazul;
import com.fenoxo.coc.zadenikt_java_port.actors.Player;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Perk;

public class SceneCamp implements Scene {
	public void displayText(Player me, Actor enemy) {
		// TODO Events (Lines 1-290-ish in camp.as)
		if(Game.getTime() >= 6 && Game.getTime() <= 20) {
			Game.getUI().setButton(1, "Explore");
			if(me.hasAnyPlaces()) Game.getUI().setButton(2, "Places");
		}
		Game.getUI().setButton(3, "Inventory");
		//TODO Stash
		if(Game.getTime() > 4 && Game.getTime() < 23) {
			if(me.hasAnyFollowers()) Game.getUI().setButton(5, "Followers");
			if(me.hasAnyLovers()) Game.getUI().setButton(6, "Lovers");
			if(me.hasAnySlaves()) Game.getUI().setButton(7, "Slaves");
		}
		//Button 8 is blank, AFAIK.
		if(me.getLust() > 30.0) {
			if(me.hasPerk(Perk.HISTORY_RELIGIOUS) && me.getCorruption() <= 66) Game.getUI().setButton(9, "Meditate");
			else Game.getUI().setButton(9, "Masturbate");
		}
		if(Game.getTime() < 6 || Game.getTime() > 20) Game.getUI().setButton(10, "Sleep");
		else if(me.getFatigue() > 40 || me.getHealthPercent() <= 0.90) Game.getUI().setButton(10, "Rest");
		else Game.getUI().setButton(10, "Wait");
		if(me.hasFollower("Isabella")) {
			Game.getUI().write("Your campsite got a lot more comfortable once Isabella moved in.  Carpets cover up much of the barren ground, simple awnings tied to the rocks provide shade, and hand-made wooden furniture provides comfortable places to sit and sleep.");
			if(Game.getDay() >= 20) Game.getUI().write("You've even managed to carve some artwork into the rocks around the camp's perimeter.");
		} else if(Game.getDay() < 10) {
			Game.getUI().write("Your campsite is fairly simple at the moment.  Your tent and bedroll are set in front of the rocks that lead to the portal.  You have a small fire pit as well.");
		} else if(Game.getDay() < 20) {
			Game.getUI().write("Your campsite is starting to get a very 'lived-in' look.  The fire-pit is well defined with some rocks you've arranged around it, and your bedroll and tent have been set up in the area most sheltered by rocks.");
		} else {
			Game.getUI().write("Your new home is as comfy as a camp site can be.  The fire-pit and tent are both set up perfectly, and in good repair, and you've even managed to carve some artwork into the rocks around the camp's perimeter.");
		}
		// TODO Marble's Nursery
		// TODO Sophie's Rookery
		if(me.hasFollower("Rathazul") && ((ActorRathazul) me.getFollower("Rathazul")).hasGrownThorns()) Game.getUI().write("A thorny tree has sprouted near the center of the camp, growing a protective canopy of spiky vines around the portal and your camp.");
		else Game.getUI().write("You have a number of traps surrounding your makeshift home, but they are fairly simple and may not do much to deter a demon.");
		Game.getUI().write("The portal shimmers in the background as it always does, looking menacing and reminding you of why you came.\n\n");
		// TODO Ember's Minotaur Kills
		// TODO Marae's Tree-daughter
		// TODO Lines 362-1312 in camp.as
		if(Game.getTime() < 6 || Game.getTime() > 20) Game.getUI().write("It is dark out, made worse by the lack of stars in the sky.  A blood-red moon hangs in the sky, seeming to watch you, but providing little light.  It's far too dark to leave camp.\n");
		else Game.getUI().write("It's light outside, a good time to explore and forage for supplies with which to fortify your camp.\n");
	}
	public Scene action(int button) { // TODO Implement
		/*if(button == 1) return new SceneExplore();
		else if(button == 2) return new ScenePlaces();
		else if(button == 3) return new SceneInventory();
		else if(button == 4) return new SceneStash();
		else if(button == 5) return new SceneFollowers();
		else if(button == 6) return new SceneLovers();
		else if(button == 7) return new SceneSlaves();
		else if(button == 9) return new SceneMasturbate();
		else if(button == 10) return new SceneWait();
		else */return null;
	}
}
