import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements KeyListener{
	
	int a, b, heigth, width, s_x, s_y, s2_x, s2_y;
	MyRobot myRobot = new MyRobot();
	PcRobot pcRobot = new PcRobot();
	JLabel logoLabel;
	
	public GamePanel(){
		
		s_x = 900; s_y = 900;s2_x = 900; s2_y = 900;
		a = 650; b = 650;
		
		this.setSize(702, 703);
		this.setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setFocusable(true);
		addKeyListener(this);
		
		logoLabel = new JLabel();
		logoLabel.setBounds(0, 0, 700, 700);
		ImageIcon icon = createImageIcon("/Robot_War.jpg", "Nothing");
		logoLabel.setIcon(icon);
		this.add(logoLabel);
		
		myRobot.setLocation(650, 650);
		pcRobot.setLocation(20, 20);
		this.add(myRobot);
		this.add(pcRobot);
		
		
	}
	ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	@Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 700, 0);
        g.drawLine(70, 0, 70, 700);g.drawLine(0, 70, 700, 70);
        g.drawLine(140, 0, 140, 700);g.drawLine(0, 140, 700, 140);
        g.drawLine(210, 0, 210, 700);g.drawLine(0, 210, 700, 210);
        g.drawLine(280, 0, 280, 700);g.drawLine(0, 280, 700, 280);
        g.drawLine(350, 0, 350, 700);g.drawLine(0, 350, 700, 350);
        g.drawLine(420, 0, 420, 700);g.drawLine(0, 420, 700, 420);
        g.drawLine(490, 0, 490, 700);g.drawLine(0, 490, 700, 490);
        g.drawLine(560, 0, 560, 700);g.drawLine(0, 560, 700, 560);
        g.drawLine(630, 0, 630, 700);g.drawLine(0, 630, 700, 630);
        g.drawLine(700, 0, 700, 700);g.drawLine(0, 700, 700, 700);
        
        g.setColor(Color.RED);
        g.drawRect(s_x, s_y, 100, 1);
        g.drawRect(s2_x, s2_y, 1, 100);
        
        
    }
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		
			case KeyEvent.VK_RIGHT: {
				myRobot.removeAll();
				myRobot.addIconRight();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getX()<=630){
					myRobot.setLocation(myRobot.getX() + 70, myRobot.getY() + 0);
				}
				else break;
			}break;
			case KeyEvent.VK_LEFT: {
				myRobot.removeAll();
				myRobot.addIconLeft();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getX()>=70){
					myRobot.setLocation(myRobot.getX() - 70, myRobot.getY() + 0);
				}
				else break;
			}break;
			case KeyEvent.VK_UP: {
				myRobot.removeAll();
				myRobot.addIconUp();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getY()>=70){
					myRobot.setLocation(myRobot.getX() + 0, myRobot.getY() - 70);
				}
				else break;
			}break;
			case KeyEvent.VK_DOWN: {
				myRobot.removeAll();
				myRobot.addIconDown();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getY()<=630){
					myRobot.setLocation(myRobot.getX() + 0, myRobot.getY() + 70);
				}
				else break;
			}break;
			case KeyEvent.VK_A: {
				myRobot.removeAll();
				myRobot.addIconLeft();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = myRobot.getX() - 105;
				s_y = myRobot.getY() + 14;
			}break;
			case KeyEvent.VK_D: {
				myRobot.removeAll();
				myRobot.addIconRight();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = myRobot.getX() + 35;
				s_y = myRobot.getY() + 13;
			}break;
			case KeyEvent.VK_W: {
				myRobot.removeAll();
				myRobot.addIconUp();
				myRobot.repaint();
				myRobot.revalidate();
				s_x = 900;s_y = 900;
				s2_y = myRobot.getY() - 105;
				s2_x = myRobot.getX() + 14;
			}break;
			case KeyEvent.VK_S: {
				myRobot.removeAll();
				myRobot.addIconDown();
				myRobot.repaint();
				myRobot.revalidate();
				s_x = 900;s_y = 900;
				s2_y = myRobot.getY() + 35;
				s2_x = myRobot.getX() + 15;
			}break;
			case KeyEvent.VK_ENTER: {
				this.remove(logoLabel);
				
			}
	
			default:
			break;
		}
		repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A: {
			s_x = 900;
			s_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_D: {
			s_x = 900;
			s_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_W: {
			s2_x = 900;
			s2_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_S: {
			s2_x = 900;
			s2_y = 900;
			repaint();
		}break;
	
		default:
			break;
		}
	
	}
	
}
