package com.fenoxo.coc.zadenikt_java_port;

import javax.swing.JApplet;

@SuppressWarnings("serial")
public class ChampionsApplet extends JApplet
{
	private static ChampionsApplet instance;
	
	public ChampionsApplet()
	{
		instance = this;
	}
	
	public void init()
	{
		this.setContentPane(new ChampionsUI());
	}
	
	public static ChampionsApplet getInstance()
	{
		return instance;
	}
}
