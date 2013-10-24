package com.fenoxo.coc.zadenikt_java_port.applet_parts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PictureButton extends JPanel {
	public PictureButton() {
		this.setPreferredSize(new Dimension(100, 80));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(new Color(0xFF0000));
		g2.fillRect(0, 0, 100, 80);
	}
}
