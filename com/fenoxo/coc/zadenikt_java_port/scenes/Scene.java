package com.fenoxo.coc.zadenikt_java_port.scenes;

import com.fenoxo.coc.zadenikt_java_port.Actor;
import com.fenoxo.coc.zadenikt_java_port.ChampionsApplet;
import com.fenoxo.coc.zadenikt_java_port.Player;

public abstract class Scene {
	public void displayText(ChampionsApplet applet, Player me, Actor enemy) {
		applet.write("This is a debug scene. Because Java won't let me use abstract statics.");
	}
}
