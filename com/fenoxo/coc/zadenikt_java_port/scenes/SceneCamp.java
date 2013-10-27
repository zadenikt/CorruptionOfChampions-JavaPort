package com.fenoxo.coc.zadenikt_java_port.scenes;

import com.fenoxo.coc.zadenikt_java_port.Game;
import com.fenoxo.coc.zadenikt_java_port.actors.Actor;
import com.fenoxo.coc.zadenikt_java_port.actors.Player;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Perk;

public class SceneCamp implements Scene {
	public void displayText(Player me, Actor enemy) {
		// TODO Events (Lines 1-290-ish in camp.as)
		if(me.lust > 30.0) {
			if(me.hasPerk(Perk.HISTORY_RELIGIOUS) && me.corruption <= 66) {
				Game.getUI().setButton(9, "Meditate");
			} else {
				Game.getUI().setButton(9, "Masturbate");
			}
		}
		// TODO if(Isabella)print(stuff)
		if(me.getDays() < 10) {
			Game.getUI().write("Your campsite is fairly simple at the moment.  Your tent and bedroll are set in front of the rocks that lead to the portal.  You have a small fire pit as well.");
		} else if(me.getDays() < 20) {
			Game.getUI().write("Your campsite is starting to get a very 'lived-in' look.  The fire-pit is well defined with some rocks you've arranged around it, and your bedroll and tent have been set up in the area most sheltered by rocks.");
		} else {
			Game.getUI().write("Your new home is as comfy as a camp site can be.  The fire-pit and tent are both set up perfectly, and in good repair, and you've even managed to carve some artwork into the rocks around the camp's perimeter.");
		}
		// TODO Marble's Nursery
		// TODO Sophie's Rookery
		if(false) {// TODO Rathazul's Thorns
			Game.getUI().write("A thorny tree has sprouted near the center of the camp, growing a protective canopy of spiky vines around the portal and your camp.");
		} else {
			Game.getUI().write("You have a number of traps surrounding your makeshift home, but they are fairly simple and may not do much to deter a demon.");
		}
		Game.getUI().write("The portal shimmers in the background as it always does, looking menacing and reminding you of why you came.\n\n");
		// TODO Ember's Minotaur Kills
		// TODO Marae's Tree-daughter
		// TODO Lines 362-1312 in camp.as
		
	}
	public Scene action(int button) {
		return null;
	}
}
