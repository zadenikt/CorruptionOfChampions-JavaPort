package com.fenoxo.coc.zadenikt_java_port;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.fenoxo.coc.zadenikt_java_port.util.UIHelper;

public class ChampionsApplication extends JFrame implements WindowListener, ChampionsController
{
	private static final long serialVersionUID = -8777019235616199971L;
	
	private static ChampionsApplication instance;
	
	private ChampionsUI ui;
	
	private ChampionsApplication(final String[] args)
	{
		super("Corruption of Champions (Java Port) " + Constants.VERSION);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
		ui = new ChampionsUI();
		
		this.setContentPane(ui);
		
		Game.init(this);
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		if(UIHelper.confirm("Exit?", "Are you sure you wish to exit?"))
		{
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
	
	@Override
	public void windowOpened(WindowEvent e){}

	@Override
	public void windowClosed(WindowEvent e){}

	@Override
	public void windowIconified(WindowEvent e){}

	@Override
	public void windowDeiconified(WindowEvent e){}

	@Override
	public void windowActivated(WindowEvent e){}

	@Override
	public void windowDeactivated(WindowEvent e){}
	
	public static void main(final String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JOptionPane.getRootFrame().setUndecorated(false);
		
		instance = new ChampionsApplication(args);
		instance.addWindowListener(instance);
		
		for(int i = 1; i <= 10; i++)
		{
			Game.getUI().setButton(i, "Test " + i);
		}
	}
	
	public static ChampionsApplication getInstance()
	{
		return instance;
	}

	@Override
	public ChampionsUI getUI()
	{
		return ui;
	}
}
