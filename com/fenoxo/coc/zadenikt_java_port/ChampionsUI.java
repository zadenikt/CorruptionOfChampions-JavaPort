package com.fenoxo.coc.zadenikt_java_port;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class ChampionsUI extends JPanel
{
	private JPanel sidebar;
	private JEditorPane output;
	private JButton[] buttons = new JButton[10];
	
	public ChampionsUI()
	{
		super(null);
		this.setBounds(0, 0, 800, 600);
		
		output = new JEditorPane();
		output.setBounds(200, 0, 600, 500);
		output.setEditable(false);
		
		this.add(output);
		
		sidebar = new JPanel(null);
		sidebar.setBounds(0, 0, 200, 500);
		
		this.add(sidebar);
		
		JPanel buttonPanel = new JPanel(null);
		buttonPanel.setBounds(200, 500, 600, 100);
		
		for(int i = 0; i < buttons.length; i++)
		{
			int rowOffset = (i > 4) ? 30 : 0,
					columnOffset = (i > 4) ? 120 * (i - 5) : 120 * i;
			
			buttons[i] = new JButton();
			buttons[i].setBounds(columnOffset, rowOffset, 120, 30);
			buttons[i].setVisible(false);
			
			buttonPanel.add(buttons[i]);
		}
		
		this.add(buttonPanel);
	}
	
	public void write(String text)
	{
		write(text, false);
	}
	
	public void write(String text, boolean clear)
	{
		//TODO: Implement
	}
	
	public void clear()
	{
		//TODO: Implement
	}
	
	public void setButton(int index, String label)
	{
		buttons[index - 1].setText(label);
		buttons[index - 1].setVisible(true);
		
		//TODO: Link encounter to button. Use a table of some kind for fast lookups.
	}
	
	public void clearButton(int index)
	{
		buttons[index - 1].setText("");
		buttons[index - 1].setVisible(false);
	}
}
