package com.fenoxo.coc.zadenikt_java_port;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JEditorPane;
import javax.swing.text.Document;

import com.fenoxo.coc.zadenikt_java_port.equipment.Armour;
import com.fenoxo.coc.zadenikt_java_port.equipment.Weapon;

@SuppressWarnings("serial")
public class ChampionsApplet extends JApplet {
	public static final String VERSION = "v0.7.10c11 (Shitty Parties)";
	
	public static ChampionsApplet thisApplet;
	
	public JEditorPane text = new JEditorPane("text/html", "");
	
	public BufferedImage imageBackground;
	
	public boolean showButtonNewGame = false;
	
	public void init() {
		thisApplet = this;
		try {
			this.imageBackground = ImageIO.read(new File("Assets/Background.jpg"));
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		this.setLayout(null);
		this.add(this.text);
		/*this.setLayout(new BorderLayout());
		this.add(new Panel());//*/
		//this.text.setEditable(false);
		this.text.setBounds(100, 100, 540, 380);
		this.text.repaint();
		this.repaint();
		Player me = new Player("Zadenikt");
		me.addPerk(Perk.GIFT_FAST);
		me.addItem(Weapon.DEBUG_GAWDSWORD_OFF);
		me.addItem(Armour.DEBUG_GAWDARMOR_OFF);
		me.printInventory();
		me.equipWeapon(1);
		me.equipArmour(2);
		me.printInventory();
		me.unequipArmour();
		me.printInventory();
		me.unequipWeapon();
		me.printInventory();
		System.out.println(this.text.getText());
		this.write("TESTINGGGG<i>inItAlIcS</i>amanaoadsfahfjuy<b>AndBOLD<u>WITHUNDERLINES</u></b>paqarasatauavawaxayaz");
		System.out.println(this.text.getText());
	}
	
	/*public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(this.imageBackground, 0, 0, this);
	}//*/
	
	public void write(String text) {
		try {
			Document doc = this.text.getDocument();
			doc.insertString(doc.getLength(), text, null);
		} catch(Exception ex) {
			ex.printStackTrace();
			this.text.setText("<b color=\"red\">Some error of some sort happened:</b>" + ex.getMessage());
		}
	}
	public void clear() { this.text.setText(""); }
	public void log(String text) { System.out.println(text); }
	public void log(Object obj) { this.log(obj.toString()); }
	
	public static void main(String ... args) {
		thisApplet = new ChampionsApplet();
		thisApplet.setVisible(true);
	}
}
