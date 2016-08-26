import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {
	
	GamePanel gamePanel;
	Container container;
    JMenuBar bar;
    JMenu fileMenu,helpMenu;
    JMenuItem newGameMenuItem,exitMenuItem,aboutMenuItem,rulesMenuItem;

	public MainFrame(){
		
		this.setTitle("Robot War");
		this.setSize(717, 755);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.addMenu();this.addMenuListToFrame();
		
		gamePanel = new GamePanel();
		this.add(gamePanel);
	}
	public void addMenuListToFrame(){
		this.exitMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
	public void addMenu(){
		this.bar = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.helpMenu = new JMenu("Help");
        this.newGameMenuItem = new JMenuItem("New Game");
        this.exitMenuItem = new JMenuItem("Exit");
        this.aboutMenuItem = new JMenuItem("About");
        this.rulesMenuItem = new JMenuItem("Game Rules");
        
        this.setJMenuBar(this.bar);
        bar.setVisible(true);
        this.bar.add(this.fileMenu);this.bar.add(this.helpMenu);
        this.fileMenu.add(newGameMenuItem);this.fileMenu.add(exitMenuItem);
        this.helpMenu.add(rulesMenuItem);this.helpMenu.add(aboutMenuItem);
        
	}
	
}
