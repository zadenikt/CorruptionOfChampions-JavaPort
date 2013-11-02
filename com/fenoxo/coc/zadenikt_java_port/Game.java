package com.fenoxo.coc.zadenikt_java_port;

import com.fenoxo.coc.zadenikt_java_port.actors.Player;

public class Game {
	private static Game instance;
	private static ChampionsController controller;
	
	private Player player;
	private Integer time, day;
	
	private Game(ChampionsController newController) { controller = newController; }
	
	public static void init(ChampionsController newController) { instance = new Game(newController); }
	public static Game getInstance() { return instance; }
	public static Player getPlayer() { return getInstance().player; }
	public static ChampionsUI getUI() { return controller.getUI(); }

	public static Integer getTime() { return getInstance().time; }
	public static Integer addTime(Integer hours) { // This'd really benefit from POINTERS. Like, a lot.
		getInstance().time += hours;
		while(getInstance().time >= 24) {
			getInstance().time -= 24;
			getInstance().day++;
		}
		return getTime();
	}
	public static Integer getDay() { return getInstance().day; }
}
