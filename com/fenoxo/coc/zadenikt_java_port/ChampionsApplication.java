package com.fenoxo.coc.zadenikt_java_port;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.fenoxo.coc.zadenikt_java_port.util.UIHelper;

@SuppressWarnings("serial")
public class ChampionsApplication extends JFrame implements WindowListener, ChampionsController {
    private static ChampionsApplication instance;
    
    private ChampionsUI ui;
    
    private ChampionsApplication(String ... args) {
        super("Corruption of Champions (Java Port) " + Constants.VERSION);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.ui = new ChampionsUI();
        this.setContentPane(ui);
        Game.init(this);
    }
    public void windowClosing(WindowEvent e) {
        if(UIHelper.confirm("Exit?", "Are you sure you wish to exit?")) {
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
    public ChampionsUI getUI() {
        return this.ui;
    }
    
    public static void main(String ... args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JOptionPane.getRootFrame().setUndecorated(false);
        instance = new ChampionsApplication(args);
        instance.addWindowListener(instance);
        for(int i = 1; i <= 10; i++) {
            Game.getUI().setButton(i, "Test " + i);
        }
    }
    public static ChampionsApplication getInstance() {
        return instance;
    }
    
    // Only because Java won't let us inheirit both JFrame and WindowAdapter
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
