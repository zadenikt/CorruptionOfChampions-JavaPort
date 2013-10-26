package com.fenoxo.coc.zadenikt_java_port;

public class Game
{
	private static Game instance;
	private static ChampionsController controller;
	
	private Player player;
	
	private Game(ChampionsController newController)
	{
		controller = newController;
	}
	
	public static void init(ChampionsController newController)
	{
		instance = new Game(newController);
	}
	
	public static Game getInstance()
	{
		return instance;
	}
	
	public static ChampionsUI getUI()
	{
		return controller.getUI();
	}
}
